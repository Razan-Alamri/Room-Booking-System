
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 
*/
public class RoomBookingSystem {
    /*----------------------------------------------------------------------
    Q2: define here 4 ArrayList: 
    1- ArrayList to save all Room objects and name it ‘room’
    2- ArrayList to save all Event objects and name it ‘event’ 
    3- ArrayList to save all Employee objects and name it ‘employee’.
    4- ArrayList to save all Booking objects and name it ‘Booking’.
    ------------------------------------------------------------------------*/
    private static ArrayList<Room> room = new ArrayList<>();
    private static ArrayList<Event> event = new ArrayList<>();
    private static ArrayList<Employee> employee = new ArrayList<>();
    private static ArrayList<Booking> Booking = new ArrayList<>();

    private static int R_No;
    private static String Event_Name;
    private static int Emp_ID;

    public static void main(String[] args) throws FileNotFoundException {

        File F1 = new File("INPUT.txt");
        File F2 = new File("OUTPUT.txt");
        if (!F1.exists()) {
            System.out.println("Input file" + F1.getName() + " does not exist");
            System.exit(0);
        }
        Scanner input = new Scanner(F1);
        PrintWriter output = new PrintWriter(F2);
        output.println("\nWelcome to the Room Booking System!\n");
        output.println();

        String command;

        do {
            command = input.next();
            if (command.equalsIgnoreCase("ADD_ROOM")) {
                AddRoom(input, output);// // Reading data from the file
            } else if (command.equalsIgnoreCase("ADD_EVENT")) {
                AddEvent(input, output);// // Reading data from the file
            } else if (command.equalsIgnoreCase("ADD_STAFF")) {
                AddStaff(input, output);// // Reading data from the file
            } else if (command.equalsIgnoreCase("ADD_FACILTY")) {
                AddFaculty(input, output);// // Reading data from the file
            } else if (command.equalsIgnoreCase("BOOKING")) {
                /*----------------------------------------------------------------------
                   Q3: Implement BOOKING Command: 
                    1- First note that all the arguments for Booking already beeing read from file
                    2- This command has 3 arguments: the ROOM NUMBER, ERVENT NAME, and EMPLOYEE ID.
                       a)search for the room index using 'searchRoomIndex' method that will return the index 
                         of the requested room(exists in the room ArrayList) in case it was found, otherwise return -1.
                       b)search for the event index using 'searchEventIndex' method that will return the index 
                         of the event(exists in the event ArrayList) in case it was found, otherwise return -1.
                       c)search for the employee index using 'searchEmployeeIndex' method that will return the index 
                         of the employee who want to book a room for the event (moderator of the event) 
                         (exists in the employee ArrayList) in case it was found, otherwise return -1.
                    3-Check the capacity of the requested room if it can NOT accommodate the number of attendees of the event.
                      write the following message in the output file :
                      "UnUnsuccessfull Booking "
                      "Attendees number is exceed the Room" (put Room Number here) " capacity "
                       if it is not go to next step.
                    4-Check if the employee who want to book a room is a STAFF EMPLOYEE 
                      if employee is faculty employee, write the following message in the output file :
                      "UnUnsuccessfull Booking "
                      "Employee with ID "(put employee id here) " is not a Staff Employee."
                       if it is not go to next step.
                    5-In case room has enough capacity and the moderator is staff employee:
                      a)Generate a random booking number
                      b)Assign require room object in the room Arraylist to a new room object(use room index)
                      c)Assign require event object in the event Arraylist to a new event object(use event index)
                      d)Assign require employee object in the employee Arraylist to a new employee object(use room index)
                      e)create booking object and add it to booking Arraylist
                      f)change the status of room to ("Reserved")
                      g)In the output file write the following message:
                        "Booking with Number (put the generated booking number here) is created and added to booking array list\n"
                      h)print booking details using toString Method in Booking class.
                              */
                AddBooking(input, output);
            }
        } while (!command.equalsIgnoreCase("Quit"));

        output.println("\nThank you for using the Room Booking System, Good Bye!");
        /*
         * ----------------------------------------------------------------------
         * Close input and output files
         * ----------------------------------------------------------------------
         */
        input.close();
        output.close();
    }

