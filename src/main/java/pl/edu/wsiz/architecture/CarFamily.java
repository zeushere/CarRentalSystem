package pl.edu.wsiz.architecture;

public class CarFamily extends Car {

    public CarFamily(String brand, String model, Integer year, Double pricePerDay, CarRental carRental) {
        super(brand, model, year, pricePerDay, carRental);
        type = CarType.FAMILY;
    }

    @Override
    public void rent() {
        if (checkAvailability() && !carRental.carRentalActive) {
            this.isAvailable = false;

            carRental.rent(pricePerDay);

            System.out.println("Car Family" + " with brand: " + this.brand + ", model: " + this.model +
                    ", year: " + this.year + " and price per day: " + this.pricePerDay + " PLN was rented.");
        } else
            System.out.println("Cannot process rent!");
    }
}