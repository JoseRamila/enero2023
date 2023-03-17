package com.mayab.desarrollo.persistencia;

import com.mayab.desarrollo.entities.Usuario;

import java.util.List;

public interface IDAO {
    public int createUser(Usuario user); // Return id
    public boolean deleteUser(int id);
    public Usuario findByID(int id);
    public List<Usuario> findAll();
    public Usuario updatePassword(Usuario user, String nPassword);
    public Usuario findByName(String name);
    public Usuario findByEmail(String email);

}
