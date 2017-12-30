package pl.kostrowski.nauk.springmvcfull.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.kostrowski.nauk.springmvcfull.model.User;
import pl.kostrowski.nauk.springmvcfull.repository.UserRepository;

import java.util.List;

/**
 * @author KO
 * Data was taken from https://jsonplaceholder.typicode.com/
 * (I really appreciate Your free database for training)
 * just for training purposes.
 */
@Profile(value = "tylkoDoJednegoTestu")
@Component
public class BeforeWeStart implements CommandLineRunner {

    private final String URL_ADDRESS = "https://jsonplaceholder.typicode.com/users";

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... strings) throws Exception {

        ParameterizedTypeReference<List<User>> responseType = new ParameterizedTypeReference<List<User>>() {
        };
        ResponseEntity<List<User>> exchange = restTemplate.exchange(URL_ADDRESS, HttpMethod.GET, null, responseType);
        List<User> list = exchange.getBody();

        for (User user : list) {
            System.out.println(user.getId());
        }
        userRepository.save(list);
    }


}
