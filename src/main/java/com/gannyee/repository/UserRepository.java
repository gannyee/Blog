package com.gannyee.repository;

import com.gannyee.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by gannyee on 2017/5/7.
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
