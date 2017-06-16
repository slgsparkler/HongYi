package com.hongyi.testslg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import lombok.extern.slf4j.*;

@RestController
@EnableAutoConfiguration
@Slf4j
public class App {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!123221";
    }
    
    public static void main(String[] args) throws Exception {
   //     SpringApplication.run(App.class, args);
    	
        Class.forName("org.postgresql.Driver");
        Connection connection = null;

        try {

                connection = DriverManager.getConnection(
                                "jdbc:postgresql://127.0.0.1:5432/postgres", "postgres",
                                "admin");

        } catch (SQLException e) {

                System.out.println("Connection Failed! Check output console");
                e.printStackTrace();
                return;
        }
        
        System.out.println("Connection Succeed! Check output console");
        log.debug("test slg 123");

    }
}