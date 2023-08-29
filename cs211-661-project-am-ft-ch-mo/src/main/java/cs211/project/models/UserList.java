package cs211.project.models;

import java.util.ArrayList;

public class UserList {
    private ArrayList<User> users;

    public UserList() {
        users = new ArrayList<>();
    }

//    public void addNewUser(String username, String name, String password, String rank, String loginTime) {
//        name = name.trim();
//        username = username.trim();
//        password = password.trim();
//        if (!name.equals("") && !username.equals("") && !password.equals("")) {
//            User exist = findUserByUsername(username);
//            if (exist == null) {
//                users.add(new User(username.trim(), name.trim(), password.trim(), rank.trim(), loginTime.trim()));
//            }
//        }
//    }

    public void addNewUser(String username, String name, String password, String loginTime) { // write data with no rank and loginTime
        name = name.trim();
        username = username.trim();
        password = password.trim();
        loginTime = loginTime.trim();
        if (!name.equals("") && !username.equals("") && !password.equals("")) {
            User exist = findUserByUsername(username);
            if (exist == null) {
                users.add(new User(username.trim(), name.trim(), password.trim(), loginTime.trim()));
            }
        }
    }

    public User findUserByUsername(String username) {
        for (User user : users) {
            if (user.isUsername(username)) {
                return user;
            }
        }
        return null;
    }

    public void changeInfo(String username, String name, String password) {
        User exist = findUserByUsername(username);
        if (exist != null) {
            exist.addInfo(username, name, password);
        }
    }

    public ArrayList<User> getUsers() {
        return users;
    }



}