package cursoJavaUdemy.Project.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cursoJavaUdemy.Project.entities.User;

 
//O @RestController serve para indicar que esta classe é implementada por um controlador rest
@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	/*	
		O @GetMapping serve para indicar que esse metodo responde a requisição do tipo get do http
		O ResponseEntity<T> é um tipo que retorna respostas de requisições web
		O ResponseEntity.ok() serve para retornar a resposta com sucesso no http
		O .body(u) retorna o corpo da resposta como parametro a entidade User
	*/
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "maria", "maria@gmail.com", "888888888", "12345");
		return ResponseEntity.ok().body(u);
	}
	
}
