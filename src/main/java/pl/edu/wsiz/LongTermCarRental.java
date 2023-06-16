package pl.edu.wsiz;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LongTermCarRental extends CarRental {

    protected LongTermCarRental(Car car, LocalDate endRental, User user) {
        super(car, endRental, user);

        this.type = "Long Term";
    }

    @Override
    public Double resolvePriceWithConverter(Double carPricePerDay) {
        long numberOfDays = ChronoUnit.DAYS.between(LocalDate.now(), endRental);
        if (numberOfDays == 0) {
            numberOfDays++;
        }
        return this.price = (car.pricePerDay * 0.75) * numberOfDays;
    }
}
