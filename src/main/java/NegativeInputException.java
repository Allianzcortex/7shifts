public class NegativeInputException extends Exception {

    public NegativeInputException(String message) {
        super(message);
    }

    public NegativeInputException(int num, String message) {
        super(String.format("There is/are %d negative number(s) in the input : %s", num, message));
    }
}
