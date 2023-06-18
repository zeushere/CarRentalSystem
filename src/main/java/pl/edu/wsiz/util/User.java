package pl.edu.wsiz.util;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class User {

    private static final List<User> USER_LIST = new ArrayList<>();
    private final String name;
    private final String lastName;
    private final String email;
    private final String password;

    private User(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public static User registerUser(String name, String lastName, String email, String password) {
        if (isBlank(name) || isBlank(lastName) || isBlank(email) || isBlank(password)
                || !email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            System.out.println("All user data must be valid!");
            return null;
        }

        if (existsByEmail(email)) {
            System.out.println("Email " + email + " is busy!");
            return null;
        }

        User user = new User(name, lastName, email, password);
        USER_LIST.add(user);

        System.out.println("Successfully register user with email " + email);
        return user;
    }

    public String getEmail() {
        return email;
    }

    private static Boolean existsByEmail(String email) {
        return USER_LIST
                .stream()
                .anyMatch(user -> email.equals(user.getEmail()));
    }
}
