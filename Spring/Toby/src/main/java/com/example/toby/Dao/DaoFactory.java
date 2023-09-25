package com.example.toby.Dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
public class DaoFactory {
    /*
        DaoFactory는 애플리케이션의 오브젝트들을 구성하고 그 관계를 정의 하는 책임을 맡고 있음
     */
    @Bean
    public DataSource dataSource(){
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

//        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
//        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/Toby?characterEncoding=UTF-8");
//        dataSource.setUsername("root");
//        dataSource.setPassword("16100036");

        return dataSource;
    }

    @Bean
    public UserDao userDao(){
        UserDao userDao = new UserDao();
        userDao.setDataSource(dataSource());
        return userDao;
    }

}
