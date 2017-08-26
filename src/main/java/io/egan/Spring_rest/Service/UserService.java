package io.egan.Spring_rest.Service;

import java.util.List;



import io.egan.Spring_rest.entity.User;

public interface UserService {

	public List<User> findAll();
	
	public User findOne(String userId);
	
	public User create(User user);
	
	public User update(String id, User user);
	
	public void delete(String id);
	
}
