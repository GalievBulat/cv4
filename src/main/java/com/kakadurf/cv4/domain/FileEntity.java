package com.kakadurf.cv4.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class FileEntity {
    String name;
    long size;
    String type;
}
