package pl.edu.wsiz.util;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class Discount {

    private static final List<Discount> DISCOUNT_LIST = new ArrayList<>();
    private String discountCode;
    private String discountPercent;

    public Discount(String discountCode, String discountPercent) {
        if (!validateDiscount(discountCode, discountPercent)) {
            return;
        }

        this.discountCode = discountCode;
        this.discountPercent = discountPercent;
        DISCOUNT_LIST.add(this);
    }

    public static Double getDiscountByDiscountCode(String discountCode) {
        Discount foundDiscount = DISCOUNT_LIST
                .stream()
                .filter(discount -> discountCode.equals(discount.discountCode))
                .findFirst()
                .orElse(null);

        if (foundDiscount == null) {
            System.out.println("Not found discount with code: " + discountCode);
            return 1.0;
        }

        System.out.println("Activate " + foundDiscount.discountPercent + " discount");
        return 1 - Double.parseDouble(foundDiscount.discountPercent.replace("%", "")) / 100;
    }

    private Boolean validateDiscount(String discountCode, String discountPercent) {
        if (!(isNotBlank(discountCode) && isNotBlank(discountPercent)
                && discountPercent.matches("\\d+(?:\\.\\d+)?%")
                && Double.parseDouble(discountPercent.replace("%", "")) > 0)) {
            System.out.println("Invalid discount!");
            return false;
        }
        return true;
    }
}
