package pl.edu.wsiz;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ShortTermCarRental extends CarRental {


    protected ShortTermCarRental(Car car, LocalDate endRental, User user) {
        super(car, endRental, user);

        this.type = "Short Term";
    }

    @Override
    public Double resolvePriceWithConverter(Double carPricePerDay) {
        long numberOfDays = ChronoUnit.DAYS.between(LocalDate.now(), endRental);
        if (numberOfDays == 0) {
            numberOfDays++;
        }

        return this.price = (car.pricePerDay * 1) * numberOfDays;
    }
}
