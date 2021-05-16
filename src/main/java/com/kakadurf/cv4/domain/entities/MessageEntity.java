package com.kakadurf.cv4.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class MessageEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    private String text;
    @CreationTimestamp
    private Date date;
    private String name;
    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity userEntity;
}
