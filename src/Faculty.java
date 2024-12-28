/*
Final Lab Exam
Student Name:Razan
Student ID:xxxx
Section:IAR
Lab Instructor:Nojoud Alshehri
*/
public class Faculty extends Employee{
    String Degree;
   
    public Faculty(int EmpID,String FisrtName,String LastName, int BirthYear, int EmploymentYear, String Department,String Degree){
        super(EmpID,FisrtName,LastName,BirthYear,EmploymentYear,Department);
        this.Degree = Degree;
    }
    public void setDegree(String Degree){
       this.Degree = Degree;
    }
     public String getDegree(){
       return Degree; 
    }
    public String toString(){
        return super.toString()+" Degree : "+this.Degree;
    }
    
}
