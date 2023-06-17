package pl.edu.wsiz.car;

public class CarLuxury extends Car {

    public CarLuxury(String brand, String model, Integer year, Double pricePerDay) {
        super(brand, model, year, pricePerDay);
        type = CarType.CAR_LUXURY;
    }

    @Override
    public void rent() {
        this.isAvailable = false;

        System.out.println("Car Luxury" + " with brand: " + this.brand + ", model: " + this.model +
                ", year: " + this.year + " and price per day: " + this.pricePerDay + " PLN was rented.");
    }
}