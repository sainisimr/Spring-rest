package io.egan.Spring_rest.UserServiceIMpl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egan.Spring_rest.Service.UserService;
import io.egan.Spring_rest.UserRepository.UserRepository;
import io.egan.Spring_rest.entity.User;
import io.egan.Spring_rest.exception.BadRequestException;
import io.egan.Spring_rest.exception.NotFoundException;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository repository;

	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public User findOne(String userId) {
		// TODO Auto-generated method stub
		return repository.findOne(userId)
				.orElseThrow(() -> new NotFoundException("User with id " + userId + " doesn't exist"));

		// User existing = repository.findOne(userId);
		// if(existing==null){
		// throw new NotFoundException("User with id "+ userId + " doesn't
		// exist");
		// }
		// return existing;
	}

	@Override
	@Transactional
	public User create(User user) {
		// TODO Auto-generated method stub
		User existing = repository.findByEmail(user.getEmail());
		if (existing != null) {
			throw new BadRequestException("User with email " + user.getEmail() + " already exist");

		}
		return repository.create(user);
	}

	@Override
	@Transactional
	public User update(String id, User user) {
		// TODO Auto-generated method stub
		repository.findOne(id).orElseThrow(() -> new NotFoundException("User with id " + id + " doesn't exist"));
		// User existing = repository.findOne(id);
		// if(existing==null){
		// throw new NotFoundException("User with id "+ id + " doesn't exist");
		//
		// }
		 return repository.update(user);
	}

	@Override
	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		User existing = repository.findOne(id).orElseThrow(()->new NotFoundException("User with id " + id + " doesn't exist"));
		// User existing = repository.findOne(id);
		// if (existing == null) {
		// throw new NotFoundException("User with id " + id + " doesn't exist");
		//
		// }
		repository.delete(existing);
	}

}
