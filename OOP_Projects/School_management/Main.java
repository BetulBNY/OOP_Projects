/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package school_management;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author betus
 */
public class Main {
    public static void main(String[] args){
        Teacher hasan = new Teacher(1,"Hasan",700);
        Teacher meltem = new Teacher(2, "Meltem", 900);
        Teacher sena = new Teacher(3,"Sena", 600);
        
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(hasan);
        teacherList.add(sena);
        teacherList.add(meltem);
        
        Student mehmet = new Student(1, "Mehmet", 3);
        Student dilara = new Student(2, "Dilara", 1);
        Student behlul = new Student(3, "Behlul",9);
        
        List<Student> studentList = new ArrayList<>();
        studentList.add(behlul);
        studentList.add(mehmet);
        studentList.add(dilara);
        
       School iaus = new School(teacherList, studentList);     // School object is created  
      
       behlul.payFees(5000);  // but it will not change if getTotalMoneyEarned()/update method is not static.
       System.out.println("IAUS has earned $ " + iaus.getTotalMoneyEarned());
       
       mehmet.payFees(8000);
       System.out.println("IAUS has earned $ " + iaus.getTotalMoneyEarned());
       
       // IAUS will pay teacher's salary.
        System.out.println("------------ MAKING SCHOOL PAY SALARY------------");
        hasan.receiveSalary(hasan.getSalary());
        System.out.println("School has spent for salary to "+ hasan.getName()+ " and now has $"+ iaus.getTotalMoneyEarned() );
        
        meltem.receiveSalary(meltem.getSalary());
        System.out.println("School has spent for salary to "+ meltem.getName()+ " and now has $"+ iaus.getTotalMoneyEarned() );
        
        
        System.out.println(mehmet);
        System.out.println(meltem);
        System.out.println(sena);  // 0, because we didn't pay anything.
    }
}
