package com.codeup.politicianlister.models;

import com.codeup.politicianlister.util.Password;

public class User {
    private long id;
    private String username;
    private String email;
    private String password;
    private String bio;
    private Boolean is_Admin;

    public User() {}

    public User(String username, String email,String bio, String password) {
        this.username = username;
        this.email = email;
        this.bio = bio;
        setPassword(password);
    }

    public User(long id, String username, String email, String password, String bio,Boolean admin) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.bio = bio;
        this.is_Admin = admin;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = Password.hash(password);
    }

    public Boolean getIs_Admin() {
        return is_Admin;
    }

    public void setIs_Admin(Boolean is_Admin) {
        this.is_Admin = is_Admin;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
