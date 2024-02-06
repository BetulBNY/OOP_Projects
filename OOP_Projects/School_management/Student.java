/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package school_management;

/**
 * @author betus
 * This class is responsible for keeping the track
 * of students fees, name, grade & fees paid.
 */
public class Student {
    private int id;  // We want to protect somebody from accessing this ID outside the student class.
    private String name;
    private int grade;
    private int feesPaid;
    private int feesTotal;
    
    
    /*
    * Fees for wvery student is $30,000.
    * Fees paid initially is 0. 
    */
    
       
    
    // How should new student object look like
    // Constructer is an answer of when we create student object what should be required?
    // To create new Student object by initializing.
    public Student(int id, String name, int grade){
     // Initializing all the values
        feesPaid = 0; // Why we didn't use "this"? - Because feesPaid in not passed as an argument, so there is no possibility for an conflict.
                      // But if we want we can use. For others if we don't use there will be a conflict between argument and class.       
        this.feesTotal = 30000;              
        this.id = id;  // Id from the student class that is equal the Id from the argument.
        this.name = name; 
        this.grade = grade;
    }
    
    // Not going to alter student's name, feesTotal and ID. (not change) So for it Setname method is not required.
    // Students grade is going to alter.
    
    // Setters always should be void and Getters should be return data type.
    
    public void setGrade(int grade){
        // Used to update student's grade.
        // Parameter grade is new grade of the student.
        this.grade = grade; // The grade of the particular student to the grade that is coming from the argument.        
    }
    
    public void payFees(int fees){
       // Used to update fees.   
       // Add the fees to the fees paid. The school is going to receive the funds.
       // feespaid = 10,000 + 5,000 + 15,000, So update method should keep adding the fees. Receive the ffes and kee adding it to the fees field.
       // Keep adding the fees to feesPaid Field.
       // Parameter fees is the student pays.
       feesPaid += fees;
       School.updateTotalMoneyEarned(feesPaid);  // If I want to access method like this the I have to declare it static.
    }

    // Until here we just set the values never got the values.
    // We will get them:
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public int getGrade() {        // Grade is class.
        return grade;
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public int getFeesTotal() {
        return feesTotal;
    }
    
    public int getRemeaningFees(){
        return feesTotal - feesPaid;
    }
    
    // Override
    public String toString(){
        return "Student's name: " + name +
                " Total fees paid so far $ "+ feesPaid;
    }
    // Before override when we write System.out.println(mehmet) it gave different thing(memory location of the object).    
    
}
