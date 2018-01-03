package taxToken;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaxTokenProject {

	public static void main(String[] args) {
		SpringApplication.run(TaxTokenProject.class, args);

		// Populate HashMap
		
		UserService.userMap.put("Christian", new User("Christian", "11/12/1994", 23));
		UserService.userMap.put("Evan", new User("Evan", "11/01/1996", 21));
		UserService.userMap.put("Bernard", new User("Bernard", "06/14/1965", 52));
		UserService.userMap.put("Carolyn", new User("Carolyn", "02/12/1966", 51));
		UserService.userMap.put("Erin", new User("Erin", "12/02/1997", 20));

	}

}
