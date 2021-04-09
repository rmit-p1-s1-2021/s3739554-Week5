package main;

import java.io.PrintStream; 

import timetable.Activity;
import timetable.Student;
import timetable.TimetableSystem;

public class Program
{
    public static void main(String[] args)
    {
        new Program().run();
    }
    
    private final TimetableSystem timetableSystem = new TimetableSystem();
    
    private void run()
    {
        displayActivities();
        displayStudents();
        displayActivitiesAndStudents();
        
        addStudentToActivity(0, "s9999999");
        addStudentToActivity(1, "s9999999");
        addStudentToActivity(1, "s1234567");
        addStudentToActivity(3, "s1234567");
        addStudentToActivity(1, "s3456789");
        System.out.println();
        
        displayActivitiesAndStudents();
        
        System.out.println("Program ending.");
    }
    
    private void displayActivities()
    {
        System.out.println("--- Activities ---");
        for(Activity activity : timetableSystem.getActivities())
        {
            System.out.printf("\t%s\n", activity.toString());
        }
        System.out.println();
    }
    
    private void displayStudents()
    {
        System.out.println("--- Students ---");
        for(Student student : timetableSystem.getStudents())
        {
            System.out.printf("\t%s\n", student.toString());
        }
        System.out.println();
    }
    
    private void displayActivitiesAndStudents()
    {
        System.out.println("--- Activities and Students ---");
        for(Activity activity : timetableSystem.getActivities())
        {
            System.out.printf("\t%s\n", activity.toString());
            
            int studentCount = activity.getStudentCount();
            
            if(studentCount == 0)
            {
                System.out.println("\t\tNo students attending");
                continue;
            }
            
            Student[] students = activity.getStudents();
            for(int i = 0; i < studentCount; i++)
            {
                System.out.printf("\t\t%s\n", students[i].toString());
            }
        }
        System.out.println();
    }
    
    private void addStudentToActivity(int id, String studentID)
    {
        // Lookup activity.
        System.out.printf("Looking up activity id %d... ", id);
        Activity activity = timetableSystem.getActivity(id);
        if(activity == null)
        {
            printErrorMessage("Activity not found.");
            return;
        }
        System.out.print("done. ");

        // Lookup student.
        System.out.printf("Looking up student id %s... ", studentID);
        Student student = timetableSystem.getStudent(studentID);
        if(student == null)
        {
            printErrorMessage("Student not found.");
            return;
        }
        System.out.print("done. ");
        
        // Attempt to add student to activity.
        boolean success = activity.addStudent(student);
        if(success)
            System.out.println("Student successfully added to activity.");
        else
            printErrorMessage("Student already attending activity.");
    }
    
    private static void printErrorMessage(String message)
    {
        flushAndSleep(System.out);
        System.err.println(message);
        flushAndSleep(System.err);
    }
    
    private static void flushAndSleep(PrintStream stream)
    {
        // 50ms sleep.
        final int DEFAULT_SLEEP = 50;
        
        // The flush and sleep below is only present to help the Eclipse console
        // on Windows to output System.out and System.err streams in the
        // expected order.
        stream.flush();
        try
        {
            Thread.sleep(DEFAULT_SLEEP);
        }
        catch(InterruptedException e)
        { }
    }
}
