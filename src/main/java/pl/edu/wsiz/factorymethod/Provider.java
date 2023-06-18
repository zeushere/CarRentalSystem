package pl.edu.wsiz.factorymethod;

import pl.edu.wsiz.bridge.CarRental;
import pl.edu.wsiz.bridge.CarRentalType;
import pl.edu.wsiz.util.User;

import java.time.LocalDate;

public abstract class Provider {

    public abstract CarRental createCarRental(CarRentalType carRentalType, LocalDate endRental, User user, String optionalDiscountCode);
}
