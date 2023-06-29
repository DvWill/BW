package browsneakrs.will.Controller;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/menu")
public class MenuController {
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance menu();
    }

    @GET
    @Path("")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getMenuHTML(){
        return MenuController.Templates.menu();
    }
}
