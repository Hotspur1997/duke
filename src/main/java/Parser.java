public class Parser {
    private String command;
    private DateTimeParser dt_parser = new DateTimeParser();
    public Parser(String command) {
        this.command = command;
    }
    public String Type() {
        String[] token = command.split(" ");
       return token[0];
    }
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
    public ToDo createToDo() throws DukeException {
        String token = command.substring("todo".length()).strip();
        if (token.strip().isEmpty()) {
            throw new DukeException(" ☹ OOPS!!! The description of a todo cannot be empty.");
        }
        return new ToDo(token);
    }
}
