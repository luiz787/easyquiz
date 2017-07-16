package model.dao;

import java.time.Instant;
import java.util.List;
import model.domain.Sessao;
import model.exception.ExcecaoPersistencia;

public interface SessaoDAO {
    public boolean insert(Sessao sessao) throws ExcecaoPersistencia;
    public boolean update(Sessao sessao) throws ExcecaoPersistencia;
    public Sessao getSessaoByUsuarioData(Long cod_Usuario, Instant dat_Inicio) throws ExcecaoPersistencia;
    public List<Sessao> getSessaoByUsuario(Long cod_Usuario) throws ExcecaoPersistencia;
    public List<Sessao> listAll() throws ExcecaoPersistencia;
}
