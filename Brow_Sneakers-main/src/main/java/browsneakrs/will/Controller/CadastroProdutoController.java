package browsneakrs.will.Controller;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import browsneakrs.will.Model.bo.ProdutoBO;
import browsneakrs.will.Model.dto.ProdutoDTO;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
//A anotação @Path especifica o caminho base para acessar o recurso deste controlador. Neste caso, o recurso estará disponível em "/cadastro_produto".
@Path("/cadastro_produto")
public class CadastroProdutoController {
    @Inject
    ProdutoBO bo;
    //A anotação @Inject é usada para injetar uma instância do objeto ProdutoBO no controlador. Isso permite que o controlador acesse e utilize métodos e funcionalidades do objeto injetado.
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance cadastro_produto();
    }
    //Essa classe interna está marcada com a anotação @CheckedTemplate, indicando que é um template Qute. O método cadastro_produto() retorna uma instância de TemplateInstance que será usada para renderizar a página HTML associada a esse controlador.

    @GET
    @Path("")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getCadastro_ProdutoHTML(){
        return CadastroProdutoController.Templates.cadastro_produto();
    }
    //Esse método é invocado quando uma requisição GET é feita para o caminho "/cadastro_produto". Ele retorna uma instância do template cadastro_produto() para renderizar a página HTML correspondente ao cadastro de produto.

    @POST
    @Path("save")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save (ProdutoDTO dto){
        return Response.ok(bo.save(dto)).build();
    }
    //Esse método é invocado quando uma requisição POST é feita para o caminho "/cadastro_produto/save". Ele recebe um objeto ProdutoDTO no corpo da requisição (formato JSON) e o repassa para o método save do objeto ProdutoBO (injetado anteriormente). Em seguida, retorna uma resposta com o resultado da operação de salvamento do produto, que é convertido para JSON.

    @GET
    @Path("lista_produtos")
    public Response getAllProdutos (){
       return Response.ok(bo.getAllProduto()).build();
    }
    //Esse método é invocado quando uma requisição GET é feita para o caminho "/cadastro_produto/lista_produtos". Ele chama o método getAllProduto do objeto ProdutoBO (injetado anteriormente) para obter todos os produtos cadastrados e retorna uma resposta com esses produtos.


}
