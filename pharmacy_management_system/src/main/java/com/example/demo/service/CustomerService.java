package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.CustomerEntity;
import com.example.demo.repository.CustomerRepository;



@Service
public class CustomerService {

	@Autowired
	CustomerRepository cr;
	
	public CustomerEntity saveinfo(CustomerEntity ss)
	{
		return cr.save(ss);
	}
	public List<CustomerEntity> savedetails(List<CustomerEntity> ss)
	{
		return (List<CustomerEntity>)cr.saveAll(ss);
	}
	
	public List<CustomerEntity>showinfo()
	{
		return cr.findAll();
	}
	
	public CustomerEntity changeinfo(CustomerEntity ss)
	{
		return cr.saveAndFlush(ss);
	}
	
	public void deleteinfo(CustomerEntity ss)
	{
		cr.delete(ss);
	}
	
	public void deleteid(int id)
	{
		cr.deleteById(id);
		
	}

	public String updateinfobyid(int id,CustomerEntity ss)
	{
		cr.saveAndFlush(ss);
		if(cr.existsById(id))
    {
	return"updated";
     }
    else
    {
    return "enter valid id"	;
    }
	}
}
