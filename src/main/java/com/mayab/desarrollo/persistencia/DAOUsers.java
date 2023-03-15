package com.mayab.desarrollo.persistencia;

import com.mayab.desarrollo.entities.Usuario;
import com.mayab.desarrollo.main.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class DAOUsers implements IDAO{
    @Override
    public int createUser(Usuario user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int id = (int) session.save(user);
        session.getTransaction().commit();
        session.close();
        return id;
    }

    @Override
    public boolean deleteUser(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Usuario u = session.get(Usuario.class, id);
        session.delete(u);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Usuario findByID(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Usuario user = session.get(Usuario.class,id);
        session.close();
        return user;
    }

    @Override
    public List<Usuario> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Usuario> list = session.createQuery("FROM Usuario").list();
        session.close();
        return list;

    }

    @Override
    public Usuario updatePassword(Usuario user, String nPassword) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Usuario toUpdate = session.get(Usuario.class, user.getId());
        toUpdate.setPassword("newPassword");
        session.getTransaction().commit();
        session.close();
        return toUpdate;
    }
    /*@Override
    public  Usuario findbyName(String nombre){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query qry = (Query) session.createQuery("FROM Usuario WHERE nombre =:nombre").setParameter("nombre", nombre);
        Usuario user =(Usuario) qry.getSingleResult();
        System.out.println(user.toString());
        session.close();
        return user;
        }
     */

}
