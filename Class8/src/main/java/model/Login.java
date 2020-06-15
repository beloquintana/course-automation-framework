package model;

public class Login {
    private String user;
    private String pass;

    public String getPass() {
        return pass;
    }

    public String getUser() {
        return user;
    }

    public String toString(){
        return user + " : " + pass;
    }
}
