package com.kakadurf.cv4.framework.controller.rest.task_cv;

import com.kakadurf.cv4.domain.datasource.UserSource;
import com.kakadurf.cv4.domain.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("JwtPopulation")
public class UserDetailsPopulation {
    @Autowired
    UserSource userSource;
    public boolean inflateJwt(UserEntity userEntity){
        Optional<UserEntity> user = userSource.findById(userEntity.getId());
        if (user.isPresent()){
            UserEntity actualUser = user.get();
            userEntity.setPhoneNum(actualUser.getPhoneNum());
            userEntity.setHashedPassword(actualUser.getHashedPassword());
            userEntity.setSurname(actualUser.getSurname());
            userEntity.setName(actualUser.getName());
            userEntity.setEmail(actualUser.getEmail());
            userEntity.setState(actualUser.getState());
            return true;
        }
        return true;
    }
}
