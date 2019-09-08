import java.util.Scanner;
/*
 * class to read in the user input
 */
public class Ui {
    /*
     * function to read in the user input
     */
    public String readCommand() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
