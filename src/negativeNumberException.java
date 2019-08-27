public class negativeNumberException extends Exception {
    public negativeNumberException() {
        super("Values cannot be negative");
    }
    public negativeNumberException(double input) {
        super(String.format("%s is invalid input. Values cannot be negative", input));
    }
}
