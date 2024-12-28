/*
 
*/
public class Room {

   int RoomNo;
   int Floor;
   int Capacity;
   String Status;

   public Room() {
   }

   public Room(int RoomNo, int Floor, int Capacity, String Status) {
      this.RoomNo = RoomNo;
      this.Floor = Floor;
      this.Capacity = Capacity;
      this.Status = Status;
   }

   public void setRoomNo(int RoomNo) {
      this.RoomNo = RoomNo;
   }

   public int getRoomNo() {
      return RoomNo;
   }

   public void setFloor(int Floor) {
      this.Floor = Floor;
   }

   public int getFloor() {
      return Floor;
   }

   public void setCapacity(int Capacity) {
      this.Floor = Floor;
   }

   public int getCapacity() {
      return Capacity;
   }

   public void setStatus(String Status) {
      this.Status = Status;
   }

   public String getStatus() {
      return Status;
   }

   public String toString() {
      return "Room Number : " + this.RoomNo + " Floor : " + this.Floor +
            " Capacity : " + this.Capacity + " Status: " + this.Status;
   }
}
