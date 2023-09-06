package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {

    @Test
    @DisplayName("User should be found in UserList")
    public void testUserListFindUser() {
        UserList s = new UserList();
        // TODO: add 3 users to UserList
        s.addUser("user1", "password1");
        s.addUser("user2", "password2");
        s.addUser("user3", "password3");
        // TODO: find one of them
        User user = s.findUserByUsername("user1");
        // TODO: assert that UserList found User
         String expected = "user1";
         String actual = user.getUsername();
         assertEquals(expected, actual);
    }

    @Test
    @DisplayName("User can change password")
    public void testUserCanChangePassword() {
        UserList s = new UserList();
        // TODO: add 3 users to UserList
        s.addUser("user1", "password1");
        s.addUser("user2", "password2");
        s.addUser("user3", "password3");
        // TODO: change password of one user
        boolean user = s.changePassword("user1", "password1", "password111");
        // TODO: assert that user can change password
        boolean actual = user;
        assertTrue(actual);
    }

    @Test
    @DisplayName("User with correct password can login")
    public void testUserListShouldReturnObjectIfUsernameAndPasswordIsCorrect() {
        UserList s = new UserList();
        // TODO: add 3 users to UserList
        s.addUser("user1", "password1");
        s.addUser("user2", "password2");
        s.addUser("user3", "password3");
        // TODO: call login() with correct username and password
        User user = s.login("user1", "password1");
        // TODO: assert that User object is found
        String expected = "user1";
        String actual = user.getUsername();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("User with incorrect password cannot login")
    public void testUserListShouldReturnNullIfUsernameAndPasswordIsIncorrect() {
        UserList s = new UserList();
        // TODO: add 3 users to UserList
        s.addUser("user1", "password1");
        s.addUser("user2", "password2");
        s.addUser("user3", "password3");
        // TODO: call login() with incorrect username or incorrect password
        User user = s.login("user1", "111");
        // TODO: assert that the method return null
        assertNull(user);
    }

}