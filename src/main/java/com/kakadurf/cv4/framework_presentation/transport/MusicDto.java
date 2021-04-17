package com.kakadurf.cv4.framework_presentation.transport;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MusicDto {
    private String name;
    private String album;
    private String author;
    private String filePath;
    public String toJSON() {
        return "{"  +
                "\"name\":\"" + name + '\"' +
                ", \"album\":\"" + album + '\"' +
                ", \"author\":\"" + author + '\"' +
                ", \"filePath\":\"" + filePath + '\"' +
                '}';
    }
}
