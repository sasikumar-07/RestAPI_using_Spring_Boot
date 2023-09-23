package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MedicineEntity;
import com.example.demo.service.MedicineService;

@RestController
@CrossOrigin
public class MedicineController {
	@Autowired
	MedicineService mser;
	
	@PostMapping("addmedicine")
	public MedicineEntity add(@RequestBody MedicineEntity ss)
	{
		return mser.saveinfo(ss);
	}
	@PostMapping("addn")
	public List<MedicineEntity> addndetails(@RequestBody List <MedicineEntity> ss)
	{
		return mser.savedetails(ss);
	}
	@GetMapping("medicineDetails")
	public List<MedicineEntity>show(){
		return mser.showinfo();
	}
	
	@PutMapping("medicineupdate")
	public MedicineEntity modify(@RequestBody MedicineEntity ss)
	{
		return mser.changeinfo(ss);
	}
	
	@DeleteMapping("medicinedelete")
	public String del(@RequestBody MedicineEntity ss)
	{
    mser.deleteinfo(ss);
    return "Deleted successfully";	
	}
	
	@DeleteMapping("delid/{medicineid}")
	public void deletemyid(@PathVariable int medicineid)
	{
		mser.deleteid(medicineid);
	
	}
	
	@PutMapping("updatebyid/{medicineid}")
	public String modifybyid(@PathVariable int medicineid,@RequestBody MedicineEntity ss) {
		return mser.updateinfobyid(medicineid,ss);
	}
	
	@GetMapping("sort/{st}")

	public List<MedicineEntity> getsortinfo(@PathVariable String st)

	{
     return mser.sortinfo(st);

	}

	@GetMapping("paging/{pageno}/{pagesize}")

	public List<MedicineEntity> showpageinfo(@PathVariable int pageno,@PathVariable int pagesize)

	{

		return mser.getbypage(pageno,pagesize);

	}
	//query for select
	@GetMapping("cn/{cname}")
	public List<MedicineEntity> getmedicinename(@PathVariable String cname)

    {
 	   return mser.getname(cname);

    }
	
	//Delete by Query

	 	@DeleteMapping("DQueryById/{id}")

	 	public String DeleteDetailsByQuery(@PathVariable int id)

	 	{
           return mser.DeleteByQuery(id)+" Deleted Successfully";
    	}
	 	

	 	//Update by Query

	 	@PutMapping("UQueryById/{newid}/{oldid}")

	 	public String UpdateDetailsByQuery(@PathVariable int newid, @PathVariable int oldid)

	 	{

	 		return mser.UpdateByQuery(newid,oldid)+" Updated Successfully";

	 	}

	 	
}
