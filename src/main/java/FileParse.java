import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * class to handle writing into the txt file and reading from txt file
 */
public class FileParse {
    private String f_path = System.getProperty("user.dir");
    private DateTimeParser dt_parser = new DateTimeParser();
    private String filePath = "src/main/Data/duke.txt";
    /*
     * function to write to txt file
     * @param list: to do list of duke
     */
    public void save_file(ArrayList<Request> list) throws DukeException {
        File f = new File(filePath);
        try {
            FileWriter fileWriter = new FileWriter(f);
            for (Request t: list) {
                String line = null;
                if (t instanceof Deadline) {
                    line = ((Deadline)t).file_format();
                } else if (t instanceof Event) {
                    line = ((Event)t).file_format();
                } else if (t instanceof ToDo) {
                    line = ((ToDo)t).file_format();
                }
                fileWriter.write(line + "\n");
            }
            fileWriter.close();
        } catch (Exception e) {
            throw new DukeException("File error is: " + e.getMessage());
        }
    }
    /*
     * function to read a line of the txt file
     * @param list: to do list of duke
     * @param schedule: class to handle updating operations of the list
     */
    public void line_parse(Task schedule, String line) throws DukeException{
         String[] token = line.split("\\|");
         try {
             String type = token[0].strip();
             String status = token[1].strip();
             String description = token[2].strip();
             ArrayList<Request> to_do = schedule.retrieve_list();
             if (type.equals("D")) {
                 try {
                     to_do.add(new Deadline(description, dt_parser.parseStringToDate(token[3].strip())));
                 } catch (DukeException e) {
                     to_do.add(new Deadline(description, token[3].strip()));
                 }
             } else if (type.equals("E")) {
                 try {
                     to_do.add(new Event(description, dt_parser.parseStringToDate(token[3].strip())));
                 } catch (DukeException e) {
                     to_do.add(new Event(description, token[3].strip()));
                 }
             } else if (type.equals("T")) {
                 to_do.add(new ToDo(description));
             }
             if (status.equals("1")) to_do.get(to_do.size() - 1).markAsDone();
         } catch(Exception e) {
             throw new DukeException (e.getMessage());
         }
    }
    /*
     * function to load the txt file information onto the to_do list
     * @param schedule: class to handle the update operations of duke
     */
    public void load_file(Task schedule) throws DukeException {
        try {
            File f = new File(filePath);
            Scanner fileReader = new Scanner(f);
            while (fileReader.hasNext()) line_parse(schedule, fileReader.nextLine());
        } catch (Exception e) {
            throw new DukeException(e.getMessage());
        }
    }
}
