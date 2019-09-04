import java.util.Scanner;

public class Duke {
    public static void main(String[] args) throws Exception {
        Task schedule = new Task();
        Ui ui = new Ui();
        FileParse fileManager = new FileParse();
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello I'm Duke!\nWhat can I do for you?");
        fileManager.load_file(schedule);
        while (true) { //keep checking until we encounter the "bye" command
            String command = ui.readCommand();
            Parser parser = new Parser(command);
            parser.parseCommand(schedule);
            if (parser.isExit()) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }
        }
    }
}
