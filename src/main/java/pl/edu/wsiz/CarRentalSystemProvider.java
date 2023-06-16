package pl.edu.wsiz;

import java.time.LocalDate;

public class CarRentalSystemProvider extends Provider<Object> {

    @Override
    protected Car createCar(String type, String brand, String model, Integer year, Double pricePerDay) {
        CarProvider carProvider = new CarProvider();

        return carProvider.createCar("type", "test", "test", 0, 0.0);
    }

    @Override
    protected CarRental createRental(String type, Car car, User user, String rabatCode, LocalDate endRental) {
        return null;
    }
}
