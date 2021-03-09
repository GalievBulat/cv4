package com.kakadurf.cv4.domain.facade;

import com.kakadurf.cv4.data.dto.UserForm;

public interface RegistrationService {
    void signUp(UserForm form);
}
