package com.kakadurf.cv4.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserData {
    @NotBlank(message = "{error.null_name}")
    private String name;
    @NotBlank(message = "{error.null_surname}")
    private String surname;
    @Size(min = 11, max = 12,
            message = "{error.incorrect_phone_num}")
    private String phone_num;
    @Email(message = "{error.wrong_email}")
    private String email;
    @NotBlank(message = "{error.null_email}")
    @Size(min = 8, message = "{error.short_password}")
    private String password;
}
