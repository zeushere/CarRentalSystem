package pl.edu.wsiz.bridge;

public class CarEconomy extends Car {

    public CarEconomy(String brand, String model, Integer year, Double pricePerDay, CarRental carRental) {
        super(brand, model, year, pricePerDay, carRental);
        type = CarType.CAR_ECONOMY;
    }

    @Override
    public void rent() {
        if (checkAvailability() && !carRental.carRentalActive) {
            this.isAvailable = false;

            carRental.rent(pricePerDay);

            System.out.println("Car Economy" + " with brand: " + this.brand + ", model: " + this.model +
                    ", year: " + this.year + " and price per day: " + this.pricePerDay + " PLN was rented.");
        } else
            System.out.println("Cannot process rent!");
    }
}