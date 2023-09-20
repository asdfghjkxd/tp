package seedu.address.logic.parser;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.RemarkCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Remark;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REMARK;

public class RemarkCommandParser implements Parser<RemarkCommand> {

    /**
     * Parses the user input into a RemarkCommand object.
     *
     * @param userInput Input arguments
     * @return RemarkCommand object
     * @throws ParseException if there are any issues when parsing the command
     */
    @Override
    public RemarkCommand parse(String userInput) throws ParseException {
        requireNonNull(userInput);
        ArgumentMultimap argumentMultimap = ArgumentTokenizer.tokenize(userInput, PREFIX_REMARK);

        try {
            Index index = ParserUtil.parseIndex(argumentMultimap.getPreamble());
            Remark remark = new Remark(argumentMultimap.getValue(PREFIX_REMARK).orElse(""));
            return new RemarkCommand(index, remark);
        } catch (IllegalValueException e) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, RemarkCommand.MESSAGE_USAGE), e);
        }
    }
}
