import java.time.LocalDateTime;
/*
 *Inherited class to store information representing an event task
 */
public class Event extends Request {
    private LocalDateTime dtime;
    private String dt_string;
    /*
     * Constructor of Deadline class
     * @param description: information about the task
     * @param dtime: local date time java type to get realtime date and time
     */
    public Event(String description, LocalDateTime dtime) {
        super(description);
        this.dtime = dtime;
    }
    /*
     * Constructor of Deadline class
     * @param description: information about the task
     * @param dt_string: string type containing info about the date and time of the task
     */
    public Event(String description, String dt_string) {
        super(description);
        this.dt_string = dt_string;
    }
    /*
     * function to print the task on the command line to the user
     */
    @Override
    public String print_req() {
        return "[E]" + result() + " " + getName() + " (at: " + (dtime == null ? dt_string: dtime.toString()) + ")";
    }
    /*
     * function to format the string to be output onto a txt file
     */
    @Override
    public String file_format() {
        return "E | " + index() + " | " + getName() + " | " + (dtime == null ? dt_string: dtime.toString());
    }
}
