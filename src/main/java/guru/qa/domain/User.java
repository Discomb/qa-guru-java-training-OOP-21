package guru.qa.domain;

public class User {

    private final String username;

    private final String password;

    public String getUsername() {
        return username;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isPasswordEquals(String password) {
        return this.password.equals(password);
    }
}
