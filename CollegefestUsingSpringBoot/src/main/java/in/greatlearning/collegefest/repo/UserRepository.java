package in.greatlearning.collegefest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.greatlearning.collegefest.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User getByUsername(String username);
	
}
