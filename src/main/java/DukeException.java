/*
 * class to handle exceptions in duke
 */
public class DukeException extends Exception {
    /*
     * constructor for a duke exception
     * @param message: message to tell the user when he encounters an error
     */
    public DukeException(String message) {
        super(message);
    }
}
