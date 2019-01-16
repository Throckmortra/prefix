import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testIsOperand() {
        assertTrue(Main.isOperand('1'));
        assertTrue(Main.isOperand('8'));
        assertTrue(Main.isOperand('5'));
    }

    @Test
    public void testIsOperator() {
        assertFalse(Main.isOperand('*'));
        assertFalse(Main.isOperand('+'));
        assertFalse(Main.isOperand('/'));
    }

    @Test
    public void testEvaluate() {
        assertEquals(20, Main.evaluate("* + 2 3 4"));
    }

    @Test
    public void testMain() {
        //test output of Main
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        String[] commandLineArgs = {"src/test/resources/mockfile"};
        Main.main(commandLineArgs);
        assertEquals("1\n20\n", outContent.toString());
        System.setOut(originalOut);
    }

    @Test
    public void testMainErr() {
        //test output of Main IOException
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        PrintStream originalErr = System.err;
        System.setErr(new PrintStream(errContent));
        String[] commandLineArgsErr = {"asdf"};
        Main.main(commandLineArgsErr);
        assertEquals("big oops: java.nio.file.NoSuchFileException: asdf\n", errContent.toString());
        System.setErr(originalErr);
    }

}
