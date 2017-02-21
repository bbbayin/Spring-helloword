package com.paicaifu.app.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by bayin on 2017/2/21.
 */
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);

    User findById(String id);
}
