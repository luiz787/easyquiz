/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

/**
 *
 * @author Luiz
 */
public class QuestaoFechada extends Questao {
    public QuestaoFechada() {
        
    }
    private String[] alternativas;
    private Long alternativaCorreta;

    public String[] getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(String[] alternativas) {
        this.alternativas = alternativas;
    }

    public Long getAlternativaCorreta() {
        return alternativaCorreta;
    }

    public void setAlternativaCorreta(Long alternativaCorreta) {
        this.alternativaCorreta = alternativaCorreta;
    }
}
