package cn.wishhust.jmm.reference;

public class User {
    private String username;
    private int age;

    public User(){}

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    @Override
    public String toString() {
        return username+age;
    }
}
