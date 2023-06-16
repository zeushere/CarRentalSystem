package pl.edu.wsiz;


public class Main {

    public static void main(String[] args) {
        Provider provider = new CarRentalSystemProvider();
        provider.createCar(null, null, null, 0, 0.0);

        System.out.println("Hello world!");
    }
}