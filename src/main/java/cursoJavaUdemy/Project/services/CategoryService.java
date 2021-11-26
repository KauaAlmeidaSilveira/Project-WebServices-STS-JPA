package cursoJavaUdemy.Project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cursoJavaUdemy.Project.entities.Category;
import cursoJavaUdemy.Project.repositories.CategoryRepository;

@Service
public class CategoryService {

	// @Autowired resolve a questão da dependencia e associa uma instancia de userRepository dentro da classe
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return 	repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
		}
	
}
