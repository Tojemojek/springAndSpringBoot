package pl.kostrowski.nauka.restapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.kostrowski.nauka.restapi.model.Product;
import pl.kostrowski.nauka.restapi.repository.ProductRepository;


@RestController
@RequestMapping(path = "/api/products/")
public class ProductController {

    Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") String id) {
        LOG.info("Próbowano pobrac produkt o ID " + id);
        Product productFound = productRepository.findOne(id);
        LOG.info("Znaleziono " + productFound.toString());
        return productFound;
    }

    @RequestMapping(path = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product saveProduct(@RequestBody Product productToSave) {
        LOG.info("Próbowano zapisać produkt " + productToSave.toString());
        return productRepository.save(productToSave);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product updateProduct(@PathVariable("id") String id, @RequestBody Product productToUpdate) {
        LOG.info("Próbowano zmienić produkt o ID " + id);
        LOG.info("Na produkt " + productToUpdate.toString());
        Product productToBeChanged = productRepository.findOne(id);
        if (productToBeChanged != null) {
            LOG.info("Produkt o ID " + id + " znaleziono w bazie");
            productToUpdate.setId(productToBeChanged.getId());
            return productRepository.save(productToUpdate);
        } else {
            LOG.info("Produktu o ID " + id + "nie znaleziono w bazie danych");
            return null;
        }
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("id") String id) {
        LOG.info("Próbowano usunąć produkt o ID " + id);
        Product productToBeDeleted = productRepository.findOne(id);

        if (productToBeDeleted != null){
            LOG.info("Produkt o ID " + id + " znaleziono w bazie danych");
            productRepository.delete(productToBeDeleted);
        } else{
            LOG.info("Produktu o ID " + id + "nie znaleziono w bazie danych");
        }
    }
}
