package vehicleservicesystem;

// Razan Alamri, IAR, Vehicle Service System , 17-4-2021.
public class Rental extends Vehicle {

    // Data filed of Rental
    protected double rate_per_day;
    protected Customer[] rentedTo;
    protected int currentCustomerNo;

    // contructors of Rental
    public Rental(String icense_number, String make, String model, double price, double rpd, int max) {

        super(icense_number, make, model, price);
        this.rate_per_day = rpd;
        rentedTo = new Customer[max];
    }

    // adding customer object to rentedTo array and set the number of days
    public void addCustomer(Customer c, int numOfDays) {
        rentedTo[currentCustomerNo] = c;
        c.setRental_days(numOfDays);
        currentCustomerNo++;
    }

    // Setters and Getters of Data filed
    public Customer[] getRentedTo() {
        return rentedTo;
    }

    public void setRentedTo(Customer[] rentedTo) {
        this.rentedTo = rentedTo;
    }

    public Customer[] getCustomer() {
        return rentedTo;
    }

    public int getCurrentCustomerNo() {
        return currentCustomerNo;
    }

    public double getRate_per_day() {
        return rate_per_day;
    }

    // Override compareTo method
    @Override
    public int compareTo(Vehicle vehicleCompare) {

        if (getIcense_number().compareTo(vehicleCompare.getIcense_number()) > 0) {

            // if current object is greater,then return 1
            return 1;
        } else if (getIcense_number().compareTo(vehicleCompare.getIcense_number()) < 0) {

            // if current object is greater,then return -1
            return -1;
        } else {

            // if current object is equal to o,then return 0
            return 0;
        }
    }

    // Override abstract method
    @Override
    public double calcPrice() {
        return 0;
    }

    // Override and return to String
    @Override
    public String toString() {
        return "	License # : " + getIcense_number() + "\n	Vehicle Name : " + getVehicleName() + "\n	Price : "
                + this.price + "	Rate per day: " + this.rate_per_day;
    }

}
