package pl.edu.wsiz.bridge;

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

    protected CarRental(LocalDate endRental, User user, String optionalDiscountCode) {
        validateCarRental(endRental, user);
        this.endRental = endRental;
        this.user = user;
        this.optionalDiscountCode = optionalDiscountCode;
    }

    protected void rent(Double carPrice) {
        System.out.println("Start " + type.getType() + " process rental...");
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

    private Double calculateDiscount(String... optionalRabatCode) {
        if (optionalRabatCode != null && optionalRabatCode.length > 0 && optionalRabatCode[0] != null) {
            return Discount.getDiscountByDiscountCode(optionalRabatCode[0]);
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

    protected void resolveNumberOfDays(LocalDate endRental) {
        long numberOfDays = ChronoUnit.DAYS.between(LocalDate.now(), endRental);
        if (numberOfDays <= 0) {
            numberOfDays++;
        }
        this.numberOfDays = numberOfDays;
    }

    protected abstract Double resolvePriceWithConverter(Double carPricePerDay);
}