package pl.edu.wsiz.car;

public class CarDelivery extends Car {

    public CarDelivery(String brand, String model, Integer year, Double pricePerDay) {
        super(brand, model, year, pricePerDay);
        type = CarType.CAR_DELIVERY;
    }

    @Override
    public void rent() {
        this.isAvailable = false;

        System.out.println("Car Delivery" + " with brand: " + this.brand + ", model: " + this.model +
                ", year: " + this.year + " and price per day: " + this.pricePerDay + " PLN was rented.");
    }
}
