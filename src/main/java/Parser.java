/*
 * class to handle the command of the user
 */
public class Parser {
    private String command;
    private boolean isExit;
    private DateTimeParser dt_parser = new DateTimeParser();
    /*
     * constructor of the parser
     * @param command: type of command to handle
     */
    public Parser(String command) {
        this.command = command;
        isExit = false;
    }
     /*
      * function to handle the command
      * @param schedule: class to handle the various commands in duke
      */
    public void parseCommand(Task schedule) {
        String[] token = command.split(" ");
        String action = token[0];
        try {
            switch(action) {
                case "done":
                    schedule.update_list(token[1]);
                    break;
                case "list":
                    schedule.print_list();
                    break;
                case "bye":
                    isExit = true;
                    break;
                case "todo":
                    schedule.add(createToDo());
                    break;
                case "event":
                    schedule.add(createEvent());
                    break;
                case "deadline":
                    schedule.add(createDeadline());
                    break;
                case "find":
                    schedule.find(command);
                    break;
                case "delete":
                    schedule.remove_item(command);
                    break;
                default:
                    throw new DukeException ("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
        } catch(DukeException e) {
                System.err.println(e.getMessage());
        }
    }
    /*
     * check if the 'bye' command has been entered
     */
    public boolean isExit() {
        return isExit;
    }
    /*
     * creates a deadline class
     */
    public Deadline createDeadline() throws DukeException{
        String[] token = command.substring("deadline".length()).strip().split("/by");
        if (token.length != 2 || token[1] == null) {
            throw new DukeException(" ☹ OOPS!!! The description of a deadline cannot be empty.");
        }
        if (token[0].strip().isEmpty()) {
            throw new DukeException(" ☹ OOPS!!!  The deadline description must be formatted correctly.");
        }
        try {
            return new Deadline(token[0].strip(), dt_parser.parseStringToDate(token[1].strip()));
        } catch (DukeException e) {
            return new Deadline(token[0].strip(),token[1].strip());
        }
    }
    /*
     * creates an event class
     */
    public Event createEvent() throws DukeException {
        String[] token = command.substring("event".length()).strip().split("/at");
        if (token.length != 2 || token[1] == null) {
            throw new DukeException(" ☹ OOPS!!! The description of an event cannot be empty.");
        }
        if (token[0].strip().isEmpty()) {
            throw new DukeException(" ☹ OOPS!!!  The deadline description must be formatted correctly.");
        }
        try {
            return new Event(token[0].strip(), dt_parser.parseStringToDate(token[1].strip()));
        } catch (DukeException e) {
            return new Event(token[0].strip(),token[1].strip());
        }
    }
    /*
     * creates a to do class
     */
    public ToDo createToDo() throws DukeException {
        String token = command.substring("todo".length()).strip();
        if (token.strip().isEmpty()) {
            throw new DukeException(" ☹ OOPS!!! The description of a todo cannot be empty.");
        }
        return new ToDo(token);
    }
}
