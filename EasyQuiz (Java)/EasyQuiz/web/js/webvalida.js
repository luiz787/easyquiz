function teste() {
    alert("Hy");
}

function proximaPagina(form) {
    caminhourl = "/EasyQuiz/servletweb";
    form.acao.value="ProximaPagina";
    form.action = caminhourl;
    form.submit();
}

function paginaAnterior(form) {
    caminhourl = "/EasyQuiz/servletweb";
    form.acao.value="PaginaAnterior";
    form.action = caminhourl;
    form.submit();
}