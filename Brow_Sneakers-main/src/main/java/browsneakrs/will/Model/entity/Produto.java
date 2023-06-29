package browsneakrs.will.Model.entity;

import browsneakrs.will.Model.dto.ProdutoDTO;

import java.util.Date;

public class Produto {
    public Produto(Integer id, String name_produto, String name_categoria, double preco_produto, Date data_validade) {
        this.id = id;
        this.name_produto = name_produto;
        this.name_categoria = name_categoria;
        this.preco_produto = preco_produto;
        this.data_validade = data_validade;
    }

    public Produto(ProdutoDTO dto){
        this(dto.getId(), dto.getName_produto(), dto.getName_categoria(), dto.getPreco_produto(), dto.getData_validade());
    }
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
