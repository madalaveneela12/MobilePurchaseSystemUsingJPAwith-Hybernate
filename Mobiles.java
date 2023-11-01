package hani.com.entity;

import jakarta.persistence.Entity;


import jakarta.persistence.*;

@Entity                                         //create table
public class Mobiles 
{
	@Id                                         //create primary key
	String mobileid;
	String name;
	int price;
	int quantity;
	@OneToOne(mappedBy="mobiles")
	private PurchaseDetails purchasedetails;
	//default constructor
	public Mobiles()
	{
		
	}
	//getter and setter methods
	public String getMobileid() {
		return mobileid;
	}
	public void setMobileid(String mobileid) {
		this.mobileid = mobileid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public PurchaseDetails getPurchasedetails() {
		return purchasedetails;
	}
	public void setPurchasedetails(PurchaseDetails purchasedetails) {
		this.purchasedetails = purchasedetails;
	}
	//parameterized constructor
	public Mobiles(String mobileid, String name, int price, int quantity, PurchaseDetails purchasedetails) {
		super();
		this.mobileid = mobileid;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.purchasedetails = purchasedetails;
	}
	@Override
	public String toString() {
		return "Mobiles [mobileid=" + mobileid + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ ", purchasedetails=" + purchasedetails + "]";
	}
	
	

}
