package io.egan.Spring_rest.UserRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egan.Spring_rest.UserRepository.UserRepository;
import io.egan.Spring_rest.entity.User;


@Repository
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}

	@Override
	public Optional<User> findOne(String userId) {
		// TODO Auto-generated method stub
		
		return Optional.ofNullable(em.find(User.class, userId));
	}
	
//	public User findOne(String userId) {
//		// TODO Auto-generated method stub
//		
//		return em.find(User.class, userId);
//	}

	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		em.persist(user);
		return user;
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
	
		return em.merge(user);
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		em.remove(user);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("pEmail", email);
		List<User> list = query.getResultList();
		if(!list.isEmpty()){
			return list.get(0);
		}
		else{
			return null;
		}
		
	}

}
