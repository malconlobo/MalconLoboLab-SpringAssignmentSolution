package in.greatlearning.collegefest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.greatlearning.collegefest.entities.Student;


@Service
public interface StudentOperations {
	
	List<Student> findAll();
	
	Student findById(int id);
	
	void delete(int id);
	
	void save(Student student);

}
