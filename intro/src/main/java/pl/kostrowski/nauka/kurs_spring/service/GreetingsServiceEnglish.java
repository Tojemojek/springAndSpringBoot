package pl.kostrowski.nauka.kurs_spring.service;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("english")
public class GreetingsServiceEnglish implements GreetingService{


    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
