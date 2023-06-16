package pl.edu.wsiz;

import java.util.List;

public class Discount {
    private String discountCode;
    private String discountPercent;

    public static String getDiscountByRabatCode(String discountCode, List<Discount> discountList) {
        Discount foundDiscount = discountList
                .stream()
                .filter(discount -> discountCode.equals(discount.discountCode))
                .findFirst()
                .orElse(null);

        if(foundDiscount == null) {
            System.out.println("Not found discount with code:" + discountCode);
            throw new NotFoundDiscountException("Not found discount with code:" + discountCode);
        }

        return foundDiscount.discountPercent;
    }

    public Discount(String discountCode, String discountPercent) {
        this.discountCode = discountCode;
        this.discountPercent = discountPercent;
    }
}
