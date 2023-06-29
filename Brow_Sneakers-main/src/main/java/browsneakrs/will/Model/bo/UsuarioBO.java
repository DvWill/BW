package browsneakrs.will.Model.bo;

import browsneakrs.will.Model.entity.Usuario;
import browsneakrs.will.Model.dao.impl.UsuarioDAO;
import browsneakrs.will.Model.dto.LoginDTO;
import browsneakrs.will.Model.dto.UsuarioDTO;

import java.time.format.DateTimeFormatter;
import java.util.Objects;



import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import static java.lang.Object.*;

@Dependent
public class UsuarioBO {

    @Inject
    UsuarioDAO usuarioDAO;
    //@ConfigProperty(name = "com.brosneakrs.will,jwt.duration") public Long duration;
    //@ConfigProperty(name = "mp.jwt.verify.issuer") public String issuer;
    public Boolean save(UsuarioDTO dto) {
        usuarioDAO.insert(new Usuario(dto));
        return true;
    }
    public Boolean login(LoginDTO dto){
        Usuario usuario = usuarioDAO.findUserByEmail(dto.getEmail());
        if(usuario != null){
            return true;
        }
        return false;
    }

}
