package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User user) {
		return repository.save(user);
	}
	
	public void delete(long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User user) {
		/*
		 * Tras um objeto monitorado, diretente de findById que procura o
		 * registro no BD.	
		*/
		try {
			User entity = repository.getReferenceById(id);
			updateData(entity, user);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(User entity, User uptUser) {
		entity.setName(uptUser.getName());
		entity.setEmail(uptUser.getEmail());
		entity.setPhone(uptUser.getPhone());
	}
}
