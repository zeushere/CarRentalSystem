package pl.edu.wsiz;

public class NotAvailableCarException extends RuntimeException {
    private String message;

    public NotAvailableCarException(String message) {
        this.message = message;
    }
}
