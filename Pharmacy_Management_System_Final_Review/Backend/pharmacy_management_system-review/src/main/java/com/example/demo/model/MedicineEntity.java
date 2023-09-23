package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="medicine_entity")
public class MedicineEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medicineid;
	private String medicinename;
	private int price;
	 private int quantity;
	public MedicineEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MedicineEntity(int medicineid, String medicinename, int price, int quantity) {
		super();
		this.medicineid = medicineid;
		this.medicinename = medicinename;
		this.price = price;
		this.quantity = quantity;
	}
	public int getMedicineid() {
		return medicineid;
	}
	public void setMedicineid(int medicineid) {
		this.medicineid = medicineid;
	}
	public String getMedicinename() {
		return medicinename;
	}
	public void setMedicinename(String medicinename) {
		this.medicinename = medicinename;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}


