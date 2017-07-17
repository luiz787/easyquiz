/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.daoimpl.DificuldadeDAOImpl;
import model.daoimpl.DisciplinaDAOImpl;
import model.daoimpl.ModuloDAOImpl;
import model.domain.Dificuldade;
import model.domain.Disciplina;
import model.domain.Modulo;
import model.service.ManterDificuldade;
import model.service.ManterDisciplina;
import model.service.ManterModulo;
import model.serviceimpl.ManterDificuldadeImpl;
import model.serviceimpl.ManterDisciplinaImpl;
import model.serviceimpl.ManterModuloImpl;
/**
 *
 * @author Luiz
 */
class AdicionarQuestao {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            System.out.println("Teste AddQuestaoo");
            ManterDisciplina manterDisciplina = new ManterDisciplinaImpl(DisciplinaDAOImpl.getInstance());
            List<Disciplina> disciplinas = manterDisciplina.getAll();
            ManterModulo manterModulo = new ManterModuloImpl(ModuloDAOImpl.getInstance());
            List<Modulo> modulos = manterModulo.getAll();
            ManterDificuldade manterDificuldade = new ManterDificuldadeImpl(DificuldadeDAOImpl.getInstance());
            List<Dificuldade> dificuldades = manterDificuldade.listAll();
            request.setAttribute("listDisciplina", disciplinas);
            request.setAttribute("listModulo", modulos);
            request.setAttribute("listDificuldade", dificuldades);
            jsp = "/adicionarQuestao.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
