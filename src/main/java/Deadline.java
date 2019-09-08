import java.time.LocalDateTime;

/*
*Inherited class to store information representing a deadline task
*/
public class Deadline extends Request {
    private LocalDateTime ddate;
    private String localDate;
    /*
     * Constructor of Deadline class
     * @param description: information about the task
     * @param ddate: local date time java type to get realtime date and time
     */
    public Deadline(String description, LocalDateTime ddate) {
        super(description);
        this.ddate = ddate;
    }
    /*
     * Constructor of Deadline class
     * @param description: information about the task
     * @param localDate: string type containing info about the date and time of the task
     */
    public Deadline(String description, String localDate) {
        super(description);
        this.localDate = localDate;
    }
    /*
     * function to print the task on the command line to the user
     */
    @Override
    public String print_req() {
        return "[D]" + result() + " " + getName() + " (by: " + (ddate == null ? localDate : ddate.toString()) + ")";
    }
    /*
     * function to format the string to be output onto a txt file
     */
    @Override
    public String file_format() {
        return "D | " + index() + " | " + getName() + " | " + (ddate == null ? localDate : ddate.toString());
    }
}
