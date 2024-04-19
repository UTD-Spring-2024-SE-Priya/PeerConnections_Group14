import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GroupTest {
    private Group group; // instance of Group to be used in tests

    @BeforeEach
    void setUp() {
        group = new Group(); // initialize a new Group before each test
    }

    @Test
    void addUser() {
        // test adding users to the group
        assertTrue(group.addUser("zoo230000")); // should return true
        assertTrue(group.addUser("dtz200000")); // should return true
        assertFalse(group.addUser("zoo230000")); // should return false as zoo230000 already exists
        assertFalse(group.addUser(null)); // should return false as user is null
        assertFalse(group.addUser(" ")); // should return false as user is empty
    }

    @Test
    void removeUser() {
        group.addUser("zoo230000"); // add a user for removal test
        assertTrue(group.removeUser("zoo230000")); // should return true as zoo230000 is removed
        assertFalse(group.removeUser("dtz200000")); // should return false as dtz200000 was never added
    }

    @Test
    void getMembers() {
        group.addUser("zoo230000");
        group.addUser("dtz200000");
        List<String> members = group.getMembers(); // get the list of members
        assertEquals(2, members.size()); // should be 2 members
        assertTrue(members.contains("zoo230000")); // list should contain zoo230000
        assertTrue(members.contains("dtz200000")); // list should contain dtz200000
    }

    @Test
    void getNumberOfMembers() {
        assertEquals(0, group.getNumberOfMembers()); // initially, should be 0 members
        group.addUser("zoo230000"); // after adding zoo230000
        assertEquals(1, group.getNumberOfMembers()); // now should be 1 member
        group.addUser("dtz200000"); // after adding dtz200000
        assertEquals(2, group.getNumberOfMembers()); // now should be 2 members
    }
}
