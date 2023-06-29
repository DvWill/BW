package browsneakrs.will.Model.dto;

import java.util.Date;

public class ProdutoDTO {
    private Integer id;

    private String name_produto;

    private String name_categoria;

    private double preco_produto;

    private Date data_validade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName_produto() {
        return name_produto;
    }

    public void setName_produto(String name_produto) {
        this.name_produto = name_produto;
    }

    public String getName_categoria() {
        return name_categoria;
    }

    public void setName_categoria(String name_categoria) {
        this.name_categoria = name_categoria;
    }

    public double getPreco_produto() {
        return preco_produto;
    }

    public void setPreco_produto(double preco_produto) {
        this.preco_produto = preco_produto;
    }

    public Date getData_validade() {
        return data_validade;
    }

    public void setData_validade(Date data_validade) {
        this.data_validade = data_validade;
    }
}
