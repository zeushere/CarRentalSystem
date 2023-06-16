package pl.edu.wsiz;

public class CarEconomy extends Car {

    public CarEconomy(String brand, String model, Integer year, Double pricePerDay) {
        super(brand, model, year, pricePerDay);
        type = "Car Economy";
    }

    @Override
    public void rent() {
        this.isAvailable = false;

        System.out.println("Car economy with brand:" + this.brand + ", model:" + this.model +
                ", year:" + this.year + "and price per day: " + this.pricePerDay + " was rented.");
    }
}