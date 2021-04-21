package com.kakadurf.cv4.framework_presentation.transport;

import com.kakadurf.cv4.framework_presentation.dto.UserDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MusicDto {
    private String name;
    private String album;
    private String author;
    private String filePath;
    private UserDto provider;
    public String toJSON() {
        return "{"  +
                "\"name\":\"" + name + '\"' +
                ", \"album\":\"" + album + '\"' +
                ", \"author\":\"" + author + '\"' +
                ", \"filePath\":\"" + filePath + '\"' +
                ", \"provider\":\"" + provider.toJSON() + '\"' +
                '}';
    }
}
