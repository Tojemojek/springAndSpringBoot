package pl.kostrowski.nauka.kurs_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class KursSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(KursSpringApplication.class, args);
    }
}
