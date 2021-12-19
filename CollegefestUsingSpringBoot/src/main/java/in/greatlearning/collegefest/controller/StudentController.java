package in.greatlearning.collegefest.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.greatlearning.collegefest.entities.Student;
import in.greatlearning.collegefest.service.StudentOperations;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentOperations studOps;

	@RequestMapping("/list")
	public String listAll(Model model) {
		List<Student> students = studOps.findAll();
		model.addAttribute("Students", students);
		return "list-student";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {

		Student student = new Student();

		model.addAttribute("Student", student);

		return "student-form";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int id, Model model) {

		Student student = studOps.findById(id);

		model.addAttribute("Student", student);

		return "student-form";
	}

	@PostMapping("/save")
	public String save(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {
		
		Student student;
		
		if(id != 0) {
			student = studOps.findById(id);
			student.setName(name);
			student.setCountry(country);
			student.setDepartment(department);
		}
		else {
			student = new Student(name,department,country);
		}
		
		studOps.save(student);

		return "redirect:/student/list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int id) {
        studOps.delete(id);
        return "redirect:/student/list";
	}
	
	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {
		ModelAndView model = new ModelAndView();
		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}
		model.setViewName("403");
		return model;
	}
	
}