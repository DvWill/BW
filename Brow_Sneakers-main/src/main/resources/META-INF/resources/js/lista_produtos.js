function voltar(){
    window.location.href = "/menu"
}

window.addEventListener("load", () => {
    lista_produto = document.getElementById('lista_produtos');
    fetch("cadastro_produto/lista_produtos").then(res => res.json()).then((res) => {
        lista_produto.innerHTML = `
            <table>
                <thead>
                    <tr class="header-row">
                        <th>Nome</th>
                        <th>Preço</th>
                        <th>Categoria</th>
                    </tr>
                </thead>
                <tbody>
                    ${res.map((produto, index) => `
                        <tr>
                            <td>${produto.name_produto}</td>
                            <td>${produto.preco_produto}</td>
                            <td>${produto.name_categoria}</td>
                        </tr>
                    `).join(" ")}
                </tbody>
            </table>
        `;
    });
});