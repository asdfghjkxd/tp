package seedu.address.model.tag;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

class MemberTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Member(null));
    }

    @Test
    public void constructor_invalidMemberName_throwsIllegalArgumentException() {
        String invalidMemberName = "";
        assertThrows(IllegalArgumentException.class, () -> new Member(invalidMemberName));
    }

    @Test
    public void isValidMemberName() {
        // null tag name
        assertThrows(NullPointerException.class, () -> Member.isValidName(null));
    }

    @Test
    public void equals_self_valid() {
        Member member = new Member("John");
        assertTrue(member.equals(member));
    }

    @Test
    public void equals_notSame_invalid() {
        Member member = new Member("John");
        Member otherMember = new Member("otherJohn");
        assertFalse(member.equals(otherMember));
    }

    @Test
    public void equals_differentType_invalid() {
        Member member = new Member("John");
        Tag tag = new Tag("John");

        assertFalse(member.equals(tag));
    }

    @Test
    public void toString_member_valid() {
        Member tag = new Member("John");
        assertEquals(tag.toString(), "[John]");
    }
}