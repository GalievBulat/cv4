package com.kakadurf.cv4.framework.dto;

import lombok.Data;

@Data
public class UserDto {
    private long id;
    private String name;
    private String surname;
    private String email;
    public String toJSON() {
        return "{" +
                "\"id\":" + id +
                ", \"name\":\"" + name + '\"' +
                ", \"surname\":\"" + surname + '\"' +
                ", \"email\":\"" + email + '\"' +
                '}';
    }
}
