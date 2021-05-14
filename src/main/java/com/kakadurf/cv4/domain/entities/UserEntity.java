package com.kakadurf.cv4.domain.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class UserEntity  {
    private String name;
    private String surname;
    private String phoneNum;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String hashedPassword;
    @Enumerated(value = EnumType.STRING)
    private State state;
    private String emailCode;

    public enum State{
        ACTIVE, NON_CONFIRMED,
    }

    public String toJSON(){
        return "{" +
                "\"name\":\"" + name + '\"' +
                ", \"id\":" + id +
                ", \"email\":\"" + email + '\"' +
                '}';
    }

}
