import java.util.ArrayList;

class Task { //this is the controller of the entire to-do list
    private ArrayList<String> to_do;
    public Task() {
        to_do = new ArrayList<String>();
    }
    public void add(String task) {
        to_do.add(task);
    }
    public void print_list() {
        for (int i = 0; i < to_do.size(); i++) {
            System.out.println((i + 1) + ". " + to_do.get(i));
        }
    }
}
