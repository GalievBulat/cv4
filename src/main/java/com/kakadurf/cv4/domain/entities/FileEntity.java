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
public class FileEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    private String name;
    private long size;
    private String type;
    private String path;
    private String oldName;
    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity owner;
    @CreationTimestamp
    private Date uploadDate;
}
