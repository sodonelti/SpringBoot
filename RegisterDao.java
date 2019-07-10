package com.lti.training.dao;

import java.sql.Connection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.training.dto.UserDTO;
import com.lti.training.entity.User;

@Repository
public class RegisterDao {

	
	@PersistenceContext
	EntityManager em;
	
	public int save(User user) {
			User u =em.merge(user);
			return u.getId();
	}
	
	public User fetch(int id) {
		User user= em.find(User.class, id);
				/*em.createQuery("select u from User as u where u.email= :em").setParameter("em", email);*/
		/* User user = (User)q.getSingleResult(); */
		System.out.println(user.getEmail());
		return user;
	} 
}
