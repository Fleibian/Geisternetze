import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class PersonBean {
    private List<Person> persons;

    @PostConstruct
    public void init() {
        // Initialize the list of Ghostnets
        persons = new ArrayList<>();
        persons.add(new Person("Mustermann", "Max", 1523425678, "Meldend"));
        persons.add(new Person("Bergmann", "Peter", 1563985345, "Bergend"));
        // Add more Ghostnet objects as needed
    }

    public List<Person> getPersons() {
        return persons;
    }
        
}
