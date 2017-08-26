package io.egan.Spring_rest.UserRepository;

import java.util.List;
import java.util.Optional;

import io.egan.Spring_rest.entity.User;

public interface UserRepository {

	public List<User> findAll();

	// public User findOne(String userId);
	public Optional<User> findOne(String userId);

	public User findByEmail(String email);

	public User create(User user);

	public User update(User user);

	public void delete(User user);

}
