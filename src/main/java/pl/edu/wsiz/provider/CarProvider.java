package pl.edu.wsiz.provider;

import pl.edu.wsiz.car.Car;
import pl.edu.wsiz.car.CarDelivery;
import pl.edu.wsiz.car.CarEconomy;
import pl.edu.wsiz.car.CarFamily;
import pl.edu.wsiz.car.CarLuxury;
import pl.edu.wsiz.car.CarType;

public class CarProvider extends Provider {

    @Override
    public Car createCar(CarType carType, String brand, String model, Integer year, Double pricePerDay) {
        switch (carType) {
            case CAR_ECONOMY -> {
                return new CarEconomy(brand, model, year, pricePerDay);
            }
            case CAR_LUXURY -> {
                return new CarLuxury(brand, model, year, pricePerDay);
            }
            case CAR_DELIVERY -> {
                return new CarDelivery(brand, model, year, pricePerDay);
            }
            case CAR_FAMILY -> {
                return new CarFamily(brand, model, year, pricePerDay);
            }
            default -> throw new IllegalStateException("Unexpected value: " + carType);
        }
    }
}
