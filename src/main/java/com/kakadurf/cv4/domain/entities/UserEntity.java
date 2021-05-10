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
/*
    @ManyToMany(fetch = FetchType.LAZY)
    //@JsonIgnore
    @JoinTable(
            name = "subscribes",
            joinColumns = @JoinColumn(name = "subscriber_id"),
            inverseJoinColumns = @JoinColumn(name = "subscribable_id"))
    private Set<UserDto> subscribes;*/
    /*@OneToMany(mappedBy = "owner")
    private Set<FileEntity> files;*/
    //@OneToMany(mappedBy = "subscriber")
    //@JoinColumn(referencedColumnName = "subscriberId")


    //@OneToMany(mappedBy = "subscribable")
    //private Set<Subscribe> subscribers;

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
