package com.kakadurf.cv4.domain.entities;

import com.kakadurf.cv4.framework_presentation.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
}
