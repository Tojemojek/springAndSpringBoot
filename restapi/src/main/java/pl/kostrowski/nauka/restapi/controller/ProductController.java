package pl.kostrowski.nauka.restapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.kostrowski.nauka.restapi.model.Product;
import pl.kostrowski.nauka.restapi.service.ProductService;

import java.util.List;


@RestController
@RequestMapping(path = "/api/products/")
public class ProductController {

    Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Product> getProduct() {
        return productService.getAllProducts();
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") String id) {
        return productService.getProduct(id);
    }

    @RequestMapping(path = "", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product saveProduct(@RequestBody Product productToSave) {
        return productService.saveProduct(productToSave);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product updateProduct(@PathVariable("id") String id,
                                 @RequestBody Product productToUpdate) {
        return productService.updateProduct(id, productToUpdate);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("id") String id) {
        productService.deleteProduct(id);
    }
}
