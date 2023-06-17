package pl.edu.wsiz.util;

import pl.edu.wsiz.car.Car;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class User {

    private static final List<User> USER_LIST = new ArrayList<>();
    private static final List<Car> CAR_LIST = new ArrayList<>();
    private final String name;
    private final String login;
    private final String password;
    private final String lastName;

    private User(String name, String lastName, String login, String password) {
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
    }

    public static User registerUser(String name, String lastName, String login, String password) {
        if (isBlank(name) || isBlank(lastName) || isBlank(login) || isBlank(password)) {
            System.out.println("All user data must not be blank!");
            return null;
        }

        if (existsByLogin(login)) {
            System.out.println("Login " + login + " is busy!");
            return null;
        }

        User user = new User(name, lastName, login, password);
        USER_LIST.add(user);

        System.out.println("Successfully register user with login " + login);
        return user;
    }

    public void addCarToList(Car car) {
        CAR_LIST.add(car);
    }

    public void deleteCarFromList(Car car) {
        CAR_LIST.remove(car);
    }

    public String getLogin() {
        return login;
    }

    private static boolean existsByLogin(String login) {
        return USER_LIST
                .stream()
                .anyMatch(user -> login.equals(user.getLogin()));
    }
}
