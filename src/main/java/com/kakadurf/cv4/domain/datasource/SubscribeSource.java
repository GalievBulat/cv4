package com.kakadurf.cv4.domain.datasource;

import com.kakadurf.cv4.domain.entities.Subscribe;
import com.kakadurf.cv4.domain.entities.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SubscribeSource {
    List<Subscribe> findBySubscriber(UserEntity subscriber);
    List<Subscribe> findBySubscriber_Id(long id);
}
