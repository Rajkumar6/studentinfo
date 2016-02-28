package com.deepan.bmw.studentinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Deepan Sathyamoorthy
 * on 2/28/16.
 */
@SpringBootApplication
@EnableAutoConfiguration
public class StudentInfo {

    public static void main(String[] args) {
        SpringApplication.run(StudentInfo.class, args);
    }
}
