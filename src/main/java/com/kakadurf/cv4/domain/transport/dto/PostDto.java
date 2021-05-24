package com.kakadurf.cv4.domain.transport.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class PostDto {
    private long id;
    private long parentId;
    private int liked;
    private UserDto owner;
    private String text;
    private MusicDto music;
    public String toJSON() {
        return "{" +
                "\"id\":" + id +
                ", \"parentId\":\"" + parentId + '\"' +
                ", \"liked\":" + liked  +
                ", \"owner\":" + owner.toJSON()  +
                ", \"text\":\"" + text + '\"' +
                ", \"music\":" + (music!=null ? music.toJSON() : "{}") +
                '}';
    }
}
