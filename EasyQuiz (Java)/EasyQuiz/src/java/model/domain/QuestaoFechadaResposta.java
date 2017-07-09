/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.time.Instant;

/**
 *
 * @author Aluno
 */
public class QuestaoFechadaResposta {
    private Sessao sessao;
    private Questao questao;
    private Long seq_Questao_Resposta;

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    

    public Long getSeq_Questao_Resposta() {
        return seq_Questao_Resposta;
    }

    public void setSeq_Questao_Resposta(Long seq_Questao_Resposta) {
        this.seq_Questao_Resposta = seq_Questao_Resposta;
    }
}
