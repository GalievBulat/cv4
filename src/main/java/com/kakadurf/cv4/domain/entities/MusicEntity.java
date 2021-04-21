package com.kakadurf.cv4.domain.entities;

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
public class MusicEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    private String name;
    private String album;
    private String author;
    //long duration;
    @OneToOne
    @JoinColumn(name = "file_id", referencedColumnName = "id")
    private FileEntity musicFile;

    public String toJSON() {
        return "{" +
                "\"id\":" + id +
                ", \"name\":\"" + name + '\"' +
                ", \"album\":\"" + album + '\"' +
                ", \"author\":\"" + author + '\"' +
                '}';
    }
}
