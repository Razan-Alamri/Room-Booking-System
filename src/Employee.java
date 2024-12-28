/*
 
*/
public class Employee {
   int EmpID;
   String FisrtName;
   String LastName;
   int BirthYear;
   int EmploymentYear;
   String Department;

   public Employee(int EmpID, String FisrtName, String LastName, int BirthYear, int EmploymentYear, String Department) {
      this.EmpID = EmpID;
      this.FisrtName = FisrtName;
      this.LastName = LastName;
      this.BirthYear = BirthYear;
      this.EmploymentYear = EmploymentYear;
      this.Department = Department;
   }

   public void setEmpID(int EmpID) {
      this.EmpID = EmpID;
   }

   public int getEmpID() {
      return EmpID;
   }

   public void setFisrtName(String FisrtName) {
      this.FisrtName = FisrtName;
   }

   public String getFisrtName() {
      return FisrtName;
   }

   public void setLastName(String LastName) {
      this.LastName = LastName;
   }

   public String getLastName() {
      return LastName;
   }

   public void setBirthYear(int BirthYear) {
      this.BirthYear = BirthYear;
   }

   public int getBirthYear() {
      return BirthYear;
   }

   public void setEmploymentYear(int EmploymentYear) {
      this.EmploymentYear = EmploymentYear;
   }

   public int getEmploymentYear() {
      return EmploymentYear;
   }

   public void setDepartment(String Department) {
      this.Department = Department;
   }

   public String getDepartment() {
      return Department;
   }

   @Override
   public String toString() {
      return " Employee ID : " + this.EmpID + " Name : " + this.FisrtName + " " + this.LastName + " Employment Year : "
            + this.EmploymentYear +
            " Department : " + this.Department;
   }
}
