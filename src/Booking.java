/*

*/
public class Booking {
   int BNo;
   Room room;
   Event event;
   Employee modarator;

   public Booking(int BNo, Room room, Event event, Employee modarator) {
      this.BNo = BNo;
      this.room = room;
      this.event = event;
      this.modarator = modarator;
   }

   public void setroom(Room room) {
      this.room = room;
   }

   public Room getroom() {
      return room;
   }

   public void setevent(Event event) {
      this.event = event;
   }

   public Event getevent() {
      return event;
   }

   public void setmodarator(Employee modarator) {
      this.modarator = modarator;
   }

   public Employee getmodarator() {
      return modarator;
   }

   @Override
   public String toString() {
      return " Booking Number : " + this.BNo + " \nRoom information : " + room.toString() +
            " \nEvent details : " + event.toString() + " \nModarator of this event : " + this.modarator;
   }
}
