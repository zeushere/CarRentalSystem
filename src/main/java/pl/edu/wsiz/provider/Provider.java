package pl.edu.wsiz.provider;

import pl.edu.wsiz.car.Car;
import pl.edu.wsiz.car.CarType;

public abstract class Provider {

    public abstract Car createCar(CarType carType, String brand, String model, Integer year, Double pricePerDay);
}
