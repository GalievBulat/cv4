package com.kakadurf.cv4.framework.transport;

import com.kakadurf.cv4.framework.dto.UserDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
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
