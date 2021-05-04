package com.kakadurf.cv4.framework.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MusicDto {
    private String name;
    private String album;
    private String author;
    private String fileName;
    private UserDto provider;
    public String toJSON() {
        return "{"  +
                "\"name\":\"" + name + '\"' +
                ", \"album\":\"" + album + '\"' +
                ", \"author\":\"" + author + '\"' +
                ", \"filePath\":\"" + fileName + '\"' +
                ", \"provider\":" + provider.toJSON()  +
                '}';
    }
}
