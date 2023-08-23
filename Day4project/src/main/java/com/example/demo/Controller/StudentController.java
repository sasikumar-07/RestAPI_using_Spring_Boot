package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.StudentEntity;
import com.example.demo.Service.StudentService;



@RestController
public class StudentController {
	@Autowired
	StudentService sr;
	
	@GetMapping("getStudentEntity")
	public List<StudentEntity> show(){
		return sr.read();
	}
	
	@GetMapping("getStudentEntityId/{id}")
	public Optional<StudentEntity> showid(@PathVariable int id){
		return sr.readid(id);
	}
	
	@PostMapping("addStudentEntity")
	public boolean add(@RequestBody StudentEntity st) {
		return sr.create(st);
	}
	
	@PutMapping("updateStudentEntity")
	public StudentEntity update(@RequestBody StudentEntity st) {
		return sr.update(st);
	}
	
	@PutMapping("updateStudentEntityParam")
	public String update(@RequestParam int id, @RequestBody StudentEntity st) {
		return sr.updateParam(id, st);
	}
	
	@DeleteMapping("deleteStudentEntity")
	public String delete(@RequestBody StudentEntity st) {
		sr.delete(st);
		return "Record removed successfully";
	}
	
	@DeleteMapping("deleteStudentEntityId/{id}")
	public boolean deleteid(@PathVariable int id) {
		boolean check = sr.deleteId(id);
			return check;
	}
	
	@DeleteMapping("deleteStudentEntityParam")
	public boolean deleteparam(@RequestParam int id) {
		boolean check = sr.deleteParam(id);
		return check;
	}
}