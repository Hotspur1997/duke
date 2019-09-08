/*
 *Inherited class to store information representing a to do task
 */
public class ToDo extends Request {
    /*
     * Constructor of to do class
     * @param description: information about the task
     */
    public ToDo(String description) {
        super(description);
    }
    /*
     * prints the to do task on the CLI
     */
    @Override
    public String print_req() {
        return "[T]" + result() + " " + getName();
    }
    /*
     * prints the task in a file format
     */
    @Override
    public String file_format() {
        return "T | " + index() + " | " + getName();
    }
}
