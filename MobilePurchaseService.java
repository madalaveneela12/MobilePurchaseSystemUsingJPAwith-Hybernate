package hani.com.service;
import hani.com.entity.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.*;
import java.util.*;
import java.util.regex.*;
import hani.com.dao.*;
public class MobilePurchaseService 
{
	MobilePurchaseImpl mpimpl=new MobilePurchaseImpl();
	 public void insertMobileAndPurchaseDetails()
	 {
		 mpimpl.insertMobileAndPurchaseDetails();
	 }
	 public void updateMobileQuantities(String mobileid)
	 {
		 mpimpl. updateMobileQuantities(mobileid);
	 }
	 public void delete(int mobileid)
	{
		mpimpl.delete(mobileid);
	}
	 public void search()
	{
		mpimpl.search();
	}
	public List<Mobiles> display()
	{
		return mpimpl.display();
	}
	

}
