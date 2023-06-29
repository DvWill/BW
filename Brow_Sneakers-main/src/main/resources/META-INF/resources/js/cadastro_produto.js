function voltar(){
    window.location.href = "/menu"

}
function cadastro_produto(){

     if(Object.values(getDTO()).filter(value => value === "").length > 0)return Toastify({
         text: "Preencha todos os campos!",
         duration: 3000,
         style: {background: "red"}
     }).showToast();

    fetch(getRequest("/cadastro_produto/save", getDTO()))
        .then(response => response.json())
        .then(function(dto) {
            console.log(dto)
            return Toastify({
                text: "Produto Cadastrado!",
                duration: 3000,
                style: {background: "green"}
            }).showToast();
            // alert(JSON.stringify(dto));
        })
        .catch(function(error) {
            console.error(error);
        })
}
function getRequest(url, dto){
    return new Request(window.location.origin+url, {
        method: 'POST',
        headers: new Headers({
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }),
        body: JSON.stringify(dto)
    });

}
function getDTO(){
    return {
        "name_produto": document.querySelector("#name_produto").value,
        "name_categoria": document.querySelector("#name_categoria").value,
        "data_validade": document.querySelector("#data_validade").value,
        "preco_produto": document.querySelector("#preco_produto").value
    }
}

