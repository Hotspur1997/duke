public class Event extends Request {
    private String dtime;
    public Event(String description, String dtime) {
        super(description);
        this.dtime = dtime;
    }
    @Override
    public String print_req() {
        return "[E]" + result() + " " + getName() + " (at: " + dtime + ")";
    }
}
