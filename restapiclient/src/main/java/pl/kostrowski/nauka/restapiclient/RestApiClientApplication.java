package pl.kostrowski.nauka.restapiclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pl.kostrowski.nauka.restapiclient.model.Product;

import java.util.List;

@SpringBootApplication
public class RestApiClientApplication implements CommandLineRunner {

    private final String URL_ADDRESS = "http://localhost:8080/api/products/";
    private final Logger LOG = LoggerFactory.getLogger(RestApiClientApplication.class);

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    public static void main(String[] args) {
        SpringApplication.run(RestApiClientApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {


        LOG.info("Próba pobrania wszystkich produktów przez REST API");
        ParameterizedTypeReference<List<Product>> responseType = new ParameterizedTypeReference<List<Product>>() {};
        ResponseEntity<List<Product>> exchange = restTemplate.exchange(URL_ADDRESS, HttpMethod.GET, null, responseType);
        List<Product> list = exchange.getBody();

        for (Product product : list) {
            LOG.info(product.toString());
        }

        String idOfFirstProduct = list.get(0).getId();

        LOG.info("Próba pobrania pierwszego znalezionego produktu przez REST API");
        Product singleProductByProvidedID = restTemplate.getForObject(URL_ADDRESS + idOfFirstProduct, Product.class);
        LOG.info("Znaleziony produkt " + singleProductByProvidedID.toString());

    }
}
