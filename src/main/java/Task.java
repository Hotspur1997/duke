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
}

class Task { //this is the controller of the entire to-do list
    private ArrayList<Request> to_do;

    public Task() {
        to_do = new ArrayList<>();
    }

    //adds item inside to-do list
    public void add(String task) {
        to_do.add(new Request(task));
    }

    //marks the queried item as done
    public void update_list(String request) throws IndexOutOfBoundsException {
        int index = Integer.parseInt(request);
        index--;
        try {
            to_do.get(index).markAsDone();
            System.out.println("Nice! I've marked this task as done");
            System.out.println("[✓] " + to_do.get(index).getName());
        } catch (IndexOutOfBoundsException e) {
            System.err.println("There are not that many tasks in the list please try again");
        }
    }

    //prints the entire list
    public void print_list() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < to_do.size(); i++) {
            System.out.println((i + 1) + "." + to_do.get(i).result() + " " +
                                to_do.get(i).getName());
        }
    }
}
