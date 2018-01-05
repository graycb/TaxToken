package TaxToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserService() {
		
	}
	
	// Returns the birthday matching the name passed in
	public String returnBirthday(String name, String birthday) {
		
		if(userRepository.exists(name)) {
			birthday = userRepository.findOne(name).getBirthday();
		}
		
		return birthday;	
		
	}
	
	// Returns the age matching the name passed ins
	public int returnAge(String name, int age) {
		
		if(userRepository.exists(name)) {
			age = userRepository.findOne(name).getAge();
		}
		
		return age;
	}
	
	// Adds the user passed into the user HashMap
	public Boolean addNewUser(User user) {
		
		
		Boolean check = false;
		
		if(user.getName() != null && user.getBirthday() != null && user.getAge() != 0) {

			if(!userRepository.exists(user.getName())) {
				
				userRepository.save(user);
				check = true;
			}
			
		} 

		return check;
		
	}
	
	// Updated the user in the array list that has a name matching what was passed in
	public Boolean updateNewUser(String name, User user) {
		Boolean check = false;
		if(!userRepository.exists(name)) {
			return check;
		}
		
		if(user.getBirthday() != null && user.getAge() != 0) {
			user.setName(name);
			userRepository.save(user);
		}
		return check;	
		
	}
	
	
}
