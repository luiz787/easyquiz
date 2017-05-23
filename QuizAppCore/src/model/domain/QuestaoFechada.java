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
    private String[] aternativas;
    private int alternativaCorreta;

    public String[] getAlternativas() {
        return aternativas;
    }

    public void setAlternativas(String[] aternativas) {
        this.aternativas = aternativas;
    }

    public int getAlternativaCorreta() {
        return alternativaCorreta;
    }

    public void setAlternativaCorreta(int alternativaCorreta) {
        this.alternativaCorreta = alternativaCorreta;
    }
}
