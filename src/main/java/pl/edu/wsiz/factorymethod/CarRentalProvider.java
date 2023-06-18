package pl.edu.wsiz.factorymethod;

import pl.edu.wsiz.bridge.CarRental;
import pl.edu.wsiz.bridge.CarRentalLongTerm;
import pl.edu.wsiz.bridge.CarRentalShortTerm;
import pl.edu.wsiz.bridge.CarRentalType;
import pl.edu.wsiz.util.User;

import java.time.LocalDate;

public class CarRentalProvider extends Provider {

    @Override
    public CarRental createCarRental(CarRentalType carRentalType, LocalDate endRental, User user, String optionalDiscountCode) {
        switch (carRentalType) {
            case CAR_RENTAL_SHORT_TERM -> {
                return new CarRentalShortTerm(endRental, user, optionalDiscountCode);
            }
            case CAR_RENTAL_LONG_TERM -> {
                return new CarRentalLongTerm(endRental, user, optionalDiscountCode);
            }
            default -> throw new IllegalStateException("Unexpected value: " + carRentalType);
        }
    }
}
