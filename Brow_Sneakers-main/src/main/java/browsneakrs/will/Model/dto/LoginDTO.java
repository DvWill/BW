package browsneakrs.will.Model.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class LoginDTO {
    private String email;
    @Max(20)
    private String password;

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
