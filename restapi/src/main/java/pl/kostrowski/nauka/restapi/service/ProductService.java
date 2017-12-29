package pl.kostrowski.nauka.restapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.kostrowski.nauka.restapi.model.Product;
import pl.kostrowski.nauka.restapi.repository.ProductRepository;

@Repository
public class ProductService {
    private final Logger LOG = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    ProductRepository productRepository;

    public Product getProduct(String id) {
        try {
            LOG.info("Próba pobrania produktu o ID = " + id);
            Product productFound = productRepository.findOne(id);
            return productFound;
        } catch (Exception e) {
            LOG.error("Nie znaleziono produktu o ID = " + id);
            LOG.error(e.getMessage());
            return new Product();
        }
    }

    public Product saveProduct(Product product) {
        Product savedProduct;
        try {
            LOG.info("Próba zapisania produktu " + product.toString());
            return productRepository.save(product);
        } catch (Exception e) {
            LOG.error("Nie udało się zapisać produktu " + product.toString());
            LOG.error(e.getMessage());
            return new Product();
        }
    }

    public Product updateProduct(String id, Product product) {
        try {
            LOG.info("Próba zaktualizowania produktu o ID = " + id);
            LOG.info("Na produkt " + product.toString());
            Product productToBeChanged = productRepository.findOne(id);
            LOG.info("Produkt o ID " + id + " znaleziono w bazie");
            product.setId(productToBeChanged.getId());
            return productRepository.save(product);
        } catch (Exception e) {
            LOG.error("Nie udało się zaktualizować produktu o ID =  " + id);
            LOG.error(e.getMessage());
            return new Product();
        }
    }

    public void deleteProduct(String id) {
        LOG.info("Próba usunięcia produktu o ID " + id);
        try {
            Product productToBeDeleted = productRepository.findOne(id);
        } catch (Exception e) {
            LOG.error("Nie udało się usunąć produktu o ID =  " + id);
            LOG.error(e.getMessage());
        }
    }
}
