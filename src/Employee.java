import java.io.FileWriter;
import java.util.ArrayList;

/**
 * A subclass of Person that represents an Employee
 */
public class Employee extends Person {
    private double hourlySalary;
    private double hours;

    /**
     * Getter method for hourlySalary
     *
     * @return employee's hourly salary
     */
    public double getHourlySalary() {
        return hourlySalary;
    }

    /**
     * Setter method for hourlySalary
     *
     * @param hourlySalary the employee's new hourly salary
     */
    public void setHourlySalary(double hourlySalary) throws negativeNumberException {
        if (hourlySalary < 0) {
            throw new negativeNumberException(hourlySalary);
        }
        this.hourlySalary = hourlySalary;
    }

    /**
     * Getter method for hours
     *
     * @return the number of hours worked for the employee
     */
    public double getHours() {
        return hours;
    }

    /**
     * Setter method for hours
     *
     * @param hours the new number of hours worked for the employee
     */
    public void setHours(double hours) throws impossibleHoursException, negativeNumberException {
        if (hours > 168) {
            throw new impossibleHoursException(hours);
        } else if (hours < 0) {
            throw new negativeNumberException(hours);
        } else {
            this.hours = hours;
        }
    }

    /**
     * Default constructor
     */
    public Employee() throws impossibleHoursException, negativeNumberException {
        this("N/A", 0, 0, 0);
    }

    /**
     * Parameterized constructor
     *
     * @param name         employee's name
     * @param age          employee's age
     * @param hourlySalary employee's hourly salary
     * @param hours        number of hours employee worked
     */
    public Employee(String name, int age, double hourlySalary, double hours)
            throws impossibleHoursException, negativeNumberException {
        super(name, age);
        this.setHourlySalary(hourlySalary);
        this.setHours(hours);
    }

    /**
     * toString method
     *
     * @return string representation of the employee
     */
    @Override
    public String toString() {
        return "{name=" + this.getName() +
                ", age=" + this.getAge() +
                ", hourlySalary=" + this.getHourlySalary() +
                ", hours=" + this.getHours()
                + "}";
    }

    /**
     * equals method
     *
     * @param o the object to be compared to
     * @return true if equal, else false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.getHourlySalary(), this.getHourlySalary()) == 0 &&
                Double.compare(employee.getHours(), this.getHours()) == 0;
    }

    /**
     * Takes an ArrayList of Employee objects,
     * calculates weekly pay for each employee,
     * prints Employee Name, Salary, Hours, Weekly Payfor each employee,
     * saves that to employee.csv
     *
     * @param employees an Arraylist of Employee objects
     */
    public static void printSalaryReport(ArrayList<Employee> employees) {
        StringBuilder report = new StringBuilder("Employee Name, Salary, Hours, Weekly Pay\n");
        System.out.print(report);
        for (Employee employee : employees) {
            Double weeklyPay = employee.getHourlySalary() * employee.getHours();
            String s = "%s, %s, %s, %s\n";
            String row = String.format(
                    s, employee.getName(), employee.getHourlySalary(), employee.getHours(), weeklyPay);
            System.out.print(row);
            report.append(row);
        }
        try {
            FileWriter fw = new FileWriter("employee.csv");
            fw.write(report.toString());
            fw.close();
        } catch (Exception e) {
            System.out.println("Error. File could not be written" + e.getMessage());
        }
        System.out.println("employee.csv successfully created!");
    }
}
