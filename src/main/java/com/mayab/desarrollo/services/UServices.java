package com.mayab.desarrollo.services;

import com.mayab.desarrollo.entities.Usuario;
import com.mayab.desarrollo.persistencia.DAOUsers;

public class UServices {
    private DAOUsers dao;
    public UServices(DAOUsers d){
        dao = d;
    }

    public boolean login(String user, String pass){
        boolean result = false;
        Usuario usuario = dao.findByName(user);
        System.out.println(usuario.toString());
        if (usuario != null){
            if(usuario.getPassword().equals(pass)){
                result = true;
            }
        }
        return result;

    }
    public boolean createUser(String name, String pass, String email) {
        boolean result = false;
        Usuario user = new Usuario();
        if (dao.findByName(name) == null) {
            if (dao.findByEmail(email) == null) {
                user.setEmail(email);
                user.setNombre(name);
                user.setPassword(pass);
                dao.createUser(user);
                result = true;
            }
        }
        return result;
    }
    public boolean recoverPassword(String name, String email) {
        boolean result = false;
        if (dao.findByName(name) == null) {
            if (dao.findByEmail(email) == null) {
                System.out.println("You will receive your password by email");
                result = true;
            }
        }
        return result;
    }
    public boolean changePassword(String name, String oldPass, String newPass){
        Usuario usuario;
        if(login(name, oldPass)){
            usuario = dao.findByName(name);
            dao.updatePassword(usuario, newPass);
            return true;
        }
        else{
            return false;
        }
    }
}
