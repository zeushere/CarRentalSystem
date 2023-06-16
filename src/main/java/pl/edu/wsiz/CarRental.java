package pl.edu.wsiz;

import java.time.LocalDate;

public abstract class CarRental {
    protected Car car;
    protected LocalDate endRental;
    protected User user;
    protected String type;
    protected Double price;

    protected CarRental(Car car, LocalDate endRental, User user) {
        this.car = car;
        this.endRental = endRental;
        this.user = user;
    }

    public void rentCar(Car car, User user) {
        System.out.println("Start " + this.type + " process rental.");
        if (car.checkAvailability()) {
            car.rent();
            user.addCarToList(car);
            this.price = resolvePriceWithConverter(car.pricePerDay);

            System.out.println("User with name " + user.getName() + " and last name " + user.getLastName() +
                    " has rented a car with type " + car.type);
        } else {
            System.out.println("This car is already rented!");
        }
    }

    public abstract Double resolvePriceWithConverter(Double carPricePerDay);
}
