package com.kakadurf.cv4.framework.db_interface;

import com.kakadurf.cv4.domain.datasource.UserSource;
import com.kakadurf.cv4.domain.entities.MusicEntity;
import com.kakadurf.cv4.domain.entities.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>, UserSource {
    @Query("SELECT c FROM UserEntity c WHERE (:name is null or c.name = :name) and" +
            " (:email is null or c.email = :email)")
    List<UserEntity> findUserAdmin(@Param("name") String name,
                                   @Param("email") String email,
                                   Pageable pageable
    );
}
