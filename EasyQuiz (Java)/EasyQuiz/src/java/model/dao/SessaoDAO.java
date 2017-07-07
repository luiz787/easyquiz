package model.dao;

import java.util.List;
import model.domain.Sessao;
import model.exception.ExcecaoPersistencia;

public interface SessaoDAO {
    public void insert(Sessao sessao) throws ExcecaoPersistencia;
    public void update(Sessao sessao) throws ExcecaoPersistencia;
    public List<Sessao> getSessaoByUsuario(Long cod_Usuario) throws ExcecaoPersistencia;
    public List<Sessao> listAll() throws ExcecaoPersistencia;
}
