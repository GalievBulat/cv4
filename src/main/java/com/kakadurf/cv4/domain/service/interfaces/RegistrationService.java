package com.kakadurf.cv4.domain.service.interfaces;

import com.kakadurf.cv4.domain.entities.UserData;
import com.kakadurf.cv4.domain.entities.UserEntity;

public interface RegistrationService {
    UserEntity signUp(UserData form, String code);
}
