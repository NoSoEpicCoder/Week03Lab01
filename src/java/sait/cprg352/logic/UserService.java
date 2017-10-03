package sait.cprg352.logic;

public class UserService {
    public boolean login(String username, String password){
        return username.equals("adam") || username.equals("betty") && password.equals("password");
    }
}