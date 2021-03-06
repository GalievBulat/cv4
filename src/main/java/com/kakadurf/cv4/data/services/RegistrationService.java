package com.kakadurf.cv4.data.services;

import com.kakadurf.cv4.data.db.DbManager;
import com.kakadurf.cv4.domain.UserEntity;
import com.kakadurf.cv4.data.dto.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrationService {
    @Autowired
    private DbManager dbManager;
    public void signUp(UserForm form){
        dbManager.save(UserEntity.builder().name(form.getName()).email(form.getEmail())
                .phoneNum(form.getPhone_num()).surname(form.getSurname()).tc(form.getTc())
                .password(form.getPassword()).build());
    }
}
