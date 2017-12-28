package pl.kostrowski.nauka.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.kostrowski.nauka.restapi.model.Product;
import pl.kostrowski.nauka.restapi.repository.ProductRepository;

@SpringBootApplication
public class RestapiApplication implements CommandLineRunner {

	@Autowired
	ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
	}


	@Override
	public void run(String... strings) throws Exception {

		Product prod1 = new Product();
		Product prod2 = new Product();
		Product prod3 = new Product();

		prod1.setName("Produkt Testowy1");
		prod2.setName("Produkt Testowy2");
		prod3.setName("Produkt Testowy3");

		prod1.setCategory("Testowy");
		prod2.setCategory("Testowy");
		prod3.setCategory("Normalny");

		prod1.setDescription("Opis 1");
		prod2.setDescription("Opis 2");
		prod3.setDescription("Opis 3");

		prod1.setType("Ładny");
		prod2.setType("Średni");
		prod3.setType("Brzydki");

		prod1.setPrice(10.0);
		prod2.setPrice(11.0);
		prod3.setPrice(3.0);

		productRepository.save(prod1);
		productRepository.save(prod2);
		productRepository.save(prod3);

	}
}
