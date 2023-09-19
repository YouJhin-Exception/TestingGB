package hw3.tdd;

import org.jetbrains.annotations.NotNull;

public class User {
    String name;
    String password;
    boolean isAdmin;
    boolean isAuthenticate = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public void authenticate(@NotNull String name, String password) {
        this.isAuthenticate = name.equals(this.name) && password.equals(this.password);
    }

    public void logOut() {
        this.isAuthenticate = false;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
