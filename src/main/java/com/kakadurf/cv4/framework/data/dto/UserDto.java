package com.kakadurf.cv4.framework.data.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserDto {
    private long id;
    private String name;
    private String surname;
    private String email;
    //private Set<Long> subscribedId;
    public String toJSON() {
        return "{" +
                "\"id\":" + id +
                ", \"name\":\"" + name + '\"' +
                ", \"surname\":\"" + surname + '\"' +
                ", \"email\":\"" + email + '\"' +
                '}';
    }
}