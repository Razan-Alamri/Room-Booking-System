package vehicleservicesystem;

// Razan Alamri, IAR, Vehicle Service System , 17-4-2021.
import java.io.*;
import java.util.*;

public class VehicleServiceSystem {

    // arrys indexes
    static int countVehicle = 0;
    static int countCustomer = 0;

    public static void main(String[] args) throws Exception {

        File inputFile = new File("input.txt");
        // check if the inputFile is exists
        if (!inputFile.exists()) {
            System.out.println("The File " + inputFile.getName() + " is not exists");
            System.exit(0);
        }
        // making txt file to print Log in it.
        File outputFile = new File("output.txt");
        // PrintWriter for that file.
        PrintWriter printSystem = new PrintWriter(outputFile);
        // Scanner to read from Input txt file.
        Scanner inputSystem = new Scanner(inputFile);

        // declare arrays for processes
        Vehicle[] VehicleArry = new Vehicle[inputSystem.nextInt()];
        Customer[] CustomerArry = new Customer[inputSystem.nextInt()];

        // print header.
        printSystem.println("--------------- Welcome to X Vehicle store System ---------------");

        String check;
        // **** Reading the commands from input ****
        while (inputSystem.hasNext()) {
            check = inputSystem.next();
            if (check.equalsIgnoreCase("Add_Customer_Record")) {// command for adding Customer.
                printSystem.print("\nCommand Add_Customer: \n"
                        + "Add a new Customer record in the System");
                CustomerArry[countCustomer] = getCustomer(inputSystem);
                printSystem.print(CustomerArry[countCustomer].toString());// print CustomerArry.
                printSystem
                        .println("\n\n-------------------------------------------------------------------------------");
                countCustomer++;

            } else if (check.equalsIgnoreCase("Add_Rental")) {// command for adding Rental to VehicleArry.
                printSystem.print("Command Add_Rental: Add a new vehicles for rent in the System\n\n");
                VehicleArry[countVehicle] = getRental(inputSystem);
                printSystem.print(VehicleArry[countVehicle].toString());// print Rental.
                printSystem.println("\n----------------------------------------------------------------");
                countVehicle++;

            } else if (check.equalsIgnoreCase("Add_Sale")) {// command for adding Sale to VehicleArry.
                printSystem.print("Command Add_Sale: Add a new new vehicles for sale in the System\n\n");
                VehicleArry[countVehicle] = getSale(inputSystem);
                printSystem.print(VehicleArry[countVehicle].toString());// print Sale.
                printSystem.println("\n----------------------------------------------------------------");
                countVehicle++;

            } else if (check.equalsIgnoreCase("Ass_Customer_to_Rent")) {// command assign customer to a rented vehicle.
                printSystem.print("Command Ass_Customer_to_Rent: A  Customer rent a vehicle \n");
                getAssCustomertoRent(inputSystem, VehicleArry, CustomerArry, printSystem);
                printSystem.println("-------------------------------------------------------------------------------");

            } else if (check.equalsIgnoreCase("Print_Rental")) {// command for Print information of about the vehicles
                                                                // for rent.
                PrintRentalOrder(inputSystem, VehicleArry, printSystem);

            } else if (check.equalsIgnoreCase("Print_Sale")) {// command for Print information of about the vehicles for
                                                              // sale.
                PrintSaleOrder(inputSystem, VehicleArry, printSystem);

            } else if (check.equalsIgnoreCase("Quit")) {// command for quit.
                printSystem.println("\n\nThank you for using X Store Vehicle System, Good Bye!");
                break;
            }
        }

        // * closing the printWriter and input for input(1).txt and output(1).txt *
        inputSystem.close();
        printSystem.flush();
        printSystem.close();
    }
    // --------------------- this method will read and add new Customer to the
    // Customerarray of objects.

    private static Customer getCustomer(Scanner inputSystem) {

        return new Customer(inputSystem.nextInt(), inputSystem.next(), inputSystem.next(), inputSystem.next().charAt(0),
                inputSystem.nextInt());

    }

    // --------------------- this method will read and add new Rental to the
    // Vehiclearray of objects.
    private static Rental getRental(Scanner inputSystem) {

        return new Rental(inputSystem.next(), inputSystem.next(), inputSystem.next(), inputSystem.nextDouble(),
                inputSystem.nextDouble(), inputSystem.nextInt());

    }

    // --------------------- this method will read and add new Sale to the
    // Vehiclearray of objects.
    private static Sale getSale(Scanner inputSystem) {

        return new Sale(inputSystem.next(), inputSystem.next(), inputSystem.next(), inputSystem.nextDouble(),
                inputSystem.nextDouble());

    }
    // --------------------- this method will assign customer to a rented vehicle.

