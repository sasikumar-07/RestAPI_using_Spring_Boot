package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.model.EmployeeEntity;


@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository er;
	public EmployeeEntity saveinfo(EmployeeEntity ee)
	{
		return er.save(ee);
	}
	public List<EmployeeEntity>showinfo()
	{
		return er.findAll();
	}
	

}
