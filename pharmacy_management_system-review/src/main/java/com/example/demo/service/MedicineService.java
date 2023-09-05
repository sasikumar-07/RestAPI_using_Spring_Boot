package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.demo.model.MedicineEntity;
import com.example.demo.repository.MedicineRepository;



@Service
public class MedicineService {

	@Autowired
	MedicineRepository mr;
	
	public MedicineEntity saveinfo(MedicineEntity ss)
	{
		return mr.save(ss);
	}
	public List<MedicineEntity> savedetails(List<MedicineEntity> ss)
	{
		return (List<MedicineEntity>)mr.saveAll(ss);
	}
	
	public List<MedicineEntity>showinfo()
	{
		return mr.findAll();
	}
	
	public MedicineEntity changeinfo(MedicineEntity ss)
	{
		return mr.saveAndFlush(ss);
	}
	
	public void deleteinfo(MedicineEntity ss)
	{
		mr.delete(ss);
	}
	
	public void deleteid(int id)
	{
		mr.deleteById(id);
		
	}

	public String updateinfobyid(int medicineid,MedicineEntity ss)
	{
		mr.saveAndFlush(ss);
		if(mr.existsById(medicineid))
    {
	return"updated";
     }
    else
    {
    return "enter valid id"	;
    }
	}
	

  public List<MedicineEntity> sortinfo(String s)
    {
    	return mr.findAll(Sort.by(Sort.DEFAULT_DIRECTION,s));
    } 

   public List<MedicineEntity> getbypage(int pgno,int pgsize)

    {

    	Page<MedicineEntity> p = mr.findAll(PageRequest.of(pgno, pgsize));
    	return p.getContent();

    }


public List<MedicineEntity> getname(String n)

{

	return mr.getnameInfo(n);

}
public int DeleteByQuery(int i)

{

	 return mr.deletecustomerId(i);

}
public int UpdateByQuery(int newid,int oldid)

{

	 return mr.updatecustomerId(newid,oldid);

}


}
