package com.kakadurf.cv4.domain.datasource;

import com.kakadurf.cv4.domain.entities.PostEntity;
import com.kakadurf.cv4.domain.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



import java.util.List;

public interface PostSource {
    Page<PostEntity> findAllByParentIsNull(Pageable pageable);
    PostEntity findAllById(long id);
    PostEntity save(PostEntity postEntity);
    Page<PostEntity> findByParent(PostEntity postEntity, Pageable pageable);
}
