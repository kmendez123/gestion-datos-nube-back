package com.proyecto.api.services;

import com.proyecto.api.entity.Usuario;

public interface IUsuarioService {
    Usuario registrarUsuario(Usuario usuario);
    Usuario login(String correo, String clave);
	boolean existePorCorreo(String correo);

}