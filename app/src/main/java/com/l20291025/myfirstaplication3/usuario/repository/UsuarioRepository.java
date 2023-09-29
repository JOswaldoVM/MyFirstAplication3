package com.l20291025.myfirstaplication3.usuario.repository;

import com.l20291025.myfirstaplication3.usuario.model.Usuario;
import java.util.HashMap;
public class UsuarioRepository {
    private static UsuarioRepository repository = null;
    private HashMap< String, HashMap< String, Usuario>> registeredUsers;

    private UsuarioRepository() {
        Usuario u1 = new Usuario("Loba", "12345", "Oswaldo", 21, "oswa@gmail.com");
        Usuario u2 = new Usuario("Chispa", "12345", "valdo", 21, "valdo@gmail.com");
        Usuario u3 = new Usuario("Picher", "12345", "Myers", 21, "apocosi@hotmail.com");

        this.registeredUsers = new HashMap<String, HashMap<String, Usuario>>();

        //Agregar usuario 1
        registeredUsers.put(u1.getUsuario(), new HashMap<String, Usuario>());
        registeredUsers.get(u1.getUsuario()).put(u1.getPasss(), u1);

        //Agregar usuario 2
        registeredUsers.put(u2.getUsuario(), new HashMap<String, Usuario>());
        registeredUsers.get(u2.getUsuario()).put(u2.getPasss(), u2);

        //Agregar usuario 3
        registeredUsers.put(u3.getUsuario(), new HashMap<String, Usuario>());
        registeredUsers.get(u3.getUsuario()).put(u3.getPasss(), u3);
    }

    public static UsuarioRepository getInstance() {
        if(repository == null)
            repository = new UsuarioRepository();

        return repository;
    }

    public HashMap<String, HashMap<String, Usuario>> getRegisteredUsers() {
        return registeredUsers;
    }
}
