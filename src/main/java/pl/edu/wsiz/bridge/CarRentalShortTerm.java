package pl.edu.wsiz.bridge;

import pl.edu.wsiz.util.User;

import java.time.LocalDate;

public class CarRentalShortTerm extends CarRental {

    public CarRentalShortTerm(LocalDate endRental, User user, String optionalDiscountCode) {
        super(endRental, user, optionalDiscountCode);

        this.type = CarRentalType.CAR_RENTAL_SHORT_TERM;
    }

    @Override
    protected Double resolvePriceWithConverter(Double carPrice) {
        return this.price = (carPrice * 1) * numberOfDays;
    }
}
