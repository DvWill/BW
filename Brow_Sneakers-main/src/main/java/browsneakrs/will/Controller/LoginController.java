package browsneakrs.will.Controller;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import browsneakrs.will.Model.bo.UsuarioBO;
import browsneakrs.will.Model.dto.LoginDTO;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("")//A anotação @Path("") indica que essa classe de controle manipula solicitações relacionadas à raiz do contexto da API. Isso significa que, se a API estiver sendo executada em http://localhost:8080, esse controlador responderá a solicitações em http://localhost:8080/login e http://localhost:8080/.
public class LoginController {
    @Inject
    UsuarioBO usuarioBO;
    //A anotação @Inject é usada para injetar uma instância da classe UsuarioBO nesse controlador. UsuarioBO parece ser
    // uma classe de negócios (business object) relacionada aos usuários.

    @CheckedTemplate//Essa classe interna Templates é anotada com @CheckedTemplate e contém um método estático chamado
    // login(), que retorna uma instância de TemplateInstance. Essa anotação indica que esse método está associado a um
    // modelo de template chamado "login".

    public static class Templates {
        public static native TemplateInstance login();
    }
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean login(LoginDTO loginDTO){
        return usuarioBO.login(loginDTO);
    }
    //Este é um método POST que lida com solicitações de login. A anotação @Path("login") indica que esse método é mapeado
    // para a rota /login. As anotações @Produces e @Consumes definem o tipo de mídia de entrada e saída, neste caso,
    // APPLICATION_JSON. O método recebe um objeto LoginDTO como parâmetro e retorna um valor booleano que indica se o
    // login foi bem-sucedido ou não. O método delega a lógica de login para a instância de UsuarioBO injetada anteriormente.

    @GET
    @Path("/login")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getLoginHTML(){
        return Templates.login();
    }
    //A anotação @Path("") indica que esse método responde a solicitações na raiz do contexto da API
    //(ou seja, http://localhost:8080/). A anotação @Produces(MediaType.TEXT_HTML) indica que a resposta deve ser do tipo HTML.
    //O método chama o método login() da classe Templates, que retorna uma instância de TemplateInstance. Isso
    // provavelmente é usado para renderizar a página de login em algum tipo de framework ou mecanismo de template.

}
