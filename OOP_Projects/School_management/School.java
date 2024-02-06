/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package school_management;

import java.util.List;

/**
 * Schools basically has multiple teachers and students.
 * Implements teachers and students using an ArrayList.
 * @author betus
 */
public class School {
    private List<Teacher> teachers;
    private List<Student> students;
    private static int totalMoneyEarned;
    private static int totalMoneySpent;
    // Purpose of the Static: With static we can access the method otherwise we have to have an instance of the method.
    
    
    public School(List<Teacher> teachers, List<Student> students){
        this.teachers = teachers;      // List of teachers.
        this.students = students;      // List of students.
        totalMoneyEarned = 0;
        totalMoneySpent = 0;
    }
    
    // We will create getter and setter for everything. Because when we create school we can alter teachers, we can add students, alter money earned and spent.

    
    public List<Teacher> getTeachers() {
        return teachers;  // Return the list of teachers in the school.
    }

    // We don't use set teacher because once we set teacher, it's over.
    public void addTeacher(Teacher teacher) {
        // Adds a teacher to the school. (We will add new teachers to teacxhers list)
        teachers.add(teacher);
    }

    public List<Student> getStudents() {
        return students;  // Return the list of students in the school.
    }

    public void addStudents(Student student) {
        students.add(student);
    }

    public int getTotalMoneyEarned() {
        return totalMoneyEarned;  // Return the total money earned by the school.
    }

    public static void updateTotalMoneyEarned(int MoneyEarned) {  // Adds the total money earned by the school.
        // Parameter MoneyEarned, money that is supposed to be added.
        totalMoneyEarned += MoneyEarned;
    }

    public int getTotalMoneySpent() {
        return totalMoneySpent;  // Return the total money spent by the school.
    }

    public static void updateTotalMoneySpent(int moneySpent) {
        // Update the money that is spent by the school which is the salary given by the schooll to its teachers.
        // Parameter MoneySpent the money spent by school.
        totalMoneyEarned = totalMoneyEarned - moneySpent;
    }
    
 
    
    
    
}
