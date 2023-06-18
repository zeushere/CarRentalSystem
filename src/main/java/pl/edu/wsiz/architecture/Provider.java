package pl.edu.wsiz.architecture;

import pl.edu.wsiz.util.User;

import java.time.LocalDate;

public interface Provider {
    CarRental createCarRental(CarRentalType carRentalType, LocalDate endRental, User user, String optionalDiscountCode);
}
