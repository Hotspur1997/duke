public class Deadline extends Request {
    private String ddate;
    public Deadline(String description, String ddate) {
        super(description);
        this.ddate = ddate;
    }
    @Override
    public String print_req() {
        return "[D]" + result() + " " + getName() + " (by: " + ddate + ")";
    }
}
