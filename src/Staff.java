/*
 
*/
public class Staff extends Employee {
    String Postion;

    /*----------------------------------------------------------------------
    Q1: Define and implement the Constructor that:
        1- Call SuberClass constructor with appropriate argument
        2- Assign Postion parameter to Postion attribute
    ------------------------------------------------------------------------*/
    public Staff(int EmpID, String FisrtName, String LastName, int BirthYear, int EmploymentYear, String Department,
            String Position) {
        super(EmpID, FisrtName, LastName, BirthYear, EmploymentYear, Department);
        this.Postion = Position;
    }

    public void setPostion(String Postion) {
        this.Postion = Postion;
    }

    public String getPostion() {
        return Postion;
    }

    public String toString() {
        return super.toString() + " Postion : " + this.Postion;
    }
}
