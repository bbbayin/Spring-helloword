package com.paicaifu.app.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by bayin on 2017/2/24.
 */
@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<Product, Long> {

}
