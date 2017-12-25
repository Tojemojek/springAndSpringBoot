package pl.kostrowski.nauka.crud.springcrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.kostrowski.nauka.crud.springcrud.model.Product;
import pl.kostrowski.nauka.crud.springcrud.repository.ProductRepository;

@SpringBootApplication
public class SpringcrudApplication implements CommandLineRunner {

    private ProductRepository productRepository;

    @Autowired
    public void productRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringcrudApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        Product product1 = new Product();
        product1.setName("nazwa1");
        product1.setType("typ1");
        product1.setCategory("test");
        product1.setDescription("opis testowy");
        product1.setPrice(0.50);

        productRepository.save(product1);

    }
}
