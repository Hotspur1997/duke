import java.util.Scanner;

public class Duke {
    public static void main(String[] args) throws DukeException {
        Task schedule = new Task();

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello I'm Duke!\nWhat can I do for you?");
        while (true) { //keep checking until we encounter the "bye" command
            Scanner input = new Scanner(System.in);
            String command = input.nextLine();
            if (!command.equals("bye")) {
                if (command.equals("list")) {
                    schedule.print_list();
                } else {
                    String[] token = command.split(" "); //consider the "done 2" case
                    if (token[0].equals("done")) {
                        schedule.update_list(token[1]);
                    } else {
                        Parser parser = new Parser(command);
                        String result = parser.Type();
                        switch(result) {
                            case "todo":
                                schedule.add(parser.createToDo());
                                break;
                            case "event":
                                schedule.add(parser.createEvent());
                                break;
                            case "deadline":
                                schedule.add(parser.createDeadline());
                                break;
                            default:
                                throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");

                        }
                    }
                }
            } else {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }
        }
    }
}
