package pl.edu.wsiz.architecture;

import pl.edu.wsiz.util.User;

import java.time.LocalDate;

public class CarRentalProvider implements Provider {

    @Override
    public CarRental createCarRental(CarRentalType carRentalType, LocalDate endRental, User user, String optionalDiscountCode) {
        switch (carRentalType) {
            case SHORT_TERM -> {
                return new CarRentalShortTerm(endRental, user, optionalDiscountCode);
            }
            case LONG_TERM -> {
                return new CarRentalLongTerm(endRental, user, optionalDiscountCode);
            }
            default -> throw new IllegalStateException("Unexpected value: " + carRentalType);
        }
    }
}
