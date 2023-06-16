package pl.edu.wsiz;

public class NotFoundDiscountException extends RuntimeException{
    private String message;

    public NotFoundDiscountException(String message) {
        this.message = message;
    }
}
