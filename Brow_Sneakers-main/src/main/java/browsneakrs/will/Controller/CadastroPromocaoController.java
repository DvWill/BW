package browsneakrs.will.Controller;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//A anotação abaixo especifica que essa classe é responsável por lidar com as requisições que têm o caminho "/cadastro_promocao". Isso significa que qualquer requisição HTTP que corresponder a esse caminho será encaminhada para os métodos desta classe.
@Path("/cadastro_promocao")
public class CadastroPromocaoController {
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance cadastro_promocao();
    }

    @GET
    @Path("")// especifica que o método getCadastro_PromocaoHTML() irá tratar a rota atual, ou seja, "/cadastro_promocao". Como a anotação @Path está vazia, a rota completa será "/cadastro_promocao".
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getCadastro_PromocaoHTML(){
        return CadastroPromocaoController.Templates.cadastro_promocao();
    }
}
