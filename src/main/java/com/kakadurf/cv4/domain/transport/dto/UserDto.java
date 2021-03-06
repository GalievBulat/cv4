package com.kakadurf.cv4.domain.transport.dto;

import lombok.Data;

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
