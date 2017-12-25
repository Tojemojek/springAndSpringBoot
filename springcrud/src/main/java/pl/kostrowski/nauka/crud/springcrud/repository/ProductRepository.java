package pl.kostrowski.nauka.crud.springcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kostrowski.nauka.crud.springcrud.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{

}
