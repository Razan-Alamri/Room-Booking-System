package vehicleservicesystem;

// Razan Alamri, IAR, Vehicle Service System , 17-4-2021.
public class Sale extends Vehicle {

    // Data filed of Sale
    private double sell_price;
    private double discount;
    private double rate;

    // contructors of Sale
    public Sale(String icense_number, String make, String model, double price, double rate) {

        super(icense_number, make, model, price);
        this.rate = rate;
        this.discount = price * (rate / 100);
        this.sell_price = price - (discount);// culculate the price after discount
    }

    // Setters and Getters of Data filed
    public double getSell_price() {
        return sell_price;
    }

    public void setSell_price(double sell_price) {
        this.sell_price = sell_price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    // Override abstract method , return sell price
    @Override
    public double calcPrice() {
        return this.sell_price;
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

    // Override and return to String
    @Override
    public String toString() {
        return "	License # : " + getIcense_number() + "\n	Vehicle Name : " + getVehicleName() + "\n	Price : "
                + this.price + "\n	Discount rate	:" + rate + " % " + "\n	Selling Price 	:" + calcPrice();
    }

}
