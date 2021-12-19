package in.greatlearning.collegefest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.greatlearning.collegefest.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	

}
