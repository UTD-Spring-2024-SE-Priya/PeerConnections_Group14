import java.util.ArrayList;
import java.util.List;

public class group {
    private List<String> members; // list to hold group members

    public group() {
        members = new ArrayList<>(); // initialize the list in the constructor
    }

    // method to add a user to the group; returns false if the user cannot be added
    public boolean addUser(String username) {
        // check if username is null, empty, or already exists in the group
        if(username == null || username.trim().isEmpty() || members.contains(username)) {
            return false; // return false if any condition is true
        }
        members.add(username); // add username to the list
        return true; // return true as the operation is successful
    }

    // method to remove a user from the group; returns true if removal is successful
    public boolean removeUser(String username) {
        return members.remove(username); // remove the user and return the result
    }

    // method to get a list of all members in the group
    public List<String> getMembers() {
        return new ArrayList<>(members); // return a copy of the members list
    }

    // method to get the number of members in the group
    public int getNumberOfMembers() {
        return members.size(); // return the size of the members list
    }
}
