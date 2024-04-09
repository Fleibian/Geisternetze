import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import org.checkerframework.checker.units.qual.Current;

@Named
@ApplicationScoped
public class Shop implements Serializable
{
    private final List<Artikel> sortiment = new ArrayList<Artikel>();

    private final String[][] users =
            new String[][]{
                    // password hash obtained with java LoginController koch i-am-the-boss
//                    new String[]{"koch",
//                            "+INdDt2JaxoJLHzD4iAlWPYMJA0uJhusP37DvMHBKmen15EMj1Vn7BAxWS1TYFniKFKjuSyIEFbxy9jSx4d8Tw==",
//                            "mperson"},
//                    // password hash obtained with java LoginController you you-are-the-bperson
//                    new String[]{"you",
//                            "dNw2o1ZcCW+Ge/n/yfYpMLbUZ9fbxqLXEuxTa6ilzXLgmr1imFH27T6q9ZNzlqBeAdKIHDf5SopFt0ttbDybEg==",
//                            "bperson"},
                    new String[] {"mperson",
                    		"7hquov1dbNiFQC3FinD27z8vyMnrX0sNcRzQLgKUmqsvZuizF2UICmlL4YPzz+cdhjxJK3MxEtTCg8KAlMvkjQ==",
                    		"mperson"},
                    new String[] {"bperson",
                    		"2+9pbSmqAzj8hL3Z/eSYmtLDj/+J2+AIa356LI0GkgIrBipzId2LPLyY1GM7NJ+fW84FfLDjLZoolb51BJ/IMg==",
                    		"bperson"
                    }
            };

    public Shop()
    {

        sortiment.add(new Artikel(1, "Pantoffeln \"Rudolph\"",
                "Wunderschöne Filzpantoffeln, in beige Farbe mit einem braunen und schwarzen Kringel. Sehr angenehm für kalte Wintertage.",
                "filzschuhe.jpg", (new GregorianCalendar(2012, 11, 23).getTime())));
        sortiment.add(new Artikel(2, "Handtasche \"Cosmopolita\"",
                "Modische Filz-Handtasche mit praktischer Cocktailglas-Halterung. Irgendwie kommen wir nie aus dem Haus ohne solchen nützlichen Accessoire.",
                "handtasche.jpg", (new GregorianCalendar(2010, 10, 3).getTime())));
        sortiment.add(new Artikel(3, "Filz-Hase \"Moe\"",
                "Ein putziger Hase aus Filz zur Dekoration. Er lässt sich gern am Rand seines Büros stellen, um Mut zu geben.", "hase.jpg",
                (new GregorianCalendar(2013, 11, 31).getTime())));
    }

    public List<Artikel> getSortiment()
    {
        return sortiment;
    }


    static String hashPassword(String name, String pass, String salt) {
        try {
            MessageDigest digester = MessageDigest.getInstance("SHA-512");
            byte[] hashBytes = digester.digest((name + pass + salt)
                    .getBytes(StandardCharsets.UTF_8));
            return new String(Base64.getEncoder().encode(hashBytes));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void validateUsernameAndPassword(CurrentUser currentUser, String name,String pass, String salt) {
        String passHash = hashPassword(name, pass, salt);
        currentUser.reset();
        for(String[] user: users) {
            if(user[0].equals(name)) {
                if(user[1].equals(passHash)) {
                    if(user[2].equals("mperson")) {
                        currentUser.mperson = true; 
                        return;
                    } else if(user[2].equals("bperson")) {
                        currentUser.bperson = true; 
                        return;
                    }
                    else throw new RuntimeException("Benutzer " + name + " ist falsch angelegt.");
                }
            }
        }
    }
}
