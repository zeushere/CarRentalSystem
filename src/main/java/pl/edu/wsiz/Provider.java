package pl.edu.wsiz;

import pl.edu.wsiz.Car;
import pl.edu.wsiz.User;

import java.time.LocalDate;

public abstract class Provider {

    protected abstract Car createCar(String type, String brand, String model, Integer year, Double pricePerDay);
    protected abstract CarRental createRental(String type, Car car, User user, String rabatCode, LocalDate endRental);
}
