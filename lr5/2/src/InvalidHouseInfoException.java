public class InvalidHouseInfoException extends Exception {
    public InvalidHouseInfoException(String field, String value) {
        super(field + ": " + value);
    }
}
