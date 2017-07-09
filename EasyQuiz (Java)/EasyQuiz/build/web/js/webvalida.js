function Responder(form) {
    var id = form.questao.value-1;
    alert(id);
    if(form.tipoQuestao.value=='A') {
        alert("eitaporra");
    } else if(form.tipoQuestao.value=='F') {
        if(document.querySelector("input[name='grupo"+id+"']:checked")!=null) {
            var alternativa = (document.querySelector("input[name='grupo"+id+"']:checked").id);
            alternativa = alternativa.substr(alternativa.length - 1);
            alternativa++;

            var letra = 64;
            var respostaCorreta = form.respostaCorreta.value;

            letra = (letra+parseInt(respostaCorreta));

            if(alternativa==respostaCorreta) {
                var resposta = document.querySelector("#resultado"+id);
                resposta.style.color='green';
                resposta.innerHTML="Parabéns! Você acertou!";
            } else {
                var resposta = document.querySelector("#resultado"+id);
                resposta.style.color='red';
                resposta.innerHTML="Você errou! Resposta: "+String.fromCharCode(letra);
            }
            if(form.logado.value==1) {
                GravarAlterarTabela(form, alternativa);
            }
        } else {
            var resposta = document.querySelector("#resultado"+id);
            resposta.style.color='orange';
            resposta.innerHTML="Selecione uma alternativa!";
        }
    }
}

function GravarAlterarTabela(form, alternativa) {
    var table = form.table.value;
    if (table == "QuestaoFechadaResposta") {
        if (form.acao.value == "gravar")
            caminhourl = "/EasyQuiz/servletweb?acao=GravarQuestaoFechadaResposta&resposta="+alternativa;
    }
    form.action = caminhourl;
    form.submit();
}

function proximaPagina(form) {
    if(parseInt(form.maxQuestao.value)<5) {
        alert("Essa é a ultima página");
    } else {
    caminhourl = "/EasyQuiz/servletweb";
    form.acao.value="ProximaPagina";
    form.action = caminhourl;
    form.submit();
    }
}

function paginaAnterior(form) {
    caminhourl = "/EasyQuiz/servletweb";
    form.acao.value="PaginaAnterior";
    form.action = caminhourl;
    form.submit();
}
