package com.kakadurf.cv4.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class FileEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    long id;
    String name;
    long size;
    String type;
    String path;
    String oldName;
}
