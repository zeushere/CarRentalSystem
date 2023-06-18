package pl.edu.wsiz;


import pl.edu.wsiz.architecture.Car;
import pl.edu.wsiz.architecture.CarDelivery;
import pl.edu.wsiz.architecture.CarEconomy;
import pl.edu.wsiz.architecture.CarFamily;
import pl.edu.wsiz.architecture.CarLuxury;
import pl.edu.wsiz.architecture.CarRental;
import pl.edu.wsiz.architecture.CarRentalProvider;
import pl.edu.wsiz.architecture.Provider;
import pl.edu.wsiz.util.Discount;
import pl.edu.wsiz.util.User;

import java.time.LocalDate;

import static pl.edu.wsiz.architecture.CarRentalType.LONG_TERM;
import static pl.edu.wsiz.architecture.CarRentalType.SHORT_TERM;
import static pl.edu.wsiz.util.User.registerUser;

public class Program {

    public static void main(String[] args) {
        System.out.println("---------------------------------------");
        System.out.println("Welcome to CarRentalSystem Application!");
        System.out.println("---------------------------------------");

        //creating provider(factory method)
        Provider provider = new CarRentalProvider();

        //loading initial data of discounts
        addInitialDiscounts();

        //validation of discount percent
        new Discount("test", "test");
        new Discount("test", "0%");

        System.out.println("---------------------------------------");

        //user registration
        User userKacper = registerUser("Kacper", "Roda", "kacper.roda@wp.pl", "Kacper123");
        User userWojciech = registerUser("Wojciech", "Nowak", "wojciech.nowak@onet.pl", "Wojciech123");
        User userDaria = registerUser("Daria", "Kowalska", "daria.kowalska@gmail.com", "Daria123");

        System.out.println("---------------------------------------");

        //validation of registration process
        registerUser("Invalid", "User", "kacper.roda@wp.pl", "Kacper123");
        registerUser("Invalid", "User", "", "Kacper123");

        System.out.println("---------------------------------------");

        //long term renting car with discount
        CarRental firstCarRental = provider.createCarRental(LONG_TERM, LocalDate.of(2023, 7, 31), userKacper, "SPRING");
        Car firstCar = new CarEconomy("Opel", "Insignia", 2009, 25.00, firstCarRental);
        firstCar.rent();
        System.out.println("---------------------------------------");

        //validation of creating cars
        new CarDelivery("", "", 2011, 32.00, firstCarRental);

        System.out.println("---------------------------------------");

        //trying to rent not available car
        CarRental secondCarRental = provider.createCarRental(SHORT_TERM, LocalDate.of(2023, 7, 1), userWojciech, null);
        firstCar.setCarRental(secondCarRental);
        firstCar.rent();

        System.out.println("---------------------------------------");

        //releasing car
        firstCar.setCarRental(firstCarRental);
        firstCar.releaseCar();

        System.out.println("---------------------------------------");

        //short term renting car without discount
        firstCar.setCarRental(secondCarRental);
        firstCar.rent();

        System.out.println("---------------------------------------");

        //long term renting car with invalid discount
        CarRental thirdCarRental = provider.createCarRental(LONG_TERM, LocalDate.of(2023, 8, 12), userDaria, "invalid");
        Car secondCar = new CarLuxury("Porsche", "Panamera", 2016, 45.00, thirdCarRental);
        secondCar.rent();
        System.out.println("---------------------------------------");

        //short term renting car with discount
        CarRental fourthCarRental = provider.createCarRental(SHORT_TERM, LocalDate.of(2023, 7, 2), userDaria, "SUMMER");
        Car thirdCar = new CarFamily("Volkswagen", "Touran", 2007, 35.00, fourthCarRental);
        thirdCar.rent();
        System.out.println("---------------------------------------");
    }

    private static void addInitialDiscounts() {
        new Discount("SPRING", "35%");
        new Discount("SUMMER", "20%");
        new Discount("AUTUMN", "40%");
        new Discount("WINTER", "60%");
    }
}