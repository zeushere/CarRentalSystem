package pl.edu.wsiz.rental;

import org.apache.commons.lang3.ObjectUtils;
import pl.edu.wsiz.car.Car;
import pl.edu.wsiz.util.Discount;
import pl.edu.wsiz.util.User;

import java.time.LocalDate;

public abstract class CarRental {

    protected Car car;
    protected LocalDate endRental;
    protected User user;
    protected CarRentalType type;
    protected Double price;

    protected CarRental(Car car, LocalDate endRental, User user) {
        validateCarRental(car, endRental, user);

        this.car = car;
        this.endRental = endRental;
        this.user = user;
    }

    public void rentCar(String... optionalRabatCode) {
        System.out.println("Start " + type.getType() + " process rental.");
        if (car.checkAvailability()) {

            Double discount = 1.0;

            if (optionalRabatCode != null && optionalRabatCode.length > 0 && optionalRabatCode[0] != null) {
                discount = Discount.getDiscountByRabatCode(optionalRabatCode[0]);
            }

            setPrice(resolvePriceWithConverter(car.getPricePerDay()) * discount);

            car.rent();

            user.addCarToList(car);
            System.out.println("User with login: " + user.getLogin() +
                    " has rented a car with type " + car.getType());
            System.out.println("Final rental cost: " + this.price + " PLN");
        }
    }

    public void cancelRent() {
        car.releaseCar();
        user.deleteCarFromList(car);

        System.out.println("The rental has been cancelled!");
    }

    private void setPrice(Double price) {
        this.price = Math.round(price * 100) / 100.0;
    }

    private void validateCarRental(Car car, LocalDate localDate, User user) {
        if (ObjectUtils.allNotNull(car, localDate, user)) {
            return;
        }

        System.out.println("Invalid car rental data!");
        System.exit(0);
    }

    public abstract Double resolvePriceWithConverter(Double carPricePerDay);
}