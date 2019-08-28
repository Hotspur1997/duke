public class ToDo extends Request {
    public ToDo(String description) {
        super(description);
    }
    @Override
    public String print_req() {
        return "[T]" + result() + " " + getName();
    }
    @Override
    public String file_format() {
        return "T | " + index() + " | " + getName();
    }
}
