package cursoJavaUdemy.Project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cursoJavaUdemy.Project.entities.Order;
import cursoJavaUdemy.Project.repositories.OrderRepository;

@Service
public class OrderService {

	// @Autowired resolve a questão da dependencia e associa uma instancia de userRepository dentro da classe
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return 	repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
		}
	
}
