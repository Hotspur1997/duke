import java.util.ArrayList;

class Request { //controls each element inside the to-do list
    private String name;
    private boolean completed;

    public Request(String name) {
        this.name = name;
        this.completed = false;
    }

    public void markAsDone() {
        completed = true;
    }

    //returns the symbol to be printed depending on the status of the item
    public String result() {
        return (completed ? "[✓]" : "[✗]");
    }

    public String getName() {
        return name;
    }
    public String print_req() {
        return result() + " " + name;
    }
    public int index() {
        return (completed ? 1 : 0);
    }
    public String file_format() {
        return "";
    }
}

class Task { //this is the controller of the entire to-do list
    private ArrayList<Request> to_do;
    FileParse fp;
    public Task() {
        to_do = new ArrayList<>();
        fp = new FileParse();
    }

    //adds item inside to-do list
    public void add(Request d) throws Exception {
        to_do.add(d);
        System.out.println("Got it. I've added this task: ");
        System.out.println(d.print_req());
        System.out.println("Now you have " + to_do.size() + " tasks in the list.");
        try {
            fp.save_file(to_do);
        } catch (Exception e) {
            throw new Exception("File error is: " + e.getMessage());
        }
    }

    //marks the queried item as done
    public void update_list(String request) throws Exception {
        int index = Integer.parseInt(request);
        index--;
        try {
            to_do.get(index).markAsDone();
            System.out.println("Nice! I've marked this task as done");
            System.out.println("[✓] " + to_do.get(index).getName());
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("There are not that many tasks in the list please try again");
        }
    }

    public void remove_item(String req) throws Exception {
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
            throw new IndexOutOfBoundsException("The list is not that large, please try again");
        } catch (Exception e) {
            throw new Exception("File error is: " + e.getMessage());
        }
    }

    //prints the entire list
    public void print_list() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < to_do.size(); i++) {
            System.out.println((i + 1) + "." + to_do.get(i).print_req());
        }
    }

    public ArrayList<Request> retrieve_list() {
        return to_do;
    }

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
