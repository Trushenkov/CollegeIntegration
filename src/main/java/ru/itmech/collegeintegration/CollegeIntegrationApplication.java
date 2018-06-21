package ru.itmech.collegeintegration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

@EnableWebSecurity
@SpringBootApplication
@ComponentScan
public class CollegeIntegrationApplication extends WebSecurityConfigurerAdapter implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CollegeIntegrationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
