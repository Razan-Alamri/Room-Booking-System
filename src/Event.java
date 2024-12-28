
import java.util.Date;
/*
Final Lab Exam
Student Name:Razan
Student ID:xxx
Section:IAR
Lab Instructor:Nojoud Alshehri
*/
public class Event {
    String EventName;
    String Type;
    Date EventDate;
    Double startingTime;
    Double endingTime;
    int AttendeesNo;
    
    public Event(String EventName,String Type,Date EventDate,Double startingTime, Double endingTime,int AttendeesNo){
        this.EventName = EventName;
        this.Type = Type;
        this.EventDate = EventDate;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.AttendeesNo = AttendeesNo;
    }
    public void setEventName(String EventName){
       this.EventName = EventName;
    }
     public String getEventName(){
       return EventName; 
    }
    public void setType(String Type){
       this.Type = Type;
    }
     public String getType(){
       return Type; 
    } 
     public void setEventDate(  Date EventDate){
       this.EventDate = EventDate;
    }
     public Date getEventDate(){
       return EventDate; 
    }
     public void setstartingTime(double startingTime){
       this.startingTime = startingTime;
    }
     public double getstartingTime(){
       return startingTime; 
    }
     public void setendingTime(double endingTime){
       this.endingTime = endingTime;
    }
     public double getendingTime(){
       return endingTime; 
    }
     public void setAttendeesNo(int AttendeesNo){
       this.AttendeesNo = AttendeesNo;
    }
     public int getAttendeesNo(){
       return AttendeesNo; 
    }
    @Override
    public String toString(){
        return " Event Name: "+this.EventName+" Event Type : "+this.Type+" Event Date: "+this.getEventDate().toString()+
                " Start Time : "+this.startingTime.toString().replace(".",":")+" End Time : "+this.endingTime.toString().replace(".",":")+
                " Attendees Number : "+this.AttendeesNo;
    }
}
