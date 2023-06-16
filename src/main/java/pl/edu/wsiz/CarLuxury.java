package pl.edu.wsiz;

public class CarLuxury extends Car {

    public CarLuxury(String brand, String model, Integer year, Double pricePerDay) {
        super(brand, model, year, pricePerDay);
        type = "Car Luxury";
    }

    @Override
    public void rent() {
        this.isAvailable = false;

        System.out.println("Car luxury with brand:" + this.brand + ", model:" + this.model +
                ", year:" + this.year + "and price per day: " + this.pricePerDay + " was rented.");
    }
}