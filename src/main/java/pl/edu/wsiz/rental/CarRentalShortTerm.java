package pl.edu.wsiz.rental;

import pl.edu.wsiz.car.Car;
import pl.edu.wsiz.util.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CarRentalShortTerm extends CarRental {

    public CarRentalShortTerm(Car car, LocalDate endRental, User user) {
        super(car, endRental, user);

        this.type = CarRentalType.CAR_RENTAL_SHORT_TERM;
    }

    @Override
    public Double resolvePriceWithConverter(Double carPricePerDay) {
        long numberOfDays = ChronoUnit.DAYS.between(LocalDate.now(), endRental);
        if (numberOfDays <= 0) {
            numberOfDays++;
        }

        return this.price = (car.getPricePerDay() * 1) * numberOfDays;
    }
}
