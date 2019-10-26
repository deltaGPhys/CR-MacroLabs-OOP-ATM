import java.util.ArrayList;

public class User implements Storeable {

    public String firstName;
    public String lastName;
    public String password;
    public Integer userID;
    public Integer cardNumber;

    //private ArrayList<Acoount> accounts;

    public User(String firstName, String lastName, String password, Integer userID, Integer cardNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userID = userID;
        this.cardNumber = cardNumber;
    }
}
