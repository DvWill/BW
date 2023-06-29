package browsneakrs.will.Model.dto;

import java.sql.Date;

public class LogsDTO {
    private String url;
    private String metodo;
    private String usuario;
    private int id;
    private Date data_atual;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData_atual() {
        return data_atual;
    }

    public void setData_atual(Date data_atual) {
        this.data_atual = data_atual;
    }
}
