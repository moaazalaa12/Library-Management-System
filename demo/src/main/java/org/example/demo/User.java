package org.example.demo;

import java.util.List;

public class User {
    private String username;
    private String password;
    private String email;
    private List<String> My_books;

    public User(String username, String password, String email, List<String> My_books) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.My_books = My_books;
    }

    public String getName() {
        return username;
    }

    public void setName(String username) {
        this.username = username;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getMy_books() {
        return My_books;
    }

    public void setMy_books(List<String> my_books) {
        this.My_books = my_books;
    }
}