    private static void getAssCustomertoRent(Scanner inputSystem, Vehicle[] VehicleArry, Customer[] CustomerArry,
            PrintWriter printSystem) {

        // read License Number from input
        String checkLicenseNumber = inputSystem.next();
        // search for the vehicle object associated with the given license number.
        Rental checkRentalObject = checkRental(VehicleArry, checkLicenseNumber);

        // read Customer ID from input
        int checkCustomerID = inputSystem.nextInt();
        // search for the customer object associated with the given id.
        Customer checkCustomerObject = checkCustomer(CustomerArry, checkCustomerID);

        // check if Not found License Number ptint message
        if (checkRentalObject == null) {

            printSystem.println("Vehicle Not found: " + checkLicenseNumber);
            return;
        }
        // check if Not found Customer ID ptint message
        if (checkCustomerObject == null) {

            printSystem.println("Customer Not found: " + checkCustomerID);
            return;
        }
        // check the vehicle maximum rentersÕ capacity before assigning the vehicle to
        // the customer.
        if (checkRentalObject.rentedTo.length == checkRentalObject.currentCustomerNo) {

            printSystem.println("This vehicle reaches the max number of rent: " + checkLicenseNumber);
        } else {

            // read Number Of Days from input
            int sendNumberOfDays = inputSystem.nextInt();
            // adding customer object to rentedTo array and set the number of days
            checkRentalObject.addCustomer(checkCustomerObject, sendNumberOfDays);

            printSystem.println("\nCustomer: " + checkCustomerID + "	Rents Vehicle : 	" + checkLicenseNumber);
        }
    }

    // serch for Icense number.
    private static Rental checkRental(Vehicle[] VehicleArry, String checkLicenseNumber) {

        for (Vehicle VehicleArry1 : VehicleArry) {
            if (VehicleArry1 instanceof Rental) {
                if (VehicleArry1.getIcense_number().equals(checkLicenseNumber)) {
                    return (Rental) VehicleArry1;
                }
            }
            if (VehicleArry1 == null) {
                return null;
            }
        }
        return null;
    }

    // serch for Customer ID.
    private static Customer checkCustomer(Customer[] CustomerArry, int checkCustomerID) {

        for (Customer CustomerArry1 : CustomerArry) {

            if (CustomerArry1 == null) {
                return null;
            }
            if (CustomerArry1.getId() == checkCustomerID) {
                return CustomerArry1;
            }
        }
        return null;
    }
    // print all information about the vehicles for rent with records of all
    // customers rented that vehicle if any.

    private static void PrintRentalOrder(Scanner inputSystem, Vehicle[] VehicleArry, PrintWriter printSystem) {

        printSystem.println("\nCommand: Print_Rental\n\n\n"
                + "==================================================================");
        // srting VehicleArry array
        Arrays.sort(VehicleArry, 0, countVehicle);

        for (Vehicle VehicleArry1 : VehicleArry) {

            // taking only Rental from the VehicleArry1
            if (VehicleArry1 instanceof Rental) {
                printSystem.println("\n" + VehicleArry1);
                printSystem.println("------------\n\n	Rented to: ");
                int numberOfCustmer = 1;

                if (((Rental) VehicleArry1).getCurrentCustomerNo() == 0) {
                    printSystem.println("	No body");
                } else {
                    printSystem.println();
                    for (int a = 0; a < ((Rental) VehicleArry1).getCurrentCustomerNo(); a++) {
                        printSystem.println("	Customer # " + (numberOfCustmer) + "	ID: "
                                + ((Rental) VehicleArry1).getCustomer()[a].getId() + "	Number of Days: "
                                + ((Rental) VehicleArry1).getCustomer()[a].getRental_days() + "	Price: "
                                + ((Rental) VehicleArry1).getCustomer()[a].getRental_days()
                                        * ((Rental) VehicleArry1).getRate_per_day());
                        numberOfCustmer++;
                    }
                }
                printSystem.println("-------------------------------------------------------------------------------");
            }
        }
    }

    // print the sale vehicle sorted according to the license number.
    private static void PrintSaleOrder(Scanner inputSystem, Vehicle[] VehicleArry, PrintWriter printSystem) {

        printSystem.println("\n\nCommand: Print_Sale\n\n\n"
                + "==================================================================\n");
        for (Vehicle VehicleArry1 : VehicleArry) {

            // taking only Sale from the VehicleArry1
            if (VehicleArry1 instanceof Sale) {
                printSystem.println(VehicleArry1);
                printSystem.println("----------------------------------------------------------------");
            }
        }
    }
}
