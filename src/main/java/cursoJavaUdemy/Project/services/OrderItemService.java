package cursoJavaUdemy.Project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cursoJavaUdemy.Project.entities.OrderItem;
import cursoJavaUdemy.Project.repositories.OrderItemRepository;

@Service
public class OrderItemService {

	// @Autowired resolve a questão da dependencia e associa uma instancia de userRepository dentro da classe
	@Autowired
	private OrderItemRepository repository;
	
	public List<OrderItem> findAll(){
		return 	repository.findAll();
	}
	
	public OrderItem findById(Long id) {
		Optional<OrderItem> obj = repository.findById(id);
		return obj.get();
		}
	
}
