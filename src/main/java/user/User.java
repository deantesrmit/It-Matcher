package user;

@Value
public class User {
    String username;
    String salt;
    String hashedPassword;

}
