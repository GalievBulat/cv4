package com.kakadurf.cv4.framework.db_interface;

import com.kakadurf.cv4.domain.datasource.PostSource;
import com.kakadurf.cv4.domain.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long>, PostSource {
}
