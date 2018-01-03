package taxToken;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	
	@RequestMapping("/{name}/birthday") 
	public ResponseEntity<String> getBirthday(@PathVariable String name) {
		
		String birthday = "No results found";
		
		// Get's the user's birthday based on name
		birthday = UserService.returnBirthday(name, birthday);
		
		if(birthday.equals("No results found")) {
			return new ResponseEntity<String>(birthday, HttpStatus.NOT_FOUND);
		}
		
		// Returns the user's name birthday and age
	    return new ResponseEntity<String>(birthday, HttpStatus.OK);
		
	}
	
	@RequestMapping("/{name}/age") 
	public ResponseEntity<Integer> getAge(@PathVariable String name) {
		
		int age = 0;
		
		// Get's the user's age based on name
		age = UserService.returnAge(name, age);
		
		if(age == 0) {
			return new ResponseEntity<Integer>(age, HttpStatus.NOT_FOUND);
		}
		
		// Returns the user's age
		return new ResponseEntity<Integer>(age, HttpStatus.OK);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/user")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		
		// Post request passes a user object using JSON from Postman returns a boolean
		Boolean check = UserService.addNewUser(user);
		
		
		if(check){
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<User>(user, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/user/{name}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String name) {
		
		
		// Put request passes a user object and a name using JSON from Postman
		Boolean check = UserService.updateNewUser(name, user);
		
		if(check) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@RequestMapping("/users")
	public Collection<User> listAll() {
	
		return UserService.userMap.values();
	}

}
