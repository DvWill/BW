package browsneakrs.will.Controller;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/lista_produtos")
public class ListaController {
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance lista_produtos();
    }

    @GET
    @Path("")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getLista_ProdutosHTML(){
        return ListaController.Templates.lista_produtos();
    }
}
