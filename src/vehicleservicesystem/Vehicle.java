package vehicleservicesystem;

// Razan Alamri, Vehicle Service System , 17-4-2021.
public abstract class Vehicle implements Comparable<Vehicle> {

    // Data filed of Vehicle
    protected String icense_number;
    protected String make;
    protected String model;
    protected double price;

    // contructors of Vehicle
    public Vehicle(String icense_number, String make, String model, double price) {

        this.icense_number = icense_number;
        this.make = make;
        this.model = model;
        this.price = price;
    }

    // Setters and Getters of Data filed
    public String getIcense_number() {
        return icense_number;
    }

    public void setIcense_number(String icense_number) {
        this.icense_number = icense_number;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // return the Vehicle Name
    public String getVehicleName() {
        return make + " " + model;
    }

    // abstract method
    public abstract double calcPrice();

    // public abstract int compareTo(Vehicle vehicleCompare);

    // Override and return to String
    @Override
    public String toString() {
        return "Vehicle{" + "icwnse_number=" + icense_number + ", make=" + make + ", model=" + model + ", price="
                + price + '}';
    }

}
