package seedu.address.logic.commands;

import org.junit.jupiter.api.Test;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;
import seedu.address.model.person.Remark;
import seedu.address.testutil.PersonBuilder;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

class RemarkCommandTest {
    private static final String REMARK_STUB = "i hate cs";

    //@@author asdfghjkxd-reused
    // reused directly from https://github.com/se-edu/addressbook-level3/commit/fac8f3fd855d55831ca0cc73313b5943d
    // 49d4d6e#diff-ff58f7c10338b34f76645df49b71ecb2bafaf7611b20e7ff59ebc98475538a01R36-R49
    @Test
    void execute_addRemarkUnfilteredList_success(Model model) {
        Person firstPerson = model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
        Person editedPerson = new PersonBuilder(firstPerson).withRemark(REMARK_STUB).build();

        RemarkCommand remarkCommand = new RemarkCommand(INDEX_FIRST_PERSON, new Remark(editedPerson.getRemark().value));

        String expectedMessage = String.format(RemarkCommand.MESSAGE_ADD_REMARK_SUCCESS, editedPerson);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        expectedModel.setPerson(firstPerson, editedPerson);

        assertCommandSuccess(remarkCommand, model, expectedMessage, expectedModel);
    }
    //@@author
}