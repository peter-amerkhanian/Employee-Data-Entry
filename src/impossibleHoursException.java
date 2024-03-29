/**
 * Exception class for catching the use of values
 * that are greater than the number of hours in a week
 */
public class impossibleHoursException extends Exception {
    public impossibleHoursException() {
        super("There are only 168 hours in a week, please enter a number <= 168");
    }

    public impossibleHoursException(double input) {
        super(String.format("You entered %s hours. There are only 168 hours in a week", input));
    }
}
