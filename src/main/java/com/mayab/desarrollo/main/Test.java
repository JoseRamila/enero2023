package com.mayab.desarrollo.main;

//import com.mayab.desarrollo.services.UServices;
import com.mayab.desarrollo.services.UServices;
import org.hibernate.Session;
import com.mayab.desarrollo.persistencia.DAOUsers;

import com.mayab.desarrollo.entities.Usuario;


import java.util.List;

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


		//Create user
		DAOUsers dao = new DAOUsers();
		Usuario user = new Usuario();
		user.setNombre("Jose Ramila");
		user.setPassword("rami12");
		user.setEmail("rami@gmail.com");
		int idUser = dao.createUser(user);
		user.setId(idUser);
		System.out.println("id new= " + idUser);

		//Find all
		List<Usuario> users;
		users = dao.findAll();
		for(Usuario u : users){
			System.out.println(u.toString());
		}

		user = dao.findByID(2);
		System.out.println("\n Old password: " + user.getPassword());
		user = dao.updatePassword(user,"new password");
		System.out.println("\n New password: " + user.getPassword());
	/*
		if(dao.deleteUser(2)){
			System.out.println("Delete user with id '2'\n New list of users");
			users = dao.findAll();
			for (Usuario u: users){
				System.out.println(u.toString());
			}
		}



		user = new Usuario();
		user.setNombre("User unique");
		user.setPassword("1234");
		user.setEmail("user@gmail.com");
		idUser = dao.createUser(user);
	*/

		DAOUsers dao = new DAOUsers();
		UServices services = new UServices(dao);
		services.login("Jose Ramila","rami12");







	}
}
