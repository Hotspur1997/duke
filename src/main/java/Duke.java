import java.util.Scanner;

/*
 * main class of duke
 */
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
            String command = ui.readCommand(); //read the command of the user input
            Parser parser = new Parser(command); //create a new parser class for the command
            parser.parseCommand(schedule); //handle the command accordingly
            if (parser.isExit()) { //check if bye has been entered into the input
                System.out.println("Bye. Hope to see you again soon!");
                break; //exit the program
            }
        }
    }
}
