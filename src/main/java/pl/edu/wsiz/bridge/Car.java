package pl.edu.wsiz.bridge;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

public abstract class Car {
    protected CarRental carRental;
    protected CarType type;
    protected String brand;
    protected String model;
    protected Integer year;
    protected Double pricePerDay;
    protected Boolean isAvailable = true;

    protected Car(String brand, String model, Integer year, Double pricePerDay, CarRental carRental) {
        if (validateCar(brand, model, year, pricePerDay)) {
            this.brand = brand;
            this.model = model;
            this.year = year;
            this.pricePerDay = pricePerDay;
            this.carRental = carRental;
        }
    }

    public void setCarRental(CarRental carRental) {
        this.carRental = carRental;
    }

    protected boolean checkAvailability() {
        if (!isAvailable) {
            System.out.println("Car with type " + this.type + " is not available!");
            return false;
        }

        System.out.println("Car with type " + this.type + " is available.");
        return true;
    }

    public void releaseCar() {
        if (!isAvailable && carRental.carRentalActive) {

            System.out.println("Releasing car with type " + this.getType());
            carRental.cancel();
            this.isAvailable = true;
            return;
        }

        System.out.println("Cannot release car!");
    }

    protected CarType getType() {
        return type;
    }

    private boolean validateCar(String brand, String model, Integer year, Double pricePerDay) {
        if (!(StringUtils.isNotBlank(brand) && StringUtils.isNotBlank(model) && ObjectUtils.allNotNull(year, pricePerDay)
                && pricePerDay > 0 && year > 0)) {
            System.out.println("Invalid car data!");
            return false;
        }
        return true;
    }

    public abstract void rent();
}
