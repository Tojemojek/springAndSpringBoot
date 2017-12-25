package pl.kostrowski.nauka.kurs_spring.service;

import org.springframework.stereotype.Component;

@Component
public interface GreetingService {
    String sayHello(String name);
}
