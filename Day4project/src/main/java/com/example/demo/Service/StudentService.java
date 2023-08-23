
package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.StudentEntity;
import com.example.demo.Repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository s;
	
	public boolean create(StudentEntity st) {
		if(!s.existsById(st.getId())) {
			s.save(st);
			return true;
		}
		else
			return false;
	}
	
	public List<StudentEntity> read(){
		return s.findAll();
	}
	
	public Optional<StudentEntity> readid(int id){
		return s.findById(id);
	}
	
	public StudentEntity update(StudentEntity st) {
		return s.saveAndFlush(st);
	}
	
	public String updateParam(int id, StudentEntity st) {
		if(s.existsById(id)){
			s.saveAndFlush(st);
			return "Updated";
		}
		else
			return "Please enter an existing id";
	}
	
	public void delete(StudentEntity st) {
		s.delete(st);
	}
	
	public boolean deleteId(int id) {
		s.deleteById(id);
		if(!s.existsById(id))
			return true;
		else
			return false;
	}
	
	public boolean deleteParam(int id) {
		s.deleteById(id);
		if(!s.existsById(id))
			return true;
		else
			return false;
	}
}