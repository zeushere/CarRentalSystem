package pl.edu.wsiz.bridge;

import pl.edu.wsiz.util.User;

import java.time.LocalDate;

public class CarRentalLongTerm extends CarRental {

    public CarRentalLongTerm(LocalDate endRental, User user, String optionalDiscountCode) {
        super(endRental, user, optionalDiscountCode);

        this.type = CarRentalType.CAR_RENTAL_LONG_TERM;
    }

    @Override
    protected Double resolvePriceWithConverter(Double carPrice) {
        return this.price = (carPrice * 0.9) * numberOfDays;
    }
}
