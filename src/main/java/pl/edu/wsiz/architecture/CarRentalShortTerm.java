package pl.edu.wsiz.architecture;

import pl.edu.wsiz.util.User;

import java.time.LocalDate;

public class CarRentalShortTerm extends CarRental {

    CarRentalShortTerm(LocalDate endRental, User user, String optionalDiscountCode) {
        super(endRental, user, optionalDiscountCode);

        this.type = CarRentalType.SHORT_TERM;
    }

    @Override
    protected Double resolvePriceWithConverter(Double carPrice) {
        return this.price = (carPrice * 1) * numberOfDays;
    }
}
