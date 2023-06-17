package pl.edu.wsiz.car;

public class CarFamily extends Car {

    public CarFamily(String brand, String model, Integer year, Double pricePerDay) {
        super(brand, model, year, pricePerDay);
        type = CarType.CAR_FAMILY;
    }

    @Override
    public void rent() {
        this.isAvailable = false;

        System.out.println("Car Family" + " with brand: " + this.brand + ", model: " + this.model +
                ", year: " + this.year + " and price per day: " + this.pricePerDay + " PLN was rented.");
    }
}