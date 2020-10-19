package fitr.parser;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import fitr.command.AddExerciseCommand;
import fitr.command.AddFoodCommand;
import fitr.command.Command;
import fitr.command.DeleteCommand;
import fitr.command.ExitCommand;
import fitr.command.HelpCommand;
import fitr.command.InvalidCommand;
import fitr.command.ViewCommand;
import fitr.command.EditProfileCommand;
import fitr.common.Commands;

/**
 * Parses the user input.
 */
public class Parser {
    public static final Pattern COMMAND_FORMAT = Pattern.compile("(?<command>\\S+)(?<arguments>.*)");

    /**
     * Parses the user input and return a corresponding command.
     * @param userInput String of user input
     * @return a Command object
     */
    public static Command parse(String userInput) {
        Matcher matcher = COMMAND_FORMAT.matcher(userInput.trim());

        if (!matcher.matches()) {
            return new InvalidCommand(userInput);
        }

        String userCommand = matcher.group("command").trim();
        String arguments = matcher.group("arguments").trim();
        switch (userCommand.toLowerCase()) {
        case Commands.COMMAND_FOOD:
            return new AddFoodCommand(arguments, dateTime());
        case Commands.COMMAND_EXERCISE:
            return new AddExerciseCommand(arguments, dateTime());
        case Commands.COMMAND_VIEW:
            return new ViewCommand(arguments);
        case Commands.COMMAND_EDIT_PROFILE:
            return new EditProfileCommand(arguments);
        case Commands.COMMAND_HELP:
            return new HelpCommand(arguments);
        case Commands.COMMAND_DELETE:
            return new DeleteCommand(arguments);
        case Commands.COMMAND_BYE:
            return new ExitCommand(arguments);
        default:
            return new InvalidCommand(arguments);
        }
    }

    public static String dateTime() {
        Calendar calendar = Calendar.getInstance();
        Date currentDateTime = calendar.getTime();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("d/M/y h:m:s a");
        return dateFormatter.format(currentDateTime);
    }
}
