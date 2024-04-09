import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class CurrentUser implements Serializable {

    boolean mperson, bperson;

    void reset() {
        mperson = false; bperson = false;
    }

    boolean isMperson() {
        return mperson;
    }

    boolean isBperson() {
        return bperson;
    }

    boolean isValid() {
        return isBperson() || isMperson();
    }

}
