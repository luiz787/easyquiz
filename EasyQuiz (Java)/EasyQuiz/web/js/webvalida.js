function Responder(form) {
    var id = form.questao.value-1;
    var contadorRespostaQuestao = form.contadorRespostaQuestao.value;
    if(contadorRespostaQuestao<10) {
        if(form.tipoQuestao.value=='A') {
            if(document.querySelector("#textArea"+id).value.length!=0) {
                var respostaBase = form.respostaBase.value;
                var resposta = document.querySelector("#respostaBase"+id);
                resposta.style.color='black';
                resposta.style.backgroundColor='lightgreen';
                resposta.innerHTML="<b>Resposta Base:</b><p>"+respostaBase+"</p>";
                if(form.logado.value!=1) {
                    ContadorRespostaQuestao(form);
                }
            } else {
                var resposta = document.querySelector("#respostaBase"+id);
                resposta.style.color='orange';
                resposta.style.backgroundColor='';
                resposta.innerHTML="Escreva alguma resposta!";
            }

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
                } else {
                    ContadorRespostaQuestao(form);
                }
            } else {
                var resposta = document.querySelector("#resultado"+id);
                resposta.style.color='orange';
                resposta.innerHTML="Selecione uma alternativa!";
            }
        }
    } else {
        alert("Voce excedeu o limite de questoes a ser respondidas! "
              + "Efetue o cadastro para responder mais questões.");
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

function ContadorRespostaQuestao(form) {
    caminhourl = "/EasyQuiz/servletweb?acao=ContadorRespostaQuestao";
    form.action = caminhourl;
    form.submit();
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
