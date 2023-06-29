package browsneakrs.will.Model.dao.impl;


import browsneakrs.will.Model.dao.AbstractDAO;
import browsneakrs.will.Model.entity.Usuario;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Dependent
public class UsuarioDAO extends AbstractDAO<Usuario> {

    private Usuario fromResultSet(ResultSet resultSet){
        try {
            while(resultSet.next()){
                return new Usuario(resultSet.getInt("id"),
                        resultSet.getString("email"), resultSet.getString("name"),
                        resultSet.getString("password"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @PostConstruct
    public void createTable() {
        StringBuilder sql = new StringBuilder();
        // language=SQL
        sql.append("CREATE TABLE IF NOT EXISTS USUARIO ")
                .append(" (id INTEGER auto_increment,")
                .append("name VARCHAR(255),")
                .append(" email VARCHAR(255), ")
                .append(" password VARCHAR(20), ")
                .append(" PRIMARY KEY (id)); ");
        try {
            connection().prepareStatement(sql.toString()).executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
    }

    @Override
    public void insert(Usuario entity) {
        try {
            // language=SQL
            PreparedStatement ps = preparedStatement("INSERT INTO USUARIO (name, email, password) VALUES (?, ?, ?)");
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getEmail());
            ps.setString(3, entity.getPassword());
            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
        close();
    }

    @Override
    public void update(Usuario entity) {
        StringBuilder sql = new StringBuilder();
        // language=SQL
        sql.append("UPDATE USUARIO SET ")
                .append("name = '"+entity.getName()+"', ")
                .append("email = '"+entity.getEmail()+"', ")
                .append("sexo = '"+entity.getPassword()+"',")
                .append("WHERE id = "+entity.getId()+";");
        try {
            // language=SQL
            PreparedStatement ps = preparedStatement("UPDATE USUARIO SET name = ?, email = ?, sexo = ? WHERE id = ?;");
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getEmail());
            ps.setString(3, entity.getPassword());
            ps.setInt(4, entity.getId());
            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
    }

    @Override
    public void delete(Usuario entity) {
        try {
            // language=SQL
            PreparedStatement ps = preparedStatement("DELETE FROM Usuario WHERE id = ?;");
            ps.setInt(1, entity.getId());
            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
    }

    @Override
    public Usuario getById(Usuario entity) {
        Usuario usuario = null;
        try {
            // language=SQL
            PreparedStatement ps = preparedStatement("SELECT * FROM USUARIO WHERE id = ?");
            ps.setInt(1, entity.getId());
            usuario = fromResultSet(ps.getResultSet());
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
        return usuario;
    }

    public Usuario findUserByEmail(String email) {
        Usuario usuario = null;
        try {
            // language=SQL
            PreparedStatement ps = preparedStatement("SELECT * FROM USUARIO WHERE email = ?");
            ps.setString(1, email);
            usuario = fromResultSet(ps.executeQuery());
            System.out.println(usuario);
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
        return usuario;
    }

    @Override
    public List<Usuario> getAll() {
        List<Usuario> usuario = new ArrayList<>();
        try {
            // language=SQL
            PreparedStatement ps = preparedStatement("SELECT * FROM USUARIO");
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                usuario.add(fromResultSet(resultSet));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
        return usuario;
    }
    public Usuario getByEmail(String email, String password) {
        Usuario usuario = null;
        try{
            PreparedStatement ps = preparedStatement("SELECT * FROM USUARIO WHERE email = ? AND senha = ?");
            ps.setString(1, email);
            ps.setString(2, password);
            usuario = fromResultSet(ps.executeQuery());
            System.out.println(usuario);

        } catch (Exception e){
            e.printStackTrace();
        }
        close();

        return usuario;
    }

}
