package com.kakadurf.cv4.domain.transport.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class PostInfo {
    private long parentId;
    private String text;
    private long musicId;
}
