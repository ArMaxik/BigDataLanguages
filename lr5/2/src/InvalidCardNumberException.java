public class InvalidCardNumberException extends Exception {
    public InvalidCardNumberException(String card) {
        super(card);
    }
}
