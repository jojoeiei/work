package cs211.project.models;

import java.text.SimpleDateFormat;
import java.util.Date;
public class User {
    private String username;
    private String name;
    private String password;
    private String rank; //admin or user
    public String loginTime;



    //    public User(String username, String name, String password, String rank, String loginTime) {
//        this.username = username;
//        this.name = name;
//        this.password = password;
//        this.rank = rank;
//        this.loginTime = loginTime;
//    }
    public User(String username, String name, String password, String loginTime) { // write data with no rank and loginTime
        this.username = username;
        this.name = name;
        this.password = password;
        this.loginTime = loginTime;

    }

    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }
    public String getUsername() {
        return username;
    }
    public String getRank() {
        return rank;
    }

    public String getLoginTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }



    public void setRank(String rank) {
        this.rank = rank;
    }

    public boolean isUsername(String username) {
        return this.username.equals(username);
    }
    public void addInfo(String username, String name, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "";
    }

}
