package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CustomerEntity;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService cser;
	
	@PostMapping("addcustomer")
	public CustomerEntity add(@RequestBody CustomerEntity ss)
	{
		return cser.saveinfo(ss);
	}
	@PostMapping("addn")
	public List<CustomerEntity> addndetails(@RequestBody List <CustomerEntity> ss)
	{
		return cser.savedetails(ss);
	}
	@GetMapping("customerDetails")
	public List<CustomerEntity>show(){
		return cser.showinfo();
	}
	
	@PutMapping("customerupdate")
	public CustomerEntity modify(@RequestBody CustomerEntity ss)
	{
		return cser.changeinfo(ss);
	}
	
	@DeleteMapping("customerdelete")
	public String del(@RequestBody CustomerEntity ss)
	{
    cser.deleteinfo(ss);
    return "Deleted successfully";	
	}
	
	@DeleteMapping("delid/{id}")
	public void deletemyid(@PathVariable int id)
	{
		cser.deleteid(id);
	
	}
	
	@PutMapping("updatebyid/{id}")
	public String modifybyid(@PathVariable int id,@RequestBody CustomerEntity ss) {
		return cser.updateinfobyid(id,ss);
	}
}
