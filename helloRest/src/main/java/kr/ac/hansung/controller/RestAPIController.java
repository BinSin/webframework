package kr.ac.hansung.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import kr.ac.hansung.exception.ErrorResponse;
import kr.ac.hansung.exception.UserDuplicatedException;
import kr.ac.hansung.exception.UserNotFoundException;
import kr.ac.hansung.model.User;
import kr.ac.hansung.service.UserService;

@RestController // @Controller + @ResponseBody
@RequestMapping("/api")
public class RestAPIController {

	@Autowired
	UserService userService;

	// --- Retrieve All Users (모든 사용자 조회)
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() { // header, body(json), HTTP.status
		List<User> users = userService.findAllUsers();
		
		if (users.isEmpty()) {
			// users 가 비어있으므로 header, body 안넘기고 Http 상태만 넘긴다.
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} 
		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	// --- Retrieve Single User
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET) // Template Valuable
	public ResponseEntity<User> getUser(@PathVariable("id") long id) {
		
		User user = userService.findById(id);
		
		if (user == null) {
			throw new UserNotFoundException(id);
		} 
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	// --- Create a User
	@RequestMapping(value = "/users", method = RequestMethod.POST) // request body(json) 에 사용자 정보가 담긴다. 
	public ResponseEntity<Void> createUser(@RequestBody User user,  
			UriComponentsBuilder ucBuilder) { // // -> 객체에 binding 된다. body 없고 header 만 넣는다.
		
		if(userService.isUserExist(user)) {
			throw new UserDuplicatedException(user.getName());
		} // 이미 유저가 존재하면 exception 처리
		
		userService.saveUser(user);
		
		// Header 에 uri 를 담는다.
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/users/{id}").
				buildAndExpand(user.getId()).toUri());
		
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		
	}
	
	// --- Update a User
	@RequestMapping(value="/users/{id}", method=RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("id") long id,
			@RequestBody User user) {
		
		User currentUser = userService.findById(id);
		
		if(currentUser == null) {
			throw new UserNotFoundException(id);
		}
		
		currentUser.setName(user.getName());
		currentUser.setAge(user.getAge());
		currentUser.setSalary(user.getSalary());
		
		userService.updateUser(currentUser);
		
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
		
	}
	
	// -- Delete a User
	@RequestMapping(value="/users/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
		
		User user = userService.findById(id);
		if(user == null) {
			throw new UserNotFoundException(id);
		}
		userService.deleteUserById(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	
	// -- Delete All User
	@RequestMapping(value="/users", method=RequestMethod.DELETE)
	public ResponseEntity<User> deleteAllUser() {
			
		userService.deleteAllUsers();
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> 
		handleUserNotFoundException(HttpServletRequest req, UserNotFoundException ex) {
	
		String requestURL = req.getRequestURL().toString();
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setRequestURL(requestURL);
		errorResponse.setErrorCode("user.notfound.exception");
		errorResponse.setErrorMsg("User with id " + ex.getUserId() + " not found");
		
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(UserDuplicatedException.class)
	public ResponseEntity<ErrorResponse> 
		handleUserDuplicatedException(HttpServletRequest req, UserDuplicatedException ex) {
	
		String requestURL = req.getRequestURL().toString();
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setRequestURL(requestURL);
		errorResponse.setErrorCode("user.duplicated.exception");
		errorResponse.setErrorMsg("Unable to create. A user with name" + ex.getUsername() + " already exist");
		
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.CONFLICT);
		
	}
	
}
