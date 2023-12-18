//package com.BudgetBackers.repository;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//@Configuration
//public class DatabaseConfiguration {
//    String databaseUrl = System.getenv("DATABASE_URL");
//    String user = System.getenv("DATABASE_USER");
//    String password = System.getenv("DATABASE_PASSWORD");
//
//    @Bean
//    public Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(
//          databaseUrl,
//          user,
//          password
//        );
//    }
//}
