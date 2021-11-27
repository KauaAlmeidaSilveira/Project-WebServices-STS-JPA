package cursoJavaUdemy.Project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cursoJavaUdemy.Project.entities.Product;
import cursoJavaUdemy.Project.repositories.ProductRepository;

@Service
public class ProductService {

	// @Autowired resolve a questão da dependencia e associa uma instancia de userRepository dentro da classe
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return 	repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
		}
	
}
