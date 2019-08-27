public class Parser {
    String command;
    public Parser(String command) {
        this.command = command;
    }
    public String Type() {
        String[] token = command.split(" ");
       return token[0];
    }
    public Deadline createDeadline() {
        String[] token = command.substring("deadline".length()).strip().split("/by");
        return new Deadline(token[0].strip(), token[1].strip());
    }
    public Event createEvent() {
        String[] token = command.substring("event".length()).strip().split("/at");
        return new Event(token[0].strip(), token[1].strip());
    }
    public ToDo createToDo() {
        String token = command.substring("todo".length()).strip();
        return new ToDo(token);
    }
}
