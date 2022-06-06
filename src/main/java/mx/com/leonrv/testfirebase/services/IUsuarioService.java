package mx.com.leonrv.testfirebase.services;

import mx.com.leonrv.testfirebase.domain.Usuario;

public interface IUsuarioService {

    public Usuario getUsuario(String username);

    public String saveUsuario(Usuario usuario);

    public String updateUsuario(Usuario usuario);
    
    public String deleteUser(String name);

}
