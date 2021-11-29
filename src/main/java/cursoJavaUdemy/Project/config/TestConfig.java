package cursoJavaUdemy.Project.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import cursoJavaUdemy.Project.entities.Category;
import cursoJavaUdemy.Project.entities.Order;
import cursoJavaUdemy.Project.entities.OrderItem;
import cursoJavaUdemy.Project.entities.Payment;
import cursoJavaUdemy.Project.entities.Product;
import cursoJavaUdemy.Project.entities.User;
import cursoJavaUdemy.Project.entities.enums.OrderStatus;
import cursoJavaUdemy.Project.repositories.CategoryRepository;
import cursoJavaUdemy.Project.repositories.OrderItemRepository;
import cursoJavaUdemy.Project.repositories.OrderRepository;
import cursoJavaUdemy.Project.repositories.ProductRepository;
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
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

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
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "", cat2);
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "", cat1);
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "", cat3);
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "", cat3);
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "", cat2); 

		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		/*  NO CASO DO PAYMENT NÃO É NECESSARIO UTILIZAR O REPOSITORY, SIMPLESMENTE SETAMOS O PAYMENT NO ORDER
		E SALVAMOS O ORDER NOVAMENTE  */
		o1.setPayment(pay1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		/*
		REALIZANDO AS ASSOCIAÇÕES DE PRODUTOS COM SUAS DEVIDAS CATEGORIAS
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		*/
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		orderRepository.save(o1);
		
	}
	
	
	
}
