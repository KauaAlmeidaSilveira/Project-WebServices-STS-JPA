package cursoJavaUdemy.Project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cursoJavaUdemy.Project.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
