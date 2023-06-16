package pl.edu.wsiz;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String lastName;
    private final List<Car> carRentalList = new ArrayList<>();

    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public void addCarToList(Car car) {
        carRentalList.add(car);
    }

    public void deleteCarFromList(Car car) {
        carRentalList.remove(car);
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
}
