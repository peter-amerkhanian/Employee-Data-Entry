import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Driver {
    public static void main(String[] args) {
        int number = (int) (numberInput("How many employees are there? "));
        ArrayList employees = new ArrayList();
        for (int i = 0; i < number; i++) {
            while (true) {
                Scanner scanName = new Scanner(System.in);
                System.out.printf("\nEmployee %s name: ", i + 1);
                String name = scanName.nextLine();
                double hourlyWage = numberInput(String.format("Employee %s hourly wage: ", i + 1));
                double hours = numberInput(String.format("Employee %s hours: ", i + 1));
                try {
                    Employee employee = new Employee(name, 0, hourlyWage, hours);
                    employees.add(employee);
                    System.out.printf("Employee %s saved.\n", i + 1);
                    break;
                } catch (impossibleHoursException | negativeNumberException e) {
                    System.out.println("Error " + e.getMessage() + ". Please re-enter the employee info.");
                }
            }
        }
        System.out.println("All employees successfully entered!\n");
        Employee.printSalaryReport(employees);
    }

    public static double numberInput(String message) {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.printf(message);
            try {
                return in.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Error: please enter a number in digits form");
            }
        }
    }

}