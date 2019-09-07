/**
 * Swing Driver Class:
 * Ask the user how many employees are there.
 * For each employee, prompt the user to enter the employees name, hourly salary, and hours worked.
 * Prints out input in csv form, exports to 'employees.csv'
 */
public class SwingDriver {
    public static void main(String[] args) {
        EmployeeSwing swingApp = new EmployeeSwing();
        swingApp.setVisible(true);
    }
}
