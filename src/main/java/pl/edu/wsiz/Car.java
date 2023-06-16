package pl.edu.wsiz;

public abstract class Car {
    protected String type;
    protected String brand;
    protected String model;
    protected Integer year;
    protected Double pricePerDay;
    protected Boolean isAvailable = true;

    public Car(String brand, String model, Integer year, Double pricePerDay) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.pricePerDay = pricePerDay;
    }

    public boolean checkAvailability() {
        if(!isAvailable) {
            String message = "Car with type " + this.type + " is not available!";
            System.out.println(message);
            return false;
        }

        System.out.println("Car with type " + this.type + " is available.");
        return true;
    }

    public abstract void rent();

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", pricePerDay=" + pricePerDay +
                '}';
    }
}
