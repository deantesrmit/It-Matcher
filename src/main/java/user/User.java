package user;

public class User {
    String username;
    String password;
    String hashedPassword;

    public User(String username, String hashedPassword, String password) {
                this.username = username;
                this.hashedPassword = hashedPassword;
                this.password = password;
            }

    public String getUsername() {
        return username;
    }
}
