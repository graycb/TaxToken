package taxToken;

//import java.util.ArrayList;

public class User {
	
	// Global variables
	private String name;
	private String birthday;
	private int age;
	
	
	public User() {
		
	}
	public User(String name, String birthday, int age) {
		setName(name);
		setBirthday(birthday);
		setAge(age);
	}
	
	// Setter methods
	public void setName(String name) {
		this.name = name;
	}
	private void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	private void setAge(int age) {
		this.age = age;
	}
	
	// Getter methods
	public String getName() {
		return this.name;
	}
	public String getBirthday() {
		return this.birthday;
	}
	public int getAge() {
		return this.age;
	}
	
	
}
