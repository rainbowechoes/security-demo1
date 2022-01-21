package top.rainbowecho.securitydemo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.rainbowecho.web.servlet.security.EnableSecurity;

import java.util.List;

/**
 * @author rainbow
 */
@SpringBootApplication
@EnableSecurity
public class SecurityDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(SecurityDemo1Application.class, args);
    }

}
