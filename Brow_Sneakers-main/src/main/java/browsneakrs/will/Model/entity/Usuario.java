package browsneakrs.will.Model.entity;

import browsneakrs.will.Model.dto.UsuarioDTO;

public class Usuario {

    private Integer id;

    private String email;

    private String password;

    private String name;

    public Usuario(){
    }
    public Usuario(UsuarioDTO dto){
        this(dto.getId(), dto.getName(), dto.getEmail(), dto.getPassword());
    }

    public Usuario(Integer id, String name, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
