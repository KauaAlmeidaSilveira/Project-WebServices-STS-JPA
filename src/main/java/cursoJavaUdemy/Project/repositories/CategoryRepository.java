package cursoJavaUdemy.Project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cursoJavaUdemy.Project.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
