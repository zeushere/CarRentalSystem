package pl.edu.wsiz.bridge;

public enum CarRentalType {

    CAR_RENTAL_SHORT_TERM("Short Term"),
    CAR_RENTAL_LONG_TERM("Long Term");

    private final String type;

    CarRentalType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
