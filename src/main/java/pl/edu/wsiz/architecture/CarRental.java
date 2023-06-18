package pl.edu.wsiz.architecture;

import org.apache.commons.lang3.ObjectUtils;
import pl.edu.wsiz.util.Discount;
import pl.edu.wsiz.util.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class CarRental {

    protected LocalDate endRental;

    protected String optionalDiscountCode;
    protected User user;
    protected CarRentalType type;
    protected Double price;
    protected Long numberOfDays;
    protected Boolean carRentalActive = false;

    CarRental(LocalDate endRental, User user, String optionalDiscountCode) {
        validateCarRental(endRental, user);
        this.endRental = endRental;
        this.user = user;
        this.optionalDiscountCode = optionalDiscountCode;
    }

    protected void rent(Double carPrice) {
        System.out.println("Start " + type + " process rental...");
        carRentalActive = true;

        resolveNumberOfDays(endRental);

        Double discount;
        if (optionalDiscountCode != null) {
            discount = calculateDiscount(optionalDiscountCode);
            setPrice(resolvePriceWithConverter(carPrice) * discount);
        } else {
            setPrice(resolvePriceWithConverter(carPrice));
        }

        System.out.println("User with email: " + user.getEmail() +
                " has rented a car. Number of days: " + this.numberOfDays);
        System.out.println("Final rental cost: " + this.price + " PLN");
    }

    protected void cancel() {
        if (carRentalActive) {
            carRentalActive = false;
            System.out.println("The rental has been cancelled!");
            return;
        }
        System.out.println("Rental is not active!");
    }

    protected abstract Double resolvePriceWithConverter(Double carPricePerDay);

    private Double calculateDiscount(String optionalDiscountCode) {
        if (optionalDiscountCode != null) {
            return Discount.getDiscountByDiscountCode(optionalDiscountCode);
        }
        return 1.0;
    }

    private void setPrice(Double price) {
        this.price = Math.round(price * 100) / 100.0;
    }

    private void validateCarRental(LocalDate localDate, User user) {
        if (ObjectUtils.anyNull(localDate, user)) {
            System.out.println("Invalid car rental data!");
            System.exit(0);
        }
    }

    private void resolveNumberOfDays(LocalDate endRental) {
        long numberOfDays = ChronoUnit.DAYS.between(LocalDate.now(), endRental);
        if (numberOfDays <= 0) {
            numberOfDays++;
        }
        this.numberOfDays = numberOfDays;
    }
}