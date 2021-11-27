package cursoJavaUdemy.Project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cursoJavaUdemy.Project.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
