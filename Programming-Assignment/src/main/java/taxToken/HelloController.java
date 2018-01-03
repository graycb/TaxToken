package taxToken;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	
	
	@RequestMapping("/")
	public String sayHi() {
		
		// Returns a HTML page that I created
		return "<!DOCTYPE html>\n" + 
				"<html>\n" + 
				"    \n" + 
				"    <head>\n" + 
				"        <meta charset=\"utf-8\">\n" + 
				"    </head>\n" + 
				"    <!--Christian Gray-->\n" + 
				"    <body>\n" + 
				"        <h1>\n" + 
				"            <center>Hello World!!!!</center>\n" + 
				"        </h1>\n" + 
				"        \n" + 
				"        \n" + 
				"        \n" + 
				"    </body>\n" + 
				"</html>";
	} 
	
}

