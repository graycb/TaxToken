package taxToken;

import java.util.HashMap;

public class UserService {
	
	public static HashMap<String, User> userMap = new HashMap<>();
	
	public UserService() {
		
	}
	
	// Returns the birthday matching the name passed in
	public static String returnBirthday(String name, String birthday) {
		
		for(String nm : userMap.keySet()) {
			if(nm.equals(name)) {
				birthday = userMap.get(name).getBirthday();
			}
		}
		return birthday;	
		
	}
	
	// Returns the age matching the name passed ins
	public static int returnAge(String name, int age) {
		
		for(String nm : userMap.keySet()) {
			if(nm.equals(name)) {
				age = userMap.get(name).getAge();
			}
		}
		
		return age;
	}
	
	// Adds the user passed into the user HashMap
	public static Boolean addNewUser(User user) {
		Boolean check = false;
		
		if(user.getName() != null && user.getBirthday() != null && user.getAge() != 0) {

			userMap.put(user.getName(), user);
			check = true;
		}
		
		return check;
		
	}
	
	// Updated the user in the array list that has a name matching what was passed in
	public static Boolean updateNewUser(String name, User user) {
		Boolean check = false;
		
		for(String nm : userMap.keySet()) {
			if(nm.equals(name)) {
				userMap.replace(name, user);
				userMap.get(name).setName(name);
				check = true;
			}
		}
		
		return check;
		
		
		
	}
}
