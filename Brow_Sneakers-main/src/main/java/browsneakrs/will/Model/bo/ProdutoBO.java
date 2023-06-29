package browsneakrs.will.Model.bo;

import browsneakrs.will.Model.entity.Produto;
import browsneakrs.will.Model.dao.impl.ProdutoDAO;
import browsneakrs.will.Model.dto.ProdutoDTO;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
public class ProdutoBO {
    @Inject
    ProdutoDAO produtoDAO;

    public Boolean save(ProdutoDTO dto) {
        produtoDAO.insert(new Produto(dto));
        return true;
    }

    public List<ProdutoDTO> getAllProduto(){
        List<Produto> produtoList = produtoDAO.getAll();
        List<ProdutoDTO> produtoDTOList = produtoList.stream().map((produto) -> {
            ProdutoDTO produtoDTO = new ProdutoDTO();
            produtoDTO.setName_produto(produto.getName_produto());
            produtoDTO.setPreco_produto(produto.getPreco_produto());
            produtoDTO.setName_categoria(produto.getName_categoria());
            produtoDTO.setData_validade(produto.getData_validade());
            return produtoDTO;
        }).collect(Collectors.toList());
        return produtoDTOList;
    }
}
