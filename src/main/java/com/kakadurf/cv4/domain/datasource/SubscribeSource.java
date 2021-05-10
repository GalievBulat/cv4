package com.kakadurf.cv4.domain.datasource;

import com.kakadurf.cv4.domain.entities.Subscribe;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SubscribeSource {
    List<Subscribe> findBySubscriber_Id(Long id);
}
