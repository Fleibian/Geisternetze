import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class Ghostnet {
	private String location;
	private double diameter;
	private String status;
	
	
	public Ghostnet(String location, double diameter, String status) {
		this.location = location;
		this.diameter = diameter;
		this.status = status;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLocation() {
		return location;
	}
		
	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}
	public double getDiameter() {
		return diameter;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	
}