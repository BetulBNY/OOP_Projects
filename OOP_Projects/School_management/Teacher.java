/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package school_management;

/**
 * This class is responsible for keeping the track
 * of teachers name, id, salary.
 * @author betus
 */
public class Teacher {
   private int id;
   private String name;
   private int salary;
   private int salaryEarned;
   
   // Salary amount is depends on teacher's seniority.
   public Teacher(int id, String name, int salary){
       // Creates a new Tacher object.
      this.id = id;
      this.name = name; 
      this.salary = salary;
      this.salaryEarned = 0;
   }
   
   public int getId(){
       return id;
   }
   public String getName(){
       return this.name;
   }   
   
   public int getSalary(){
       return salary;
   }
   
   public void setSalary(int salary){
       this.salary = salary;   // set the salary.
   }
   
   public void receiveSalary(int salary){
       // Adds to salaryEarned, and removes from the total money earned by the school.
       salaryEarned += salary;
       School.updateTotalMoneySpent(salary);
   }
   
       // Override
    public String toString(){
        return "Teacher's name: " + name +
                " Total salary earned so far $ "+ salaryEarned;
    }
}
