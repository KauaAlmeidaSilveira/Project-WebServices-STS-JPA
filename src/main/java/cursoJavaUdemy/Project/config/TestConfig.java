package cursoJavaUdemy.Project.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import cursoJavaUdemy.Project.entities.Order;
import cursoJavaUdemy.Project.entities.User;
import cursoJavaUdemy.Project.entities.enums.OrderStatus;
import cursoJavaUdemy.Project.repositories.OrderRepository;
import cursoJavaUdemy.Project.repositories.UserRepository;

//Classe responsavel pela configuração do profile test, setado na application.properties

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	/*
	CommandLineRunner serve para realizar determinadas funções enquanto a applicação esta rodadando, as funções
	são colocadas dentro do escopo do metodo run, que vem junto com o CommandLineRunner
	*/
	
	// @Autowired resolve a questão da dependencia e associa uma instancia de userRepository na dentro da classe
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		/*
		O saveAll serve para salvar determinados dados dentro do banco de dados
		Para que o saveAll funcione é necessario que os valores sejam colocados dentro de uma lista
		*/
	
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}
	
	
	
}
