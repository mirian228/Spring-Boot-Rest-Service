package com.restservices.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UsersController {

	@GetMapping()
	public String getUsers(@RequestParam(value = "page") int page, @RequestParam(value = "limit") int limit) {
		return "http GET request was sent for page:" + page + "and limit is:" + limit;
	}

	@GetMapping(path = "/{userId}")
	public String getUser(@PathVariable String userId) {
		return "http GET request was sent for userid: " + userId;
	}

	@PostMapping
	public String createUser() {
		return "http POST request was sent";

	}

	@DeleteMapping
	public String deleteUser() {
		return "http DELETE request was sent";

	}

	@PutMapping
	public String updateUser() {
		return "http PUT request was sent";

	}
}
