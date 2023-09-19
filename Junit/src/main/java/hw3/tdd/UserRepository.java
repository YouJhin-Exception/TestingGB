package hw3.tdd;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserRepository {
    List<User> data = new ArrayList<>();

    public UserRepository() {
    }

    public void addUser(@NotNull User user) {
        if (user.isAuthenticate) {
            this.data.add(user);
        }

    }

    public boolean findByName(String username) {
        Iterator<User> var2 = this.data.iterator();

        User user;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            user = (User)var2.next();
        } while(!user.name.equals(username));

        return true;
    }

    public void logOutAll() {
        for (User user : data) {
            if (!user.isAdmin()) {
                user.logOut();
            }
        }
    }
}
