import java.time.LocalDateTime;

public class Deadline extends Request {
    private LocalDateTime ddate;
    private String localDate;
    public Deadline(String description, LocalDateTime ddate) {
        super(description);
        this.ddate = ddate;
    }
    public Deadline(String description, String localDate) {
        super(description);
        this.localDate = localDate;
    }
    @Override
    public String print_req() {
        return "[D]" + result() + " " + getName() + " (by: " + (ddate == null ? localDate : ddate.toString()) + ")";
    }
    @Override
    public String file_format() {
        return "D | " + index() + " | " + getName() + " | " + (ddate == null ? localDate : ddate.toString());
    }
}
