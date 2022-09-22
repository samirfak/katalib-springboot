package fr.codebusters.libkata.Model;

public class User {
    private String name;
    private Integer age;
    private String mail;

    public User(String name, int age, String mail) {
        this.name = name;
        this.age = age;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getMail() {
        return mail;
    }
}