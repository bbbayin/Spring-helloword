package com.paicaifu.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
public class HollowordApplicationTests {
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate1;

    @Autowired
    @Qualifier("secondaryTemplate")
    private JdbcTemplate jdbcTemplate2;

    @Test
    public void testPrimary(){
        jdbcTemplate1.update("INSERT INTO USER (NAME ,age) VALUES (?,?)","p1","44");
        jdbcTemplate1.update("INSERT INTO USER (NAME ,age) VALUES (?,?)","p2","84");
        jdbcTemplate2.update("INSERT INTO message (NAME ,age) VALUES (?,?)","s1","74");
    }
}
