package pl.edu.wsiz.architecture;

import pl.edu.wsiz.util.User;

import java.time.LocalDate;

public abstract class Provider {

    public abstract CarRental createCarRental(CarRentalType carRentalType, LocalDate endRental, User user, String optionalDiscountCode);
}
