import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
//        Scanner scanNumber = new Scanner(System.in);
//        System.out.print("How many employees are there? ");
//        int number = scanNumber.nextInt();
//        ArrayList employees = new ArrayList();
//        for (int i=0; i < number; i++) {
//            Scanner scanName = new Scanner(System.in);
//            System.out.printf("\nEmployee %s name: ", i+1);
//            String name = scanName.nextLine();
//            Scanner scanAge = new Scanner(System.in);
//            System.out.printf("Employee %s age: ", i+1);
//            int age = scanAge.nextInt();
//            Scanner scanHourlyWage = new Scanner(System.in);
//            System.out.printf("Employee %s hourly wage: ", i+1);
//            double hourlyWage = scanHourlyWage.nextDouble();
//            Scanner scanHours = new Scanner(System.in);
//            System.out.printf("Employee %s hours: ", i+1);
//            double hours = scanHours.nextDouble();
//            System.out.printf("Employee %s saved.\n", i+1);
//            Employee employee = new Employee(name, age, hourlyWage, hours);
//            employees.add(employee);
//        }
//        System.out.println(employees.toString());
        JFrame windows = new FirstSwingWindow();
        windows.setVisible(true);


    }
}
