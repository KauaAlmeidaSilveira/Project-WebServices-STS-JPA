package cursoJavaUdemy.Project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cursoJavaUdemy.Project.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
