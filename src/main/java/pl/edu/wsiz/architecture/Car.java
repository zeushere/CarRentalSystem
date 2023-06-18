package pl.edu.wsiz.architecture;

import static org.apache.commons.lang3.ObjectUtils.allNotNull;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

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

    protected Boolean checkAvailability() {
        if (!isAvailable) {
            System.out.println("Car with type " + this.type + " is not available!");
            return false;
        }

        System.out.println("Car with type " + this.type + " is available.");
        return true;
    }

    public void releaseCar() {
        if (!isAvailable && carRental.carRentalActive) {

            System.out.println("Releasing car with type " + this.type);
            carRental.cancel();
            this.isAvailable = true;
            return;
        }

        System.out.println("Cannot release car!");
    }

    public void setCarRental(CarRental carRental) {
        this.carRental = carRental;
    }

    public abstract void rent();

    private Boolean validateCar(String brand, String model, Integer year, Double pricePerDay) {
        if (!(isNotBlank(brand) && isNotBlank(model) && allNotNull(year, pricePerDay)
                && pricePerDay > 0 && year > 0)) {
            System.out.println("Invalid car data!");
            return false;
        }
        return true;
    }
}
