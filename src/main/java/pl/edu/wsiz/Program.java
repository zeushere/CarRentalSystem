package pl.edu.wsiz;


import pl.edu.wsiz.car.Car;
import pl.edu.wsiz.car.CarType;
import pl.edu.wsiz.provider.CarProvider;
import pl.edu.wsiz.provider.Provider;
import pl.edu.wsiz.rental.CarRental;
import pl.edu.wsiz.rental.CarRentalLongTerm;
import pl.edu.wsiz.rental.CarRentalShortTerm;
import pl.edu.wsiz.util.Discount;
import pl.edu.wsiz.util.User;

import java.time.LocalDate;

import static pl.edu.wsiz.util.User.registerUser;

public class Program {

    public static void main(String[] args) {
        System.out.println("---------------------------------------");
        System.out.println("Welcome to CarRentalSystem Application!");
        System.out.println("---------------------------------------");

        //loading initial data of discounts
        addInitialDiscounts();

        //validation of discount percent
        new Discount("test", "test");
        new Discount("test", "0%");

        System.out.println("---------------------------------------");

        //user registration
        User userKacper = registerUser("Kacper", "Roda", "kacper.roda", "Kacper123");
        User userWojciech = registerUser("Wojciech", "Nowak", "wojciech.nowak", "Wojciech123");
        User userDaria = registerUser("Daria", "Kowalska", "daria.kowalska", "Daria123");

        System.out.println("---------------------------------------");

        //validation of registration process
        registerUser("Invalid", "User", "kacper.roda", "Kacper123");
        registerUser("Invalid", "User", "", "Kacper123");

        System.out.println("---------------------------------------");

        //creating cars by provider(factory method)
        Provider provider = new CarProvider();
        Car firstCar = provider.createCar(CarType.CAR_ECONOMY, "Opel", "Insignia", 2009, 50.0);
        Car secondCar = provider.createCar(CarType.CAR_FAMILY, "Volkswagen", "Touran", 2007, 40.0);

        //validation of creating cars
        provider.createCar(CarType.CAR_DELIVERY, "", "", 2011, 32.0);

        System.out.println("---------------------------------------");

        //creating long term rental with discount
        CarRental firstCarRental = new CarRentalLongTerm(firstCar, LocalDate.of(2023, 7, 15), userKacper);
        firstCarRental.rentCar("SPRING");

        System.out.println("---------------------------------------");

        //trying to rent not available car
        CarRental secondCarRental = new CarRentalShortTerm(firstCar, LocalDate.of(2023, 6, 26), userDaria);
        secondCarRental.rentCar("SUMMER");

        System.out.println("---------------------------------------");

        //cancelling rent
        firstCarRental.cancelRent();

        System.out.println("---------------------------------------");


        //renting after cancel rent
        secondCarRental.rentCar("SUMMER");

        System.out.println("---------------------------------------");

        //renting without discount
        CarRental thirdCarRental = new CarRentalLongTerm(secondCar, LocalDate.of(2023, 7, 26), userWojciech);
        thirdCarRental.rentCar();
        System.out.println("---------------------------------------");
    }

    private static void addInitialDiscounts() {
        new Discount("SPRING", "35%");
        new Discount("SUMMER", "20%");
        new Discount("AUTUMN", "40%");
        new Discount("WINTER", "60%");
    }
}