import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class MainTest {
    @Test
    void printsGreeting() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        try {
            Main.main(new String[0]);
        } finally {
            System.setOut(originalOut);
        }

        assertEquals("Hello, CI World" + System.lineSeparator(), output.toString());
    }
}
