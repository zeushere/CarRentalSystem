package pl.edu.wsiz.rental;

import pl.edu.wsiz.car.Car;
import pl.edu.wsiz.util.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CarRentalLongTerm extends CarRental {

    public CarRentalLongTerm(Car car, LocalDate endRental, User user) {
        super(car, endRental, user);

        this.type = CarRentalType.CAR_RENTAL_LONG_TERM;
    }

    @Override
    public Double resolvePriceWithConverter(Double carPricePerDay) {
        long numberOfDays = ChronoUnit.DAYS.between(LocalDate.now(), endRental);
        if (numberOfDays <= 0) {
            numberOfDays++;
        }
        return this.price = (car.getPricePerDay() * 0.75) * numberOfDays;
    }
}
