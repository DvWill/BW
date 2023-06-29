package browsneakrs.will.Controller;

import browsneakrs.will.Model.bo.LogsBO;
import browsneakrs.will.Model.dto.LogsDTO;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/logs")
public class LogsController {
    @Inject
    LogsBO logsBO;

    //A anotação @Inject é usada para injetar uma instância do objeto ProdutoBO no controlador. Isso permite que o controlador acesse e utilize métodos e funcionalidades do objeto injetado.
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance logs();
    }

    @GET
    @Path("")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getLogHTML(){
        return LogsController.Templates.logs();
    }

    @POST
    @Path("save")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save (LogsDTO dto){
        return Response.ok(logsBO.save(dto)).build();

        @GET
        @Path("log")
        public Response getAllLog (){
            return Response.ok(logsBO.getAllLog()).build();
        }
    }
}

