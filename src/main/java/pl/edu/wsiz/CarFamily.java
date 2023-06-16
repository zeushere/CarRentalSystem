package pl.edu.wsiz;

public class CarFamily extends Car {

    public CarFamily(String brand, String model, Integer year, Double pricePerDay) {
        super(brand, model, year, pricePerDay);
        type = "Car Family";
    }

    @Override
    public void rent() {
        this.isAvailable = false;

        System.out.println("Car family with brand:" + this.brand + ", model:" + this.model +
                ", year:" + this.year + "and price per day: " + this.pricePerDay + " was rented.");
    }
}