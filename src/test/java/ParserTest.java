import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParserTest {
    Parser parse = new Parser("deadline return book /by Sunday");
    @Test
    public void parsing() {
        assertTrue(parse.extract().equals("deadline"));
    }
}
