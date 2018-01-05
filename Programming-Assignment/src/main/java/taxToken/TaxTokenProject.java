package TaxToken;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class TaxTokenProject {

	public static void main(String[] args) {
		SpringApplication.run(TaxTokenProject.class, args);
	
	}
	
	// Populate one value into the database for testing purposes
	@Bean 
	CommandLineRunner runner(@Autowired UserRepository userRepository) {
		return args -> {
			userRepository.save(new User("Repository", "01/04/2018", 1));
		};
	}

}
