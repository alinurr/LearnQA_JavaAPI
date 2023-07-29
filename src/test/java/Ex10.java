import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ex10 {
    @Test
    public void testTextLength(){
        String text = "fdgfdgfgfg";
        assertTrue(text.length() > 15, "Text length is less than 15 symbols");
    }

}

