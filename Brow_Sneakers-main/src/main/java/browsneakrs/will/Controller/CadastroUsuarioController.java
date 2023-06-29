package browsneakrs.will.Controller;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import browsneakrs.will.Model.bo.UsuarioBO;
import browsneakrs.will.Model.dto.UsuarioDTO;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cadastro_usuario")
public class CadastroUsuarioController {

    @Inject
    UsuarioBO bo;
    //Essa linha indica que o controlador possui uma dependência injetada da classe UsuarioBO. A anotação @Inject é
    // usada para realizar a injeção de dependência e fornecer uma instância da classe UsuarioBO para o controlador.

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance cadastro_usuario();
    }
    //Essa parte define uma classe interna chamada Templates que contém um método estático cadastro_usuario(). A anotação
    // @CheckedTemplate indica que essa classe é usada para fornecer um modelo de template. O método cadastro_usuario()
    // retorna uma instância de TemplateInstance, que é um objeto usado para renderizar templates.


    @GET
    @Path("")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getCadastro_UsuarioHTML(){
        return CadastroUsuarioController.Templates.cadastro_usuario();
    }
    //Este método é anotado com @GET e @Path(""), o que significa que ele responderá a uma requisição GET para o caminho
    // base definido anteriormente ("/cadastro_usuario"). A anotação @Produces(MediaType.TEXT_HTML) indica que o método
    // produz uma resposta no formato HTML. O método retorna uma instância de template obtida chamando o método cadastro_usuario()
    // da classe Templates.


    @POST
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save (UsuarioDTO dto){
        return Response.ok(bo.save(dto)).build();
    }
    //Este método é anotado com @POST e @Path("/save"), o que significa que ele responderá a uma requisição POST para o
    // caminho "/cadastro_usuario/save". A anotação @Produces(MediaType.APPLICATION_JSON) indica que o método produz uma
    // resposta no formato JSON. A anotação @Consumes(MediaType.APPLICATION_JSON) indica que o método consome uma requisição
    // no formato JSON. O método recebe um objeto UsuarioDTO como parâmetro, chama o método save da instância bo (classe UsuarioBO)
    // passando o objeto dto e retorna uma resposta HTTP com o resultado da operação de salvamento.


}
