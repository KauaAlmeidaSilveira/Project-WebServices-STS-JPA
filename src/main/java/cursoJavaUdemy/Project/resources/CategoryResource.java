package cursoJavaUdemy.Project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cursoJavaUdemy.Project.entities.Category;
import cursoJavaUdemy.Project.services.CategoryService;

 
//O @RestController serve para indicar que esta classe é implementada por um controlador rest
@RestController
@RequestMapping(value="/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	/*	
		O @GetMapping serve para indicar que esse metodo responde a requisição do tipo get do http
		O ResponseEntity<T> é um tipo que retorna respostas de requisições web
		O ResponseEntity.ok() serve para retornar a resposta com sucesso no http
		O .body(u) retorna o corpo da resposta como parametro a entidade Category
	*/
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//@PathVariable serve para que o spring entenda que esse id corresponde ao id citado como value no @GetMapping
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
