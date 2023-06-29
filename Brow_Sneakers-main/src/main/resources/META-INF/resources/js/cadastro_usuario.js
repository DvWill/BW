function cadastro_usuario(){
    alert("Usuário cadastrado, faça login para continuar!")

    fetch(getRequest("/cadastro_usuario/save", getDTO()))
        .then(response => response.json())
        .then(function(dto) {
            console.log(dto)
            alert(JSON.stringify(dto));
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
        "email": document.querySelector("#email").value,
        "password": document.querySelector("#password").value,
        "name": document.querySelector("#name").value
    }
}
