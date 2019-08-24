import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Task schedule = new Task();
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello I'm Duke\nWhat can I do for you?");
        while (true) { //keep checking until we encounter the "bye" command
            Scanner input = new Scanner(System.in);
            String command = input.nextLine();
            if (!command.equals("bye")) {
                if (!command.equals("list")) {
                    schedule.add(command);
                    System.out.println("added: " + command);
                } else schedule.print_list();
            } else {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }
        }
    }
}
