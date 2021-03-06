package com.kakadurf.cv4.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {
    private String name;
    private String surname;
    private String phone_num;
    private Long tc;
    private String email;
    private String password;
}
