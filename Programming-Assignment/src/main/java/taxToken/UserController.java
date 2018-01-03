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
	public String getBirthday(@PathVariable String name) {
		
		String birthday = "No results found";
		
		
		// Get's the user's birthday based on name
		birthday = UserService.returnBirthday(name, birthday);
		
		
		// If no name matches the get request will return no results found
		if(birthday.equals("No results found")) {
			return birthday;
		}
		
		// Returns the user's name birthday and age
		return name + "'s birthday is " + birthday + ".";
		
	}
	
	@RequestMapping("/{name}/age") 
	public String getAge(@PathVariable String name) {
		
		int age = 0;
		
		// Get's the user's age based on name
		age = UserService.returnAge(name, age);
		
		// If no name matches the get request will return no results found
		if(age == 0) {
			return "No results found";
		}
		
		// Returns the user's name birthday and age
		return name + "'s age is " + age + ".";
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/user")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		String status = "";
		
		// Post request passes a user object using JSON from Postman
		Boolean check = UserService.addNewUser(user);
		
		
		if(check){
			status += "Name: " + user.getName() + "| ";
			status += " Birthday: " + user.getBirthday() + "| ";
			status += " Age: " + user.getAge() + ".";
			
			return new ResponseEntity<String>(status, HttpStatus.OK);
		}
		else {
			status = "Error! The user could not be updated because there are null values in the user attributes!";
			return new ResponseEntity<String>(status, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/user/{name}")
	public ResponseEntity<String> updateUser(@RequestBody User user, @PathVariable String name) {
		String status = "";
		
		// Put request passes a user object and a name using JSON from Postman
		Boolean check = UserService.updateNewUser(name, user);
		
		if(check) {
			status += "Name: " + user.getName() + "| ";
			status += " Birthday: " + user.getBirthday() + "| ";
			status += " Age: " + user.getAge() + ".";
			
			return new ResponseEntity<String>(status, HttpStatus.OK);
		}
		else {
			status = "Error! The user could not be updated because a user with that name does not exist!";
			return new ResponseEntity<String>(status, HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	@RequestMapping("/users")
	public Collection<User> listAll() {
	
		return UserService.userMap.values();
	}

}
