import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class GhostnetBean {
    private List<Ghostnet> ghostnets;

    @PostConstruct
    public void init() {
        // Initialize the list of Ghostnets
        ghostnets = new ArrayList<>();
        ghostnets.add(new Ghostnet("im Mittelmeer lol", 4, "geborgen"));
        ghostnets.add(new Ghostnet("im Gardasee", 5, "active"));
        // Add more Ghostnet objects as needed
    }

    public List<Ghostnet> getGhostnets() {
        return ghostnets;
    }
    
    public void deleteRow(Ghostnet ghostnet) {
    	ghostnets.remove(ghostnet);
    }
    
    
   public void addGhostnet() throws SQLException {
	   System.out.println("Test");
	   String sql = "select name from Person";
	   String url = "jdbc:mysql://localhost:3306/ghostnetdatabase";
	   String username = "root";
	   String password = "admin123";
	   
	   Connection con = DriverManager.getConnection(url, username, password);
	   Statement st = con.createStatement();
	   ResultSet rs = st.executeQuery(sql);
	   rs.next();
	   String name = rs.getString(1);
	   System.out.println(name);
	   
	   
	   //return "ghostnetB.xhtml?faces-redirect=true";
   }
    
}
