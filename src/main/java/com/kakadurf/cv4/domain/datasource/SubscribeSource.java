package com.kakadurf.cv4.domain.datasource;

import com.kakadurf.cv4.domain.entities.Subscribe;
import com.kakadurf.cv4.domain.entities.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
@Repository
public interface SubscribeSource {
    List<Subscribe> findBySubscriber_Id(Long id);
}
