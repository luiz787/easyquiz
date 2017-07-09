package model.dao;

import model.domain.Usuario;
import java.util.List;
import model.exception.ExcecaoPersistencia;

public interface UsuarioDAO {
    public void insert(Usuario usuario) throws ExcecaoPersistencia;
    public void update(Usuario usuario) throws ExcecaoPersistencia;
    public Usuario delete(Long cod_Usuario) throws ExcecaoPersistencia;
    public Usuario getUsuarioById(Long cod_Usuario) throws ExcecaoPersistencia;
    public Usuario getUsuarioByEmailSenha(String email, String senha) throws ExcecaoPersistencia;
    public List<Usuario> listAll() throws ExcecaoPersistencia;    
}
