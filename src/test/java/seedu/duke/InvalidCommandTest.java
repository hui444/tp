package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvalidCommandTest {
    @Test
    public void TestHelp() {
        Command invalid = new HelpCommand("haha");
        assertEquals(false, invalid.isExit());
    }
}