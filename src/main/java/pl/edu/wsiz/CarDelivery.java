package pl.edu.wsiz;

public class CarDelivery extends Car {

    public CarDelivery(String brand, String model, Integer year, Double pricePerDay) {
        super(brand, model, year, pricePerDay);
        type = "Car Delivery";
    }

    @Override
    public void rent() {
        this.isAvailable = false;

        System.out.println("Car delivery with brand:" + this.brand + ", model:" + this.model +
                ", year:" + this.year + "and price per day: " + this.pricePerDay + " was rented.");
    }
}
