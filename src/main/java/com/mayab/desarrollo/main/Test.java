package com.mayab.desarrollo.main;

import org.hibernate.Session;
import com.mayab.desarrollo.persistencia.DAOUsers;
//import com.mayab.desarrollo.services.UServices;
import com.mayab.desarrollo.entities.Usuario;

public class Test {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		//Add new user object
		/*
		Usuario user = new Usuario();
		user.setNombre("Usuario1");
		user.setPassword("password");
		user.setEmail("email@email.com");

		session.save(user);

		session.getTransaction().commit();
		HibernateUtil.shutdown();
		*/

		//Create user
		DAOUsers dao = new DAOUsers();
		Usuario user = new Usuario();
		user.setNombre("Jose");
		user.setPassword("jose234");
		user.setEmail("rami23@gmail");
		int idUser = dao.createUser(user);
		System.out.println("id = " + idUser);


		// Delete user
		dao.deleteUser(4);
	}
}
