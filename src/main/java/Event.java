import java.time.LocalDateTime;

public class Event extends Request {
    private LocalDateTime dtime;
    private String dt_string;
    public Event(String description, LocalDateTime dtime) {
        super(description);
        this.dtime = dtime;
    }
    public Event(String description, String dt_string) {
        super(description);
        this.dt_string = dt_string;
    }

    @Override
    public String print_req() {
        return "[E]" + result() + " " + getName() + " (at: " + (dtime == null ? dt_string: dtime.toString()) + ")";
    }
    @Override
    public String file_format() {
        return "E | " + index() + " | " + getName() + " | " + (dtime == null ? dt_string: dtime.toString());
    }
}
