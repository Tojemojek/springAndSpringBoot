package pl.kostrowski.nauka.crud.springcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kostrowski.nauka.crud.springcrud.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{

    Product findByType(String type);
    List<Product> findByDescriptionAndCategory(String description, String category);
    List<Product> findByCategoryAndNameIn(String category, List<String> names);
}
