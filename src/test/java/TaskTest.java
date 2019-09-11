import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskTest {
    Task schedule = new Task();
    @Test
    public void test() {
        assertTrue(schedule.size() == 0);
    }
}
