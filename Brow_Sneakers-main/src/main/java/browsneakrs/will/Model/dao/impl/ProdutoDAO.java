package browsneakrs.will.Model.dao.impl;


import browsneakrs.will.Model.dao.AbstractDAO;
import browsneakrs.will.Model.entity.Produto;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Dependent
public class ProdutoDAO extends AbstractDAO<Produto> {

    private Produto fromResultSet(ResultSet resultSet){
        try {
            return new Produto(resultSet.getInt("id"),
                    resultSet.getString("name_produto"),
                    resultSet.getString("name_categoria"),
                    resultSet.getDouble("preco_produto"),
                    resultSet.getDate("data_validade"));
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @PostConstruct
    public void createTable() {
        StringBuilder sql2 = new StringBuilder();
        // language=SQL
        sql2.append("CREATE TABLE IF NOT EXISTS PRODUTO ")
                .append(" (id INTEGER auto_increment,")
                .append("name_produto VARCHAR(255),")
                .append(" name_categoria VARCHAR(255), ")
                .append(" preco_produto DOUBLE, ")
                .append(" data_validade TIMESTAMP, ")
                .append(" PRIMARY KEY (id)); ");
        try {
            connection().prepareStatement(sql2.toString()).executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
    }

    @Override
    public void insert(Produto entity) {
        try {
            // language=SQL
            PreparedStatement ps = preparedStatement("INSERT INTO PRODUTO (name_produto, name_categoria, preco_produto) VALUES (?, ?, ?)");
            ps.setString(1, entity.getName_produto());
            ps.setString(2, entity.getName_categoria());
            ps.setDouble(3, entity.getPreco_produto());
            //ps.setDate(4, (Date) entity.getData_validade());
            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
    }

    @Override
    public void update(Produto entity) {
        StringBuilder sql = new StringBuilder();
        // language=SQL
        sql.append("UPDATE PRODUTOS SET ")
                .append("name_produto = '"+entity.getName_produto()+"', ")
                .append("name_categoria = '"+entity.getName_categoria()+"', ")
                .append("preco_produto = '"+entity.getPreco_produto()+"',")
                .append("data_validade = '"+entity.getData_validade()+"',")
                .append("WHERE id = "+entity.getId()+";");
        try {
            // language=SQL
            PreparedStatement ps = preparedStatement("UPDATE PRODUTOS SET name_produto = ?, name_categoria = ?, preco_produto = ?, data_validade = ?, WHERE id = ?;");
            ps.setString(1, entity.getName_produto());
            ps.setString(2, entity.getName_categoria());
            ps.setDouble(3, entity.getPreco_produto());
            ps.setDate(4, (Date) entity.getData_validade());
            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
    }

    @Override
    public void delete(Produto entity) {
        try {
            // language=SQL
            PreparedStatement ps = preparedStatement("DELETE FROM Produto WHERE id = ?;");
            ps.setInt(1, entity.getId());
            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
    }

    @Override
    public Produto getById(Produto entity) {
        Produto produto = null;
        try {
            // language=SQL
            PreparedStatement ps = preparedStatement("SELECT * FROM PRODUTOS WHERE id = ?");
            ps.setInt(1, entity.getId());
            produto = fromResultSet(ps.getResultSet());
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
        return produto;
    }

    @Override
    public List<Produto> getAll() {
        List<Produto> produto = new ArrayList<>();
        try {
            // language=SQL
            PreparedStatement ps = preparedStatement("SELECT * FROM PRODUTO");
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                produto.add(fromResultSet(resultSet));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
        return produto;
    }
}
