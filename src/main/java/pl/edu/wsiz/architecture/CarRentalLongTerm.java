package pl.edu.wsiz.architecture;

import pl.edu.wsiz.util.User;

import java.time.LocalDate;

public class CarRentalLongTerm extends CarRental {

    CarRentalLongTerm(LocalDate endRental, User user, String optionalDiscountCode) {
        super(endRental, user, optionalDiscountCode);

        this.type = CarRentalType.LONG_TERM;
    }

    @Override
    protected Double resolvePriceWithConverter(Double carPrice) {
        return this.price = (carPrice * 0.9) * numberOfDays;
    }
}
