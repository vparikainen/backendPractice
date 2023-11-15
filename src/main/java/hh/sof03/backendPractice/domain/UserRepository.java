package hh.sof03.backendPractice.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	List<User> findAll();
	
	User findByUsername(String username);

}