    public static void AddRoom(Scanner input, PrintWriter output) {
        /*----------------------------------------------------------------------
             Q4: Implement ADD_ROOM Command: 
             1- Read the number of Room from the input file.
             2-implement a loop that go through the number of Room
             3-First note that all the arguments for Add_Room already beeing read in Command 
             4- Create Room object 
             5- Add the Room object to the Room  ArrayList ‘room’.
             6- In the output file write the following message:
             "Command: Room with (put room number here) was added successfully"
            ------------------------------------------------------------------------*/
        int numberOfRooms = input.nextInt();
        for (int i = 0; i < numberOfRooms; i++) {
            int room_No = input.nextInt();
            room.add(new Room(room_No, input.nextInt(), input.nextInt(), input.next()));
            output.println("Command: Room with " + room_No + " was added successfully");
        }
        output.println("\n--------------------------------------------------------------------\n");

    }

    public static void AddEvent(Scanner input, PrintWriter output) {
        // reading No of Events
        int no = input.nextInt();
        int i = 0;
        while (i < no) {
            // Reading Event information
            event.add(new Event(input.next(), input.next(), new Date(Long.parseLong(input.next())),
                    Double.parseDouble(input.next().replace(":", ".")),
                    Double.parseDouble(input.next().replace(":", ".")),
                    input.nextInt()));
            output.println("Command: Event " + event.get(i).getEventName() + " was added successfully");
            i++;
        }
        output.println(
                "\n------------------------------------------------------------------------------------------------------");
        output.println();
    }

    public static void AddStaff(Scanner input, PrintWriter output) {
        // reading No of Faculty Employee
        int no = input.nextInt();
        int i = 0;
        while (i < no) {
            // Reading Faculty Employee information
            int Emp_id = input.nextInt();
            employee.add(new Staff(Emp_id, input.next(), input.next(), input.nextInt(), input.nextInt(), input.next(),
                    input.next()));
            output.println("Command: Staff Employee with ID " + Emp_id + " was added successfully");
            i++;
        }
        output.println(
                "\n------------------------------------------------------------------------------------------------------");
        output.println();
    }

    public static void AddFaculty(Scanner input, PrintWriter output) {
        // reading No of Faculty Employee
        int no = input.nextInt();
        int i = 0;
        while (i < no) {
            // Reading Faculty Employee information
            int Emp_id = input.nextInt();
            employee.add(new Faculty(Emp_id, input.next(), input.next(), input.nextInt(), input.nextInt(), input.next(),
                    input.next()));
            output.println("Command: Faculty Employee with ID " + Emp_id + " was added successfully");
            i++;
        }
        output.println(
                "\n------------------------------------------------------------------------------------------------------");
        output.println();
    }

    public static int searchRoomIndex(int R_No) {
        int index = -1;
        for (int i = 0; i < room.size(); i++) {
            if (room.get(i).getRoomNo() == R_No) {
                index = i;
            }
        }
        return index;
    }

    public static int searchEventIndex(String Event_Name) {
        int index = -1;
        for (int i = 0; i < event.size(); i++) {
            if (event.get(i).getEventName().equalsIgnoreCase(Event_Name)) {
                index = i;
            }
        }
        return index;
    }

    public static int searchEmployeeIndex(int Emp_ID) {
        int index = -1;
        for (int i = 0; i < employee.size(); i++) {
            if (employee.get(i).getEmpID() == Emp_ID) {
                index = i;
            }
        }
        return index;
    }

    public static void AddBooking(Scanner input, PrintWriter output) {
        try {
            int numnerOfBookings = input.nextInt();

            int room_No = input.nextInt();
            int room_Index = searchRoomIndex(room_No);
            Room rooma = room.get(room_Index);
            if (room_Index != -1) {
                String event_Name = input.next();
                int event_Index = searchEventIndex(event_Name);
                Event evenra = event.get(event_Index);
                if (event_Index != -1) {
                    int employee_ID = input.nextInt();
                    int employee_Index = searchEmployeeIndex(employee_ID);
                    if (employee_Index != -1) {
                        if (rooma.Capacity > evenra.AttendeesNo) {

                            int book_No = (int) (Math.random() * 1000);
                            Booking.add(new Booking(book_No, room.get(room_Index), event.get(event_Index),
                                    employee.get(employee_Index)));
                            room.get(room_Index).setStatus("Reserved");
                            output.println(
                                    "Booking with Number " + book_No + " is created and added to booking array list");
                            output.println();
                            output.println(Booking.toString());

                        } else {
                            output.println("Unsuccessful Booking \n"
                                    + "Employee with ID " + employee_ID + " is not a Staff Employee");
                            input.nextLine();
                        }

                    } else {
                        output.println("Unsuccessful Booking \n"
                                + "Attendees number is\n" +
                                "exceed the Room " + room_No + " capacity");
                        input.nextLine();
                    }
                }
            }
        } catch (InputMismatchException ex) {
            System.out.println("inputMismatch ERROR");
        }
    }
}
