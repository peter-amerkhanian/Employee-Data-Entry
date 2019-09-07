import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Text-input Driver Class:
 * Ask the user how many employees are there.
 * For each employee, prompt the user to enter the employees name, hourly salary, and hours worked.
 * Prints out input in csv form, exports to 'employees.csv'
 */
public class Driver {
    public static void main(String[] args) {
        int numberOfEmployees = (int) (numberInput("How many employees are there? "));
        ArrayList employees = new ArrayList();
        for (int i = 1; i <= numberOfEmployees; i++) {
            while (true) {
                Scanner scanName = new Scanner(System.in);
                System.out.printf("\nEmployee %s name: ", i);
                String name = scanName.nextLine();
                double hourlyWage = numberInput(String.format("Employee %s hourly wage: ", i));
                double hours = numberInput(String.format("Employee %s hours: ", i));
                try {
                    Employee employee = new Employee(name, 0, hourlyWage, hours);
                    employees.add(employee);
                    System.out.printf("Employee %s saved.\n", i);
                    break;
                } catch (impossibleHoursException | negativeNumberException e) {
                    System.out.println("Error: " + e.getMessage() + ". Please re-enter the employee info.");
                }
            }
        }
        System.out.println("All employees successfully entered!\n");
        Employee.printSalaryReport(employees);
    }

    /**
     * A Helper method for retrieving user input and verifying
     * that the input is a number
     *
     * @param message the prompt the user will receive
     * @return the number that the user entered
     */
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