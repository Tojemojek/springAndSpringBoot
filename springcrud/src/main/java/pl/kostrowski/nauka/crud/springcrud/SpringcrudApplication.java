package pl.kostrowski.nauka.crud.springcrud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.kostrowski.nauka.crud.springcrud.model.Product;
import pl.kostrowski.nauka.crud.springcrud.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringcrudApplication implements CommandLineRunner {

    private ProductRepository productRepository;
    private Logger LOG = LoggerFactory.getLogger(SpringcrudApplication.class);

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

        Product product2 = new Product();
        product2.setName("nazwa2");
        product2.setType("typ2");
        product2.setCategory("test");
        product2.setDescription("opis testowy numer 2");
        product2.setPrice(1.50);

        productRepository.save(product2);

        LOG.info("All products found by spring");
        LOG.info("=============================");
        List<Product> all = productRepository.findAll();
        for (Product product : all) {
            LOG.info(product.toString());
        }
        LOG.info("=============================");
        LOG.info("");

        Product resultProduct = productRepository.findByType("typ1");
        LOG.info("Product found by spring by type");
        LOG.info("=============================");
        LOG.info(resultProduct.toString());
        LOG.info("=============================");
        LOG.info("");


        List<Product> byDescriptionAndCategory = productRepository.findByDescriptionAndCategory("opis testowy", "test");
        LOG.info("Product found by spring by description and category");
        LOG.info("=============================");
        for (Product product : byDescriptionAndCategory) {
            LOG.info(product.toString());
        }
        LOG.info("=============================");
        LOG.info("");

        List<String> prodNames = new ArrayList<>();
        prodNames.add("nazwa1");
        prodNames.add("nazwa2");

        List<Product> allByCategoryAndName = productRepository.findByCategoryAndNameIn("test", prodNames);

        LOG.info("Product found by spring by category and in names");
        LOG.info("=============================");

        for (Product product : allByCategoryAndName) {
            LOG.info(product.toString());
        }
        LOG.info("=============================");
        LOG.info("");


    }

}
