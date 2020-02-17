package com.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.dto.UserDTO;
import com.rest.entity.User;
import com.rest.exception.IdNotFoundException;
import com.rest.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository repository;

	@GetMapping(value = "/users/all", produces = "application/json")
	public ResponseEntity<List<UserDTO>> getAllUser() {
		List<User> user = repository.findAll();
		List<UserDTO> usr = new ArrayList<UserDTO>();
		for (User u : user) {
			UserDTO dto = new UserDTO();
			dto.setId(u.getId());
			dto.setName(u.getName());
			dto.setMobileNo(u.getMobileNo());
			dto.setEmailId(u.getEmailId());
			usr.add(dto);
		}
		return new ResponseEntity<List<UserDTO>>(usr, HttpStatus.OK);
	}

	@GetMapping(value = "/users/{userId}", produces = "application/json")
	public ResponseEntity<Optional<User>> getUser(@PathVariable("userId") Integer id) throws IdNotFoundException {
		if (repository.existsById(id)) {
			Optional<User> usr = repository.findById(id);
			return new ResponseEntity<Optional<User>>(usr, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}

	@PostMapping(value = "/create", consumes = "application/json", produces = MediaType.TEXT_PLAIN_VALUE)
	public String saveData(@RequestBody User user) {
		repository.saveAndFlush(user);
		return "Data Addeded in database successfully...";
	}

	@DeleteMapping(value = "/delete", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> deleteData(@RequestParam("id") Integer id) throws IdNotFoundException {
		System.out.println(repository.existsById(id));
		if (repository.existsById(id)) {
			repository.deleteById(id);
			String msg = "Record Deleted SuccessFully from DataBase";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} // if
		else {
			throw new IdNotFoundException();
		}
	}

	@PutMapping(value = "/update", consumes = "application/json", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> updateData(@RequestBody User user) throws IdNotFoundException {
		if (repository.existsById(user.getId())) {
			repository.saveAndFlush(user);
			String data = "Data Updated Successfully...";
			return new ResponseEntity<String>(data, HttpStatus.OK);
			
		}
		throw new IdNotFoundException();
		
	}

}
