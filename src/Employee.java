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
    public void setHourlySalary(double hourlySalary) {
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
    public void setHours(double hours) {
        this.hours = hours;
    }

    /**
     * Default constructor
     */
    public Employee() {
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
    public Employee(String name, int age, double hourlySalary, double hours) {
        super(name, age);
        this.hourlySalary = hourlySalary;
        this.hours = hours;
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
}
