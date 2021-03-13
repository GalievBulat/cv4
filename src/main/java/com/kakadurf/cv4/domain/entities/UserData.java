package com.kakadurf.cv4.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserData {
    private String name;
    private String surname;
    private String phone_num;
    private Long tc;
    private String email;
    private String password;
}
