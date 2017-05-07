package com.gannyee.repository;

import com.gannyee.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by gannyee on 2017/5/7.
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Modifying
    @Transactional

    @Query("update UserEntity us set us.username=:qUsername, us.firstName=:qFirstName,us.lastName=:qLastName,us.password=:qPassword where us.id=:qId")
    void updateUser(@Param("qUsername") String username, @Param("qFirstName") String firstName,
                    @Param("qLastName") String qLastName, @Param("qPassword") String password, @Param("qId") Integer id);

}
