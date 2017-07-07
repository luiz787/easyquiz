package model.daoimpl;

import model.dao.*;
import java.util.List;
import model.domain.Sessao;
import model.exception.ExcecaoPersistencia;

public class SessaoDAOImpl implements SessaoDAO {

    @Override
    public void insert(Sessao sessao) throws ExcecaoPersistencia {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Sessao sessao) throws ExcecaoPersistencia {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sessao getSessaoByUsuario(Long cod_Usuario) throws ExcecaoPersistencia {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sessao> listAll() throws ExcecaoPersistencia {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
