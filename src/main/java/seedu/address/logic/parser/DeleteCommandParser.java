package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.parser.exceptions.IllegalArgumentException;
import seedu.address.logic.parser.exceptions.InvalidFormatException;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DeleteCommand object
 */
public class DeleteCommandParser implements Parser<DeleteCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteCommand
     * and returns a DeleteCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteCommand parse(String args) throws ParseException {
        try {
            return new DeleteCommand(ParserUtil.parseIndex(args));
        } catch (IllegalArgumentException pe) {
            throw new InvalidFormatException(
                    MESSAGE_INVALID_COMMAND_FORMAT,
                    DeleteCommand.COMMAND_WORD,
                    DeleteCommand.MESSAGE_USAGE,
                    pe);
        }
    }

}
