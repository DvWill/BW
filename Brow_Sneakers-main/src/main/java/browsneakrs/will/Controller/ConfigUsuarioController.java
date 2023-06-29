package browsneakrs.will.Controller;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/config_usuario")
public class ConfigUsuarioController {
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance config_usuario();
    }

    @GET
    @Path("")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getConfig_UsuarioHTML(){
        return ConfigUsuarioController.Templates.config_usuario();
    }
    
}

