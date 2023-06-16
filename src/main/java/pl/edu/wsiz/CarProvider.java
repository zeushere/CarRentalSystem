package pl.edu.wsiz;

import java.time.LocalDate;

public class CarProvider extends Provider<Car> {

    @Override
    protected Car createCar(String type, String brand, String model, Integer year, Double pricePerDay) {
        return new CarEconomy("test", "test", 2014, 0.0);
    }

    @Override
    protected Car createRental(String type, Car car, User user, String rabatCode, LocalDate endRental) {
        System.out.println("Not properly provider! You should use CarRentalProvider.");
        return null;
    }
}
