package com.kakadurf.cv4.domain.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

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
    /*@OneToMany(mappedBy = "owner")
    private Set<FileEntity> files;*/

    public enum State{
        ACTIVE, NONCONFIRMED
    }

    public String toJSON(){
        return "{" +
                "\"name\":\"" + name + '\"' +
                ", \"id\":" + id +
                ", \"email\":\"" + email + '\"' +
                '}';
    }

}
