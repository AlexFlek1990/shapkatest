package ru.af.service.dto;

import java.util.List;

public class UserDto {
    private String name;
    private String password;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
