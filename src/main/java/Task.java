import java.util.ArrayList;

/*
 * superclass for all tasks in the list
 */
class Request {
    private String name;
    private boolean completed;

    /*
     * constructor for the request class
     * @param name: description of the string
     */
    public Request(String name) {
        this.name = name;
        this.completed = false;
    }
    /*
     * marks the particular task as completed
     */
    public void markAsDone() {
        completed = true;
    }

    /*
     * checks if the task is completed and returns the relevant symbol
     */
    public String result() {
        return (completed ? "[✓]" : "[✗]");
    }
    /*
     * return the description of the task
     */
    public String getName() {
        return name;
    }
    /*
     * prints the task on the command line
     */
    public String print_req() {
        return result() + " " + name;
    }
    /*
     * returns an integer depending on wether the task is complete
     */
    public int index() {
        return (completed ? 1 : 0);
    }
    /*
     * return a string denoting the format of the task in the txt file
     */
    public String file_format() {
        return "";
    }
}

/*
 * class to control the entire to-do list
 */
class Task {
    private ArrayList<Request> to_do;
    FileParse fp;
    public Task() {
        to_do = new ArrayList<>();
        fp = new FileParse();
    }

    /*
     * adds item inside to-do list
     * @param d: a task to be added into the list
     */
    public void add(Request d) {
        to_do.add(d);
        System.out.println("Got it. I've added this task: ");
        System.out.println(d.print_req());
        System.out.println("Now you have " + to_do.size() + " tasks in the list.");
        try {
            fp.save_file(to_do);
        } catch (Exception e) {
           System.err.println("File error is: " + e.getMessage());
        }
    }

    /*
     * marks the queried item as done
     * @param request: index of the task to mark as done
     */
    public void update_list(String request) {
        int index = Integer.parseInt(request);
        index--;
        try {
            to_do.get(index).markAsDone();
            System.out.println("Nice! I've marked this task as done");
            System.out.println("[✓] " + to_do.get(index).getName());
            fp.save_file(to_do);
        } catch (IndexOutOfBoundsException e) {
           System.err.println("There are not that many tasks in the list please try again");
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }
    /*
     * removes the item from the list
     * @param req: the index of the task to remove
     */
    public void remove_item(String req) {
        try {
            String[] token = req.split(" ");
            int index = Integer.parseInt(token[1]);
            index--;
            System.out.println("Noted. I've removed this task:");
            System.out.println(to_do.get(index).print_req());
            to_do.remove(index);
            System.out.println("Now you have " + to_do.size() + " tasks in the list.");
            fp.save_file(to_do);
        } catch(IndexOutOfBoundsException e) {
            System.err.println("The list is not that large, please try again");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /*
     *prints the entire list
     */
    public void print_list() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < to_do.size(); i++) {
            System.out.println((i + 1) + "." + to_do.get(i).print_req());
        }
    }
    /*
     * return the size of the list
     */
     public int size() {
         return to_do.size();
     }
    /*
     * return the entire to_do list
     */
    public ArrayList<Request> retrieve_list() {
        return to_do;
    }
    /*
     * finds an item with a specific keyword in the list
     * @param command: string containing the keyword to be found
     */
    public void find(String command) throws DukeException {
        String[] token = command.split(" ");
        if (token.length != 2 || token[1] == null) {
            throw new DukeException ("find cannot be empty");
        }
        String query = token[1];
        int index = 1;
        System.out.println("Here are the matching tasks in your list:");
        for (Request i: to_do) {
            if (i.getName().contains(query)) {
                System.out.println(index++ + "." + i.print_req());
            }
        }
    }
}
