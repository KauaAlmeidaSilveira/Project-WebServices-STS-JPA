package cursoJavaUdemy.Project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cursoJavaUdemy.Project.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
