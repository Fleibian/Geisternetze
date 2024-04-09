import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class Person {
	private String name;
	private String surname;
	private int phone;
	private String type;

		
	public Person(String surname, String name, int phone, String type) {
		this.surname = surname;
		this.name = name;
		this.phone = phone;
		this.type = type;

	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getSurname() {
		return surname;
	}
	
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getPhone() {
		return phone;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	
}