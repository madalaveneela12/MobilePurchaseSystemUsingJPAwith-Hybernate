package hani.com.dao;
import hani.com.entity.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import jakarta.persistence.*;
import java.util.*;
import java.util.regex.*;
public class MobilePurchaseImpl 
{
	String mobileid;
	String name;
	int price;
	int quantity;
	private PurchaseDetails purchasedetails;
	Mobiles mb=new Mobiles();
	PurchaseDetails pudetails=new PurchaseDetails();
	Scanner sc=new Scanner(System.in);
	 public void insertMobileAndPurchaseDetails()
	 {
		 //create an EntityManagerFactory
			 EntityManagerFactory ef=Persistence.createEntityManagerFactory("pu");
			//create an EntityManager
		     EntityManager em=ef.createEntityManager();
		     
		     //start the transaction
		     em.getTransaction().begin();
		     String id;
		     String name;
		     int price;
		 	 int quantity;
		 	 System.out.println("enter mobileid:");
			 id=sc.nextLine();
			 System.out.println("enter name of the mobile :");
			 name=sc.nextLine();
			 sc.nextLine();
			 System.out.println("enter price of the mobile:");
			 price=sc.nextInt();
			 sc.nextLine();
			 System.out.println("enter quantity of the mobile:");
			 quantity=sc.nextInt();
			 mb.setMobileid(id);
			 mb.setName(name);
			 mb.setPrice(price);
			 mb.setQuantity(quantity);
			 //mb.setPurchasedetails(pudetails);
			
			 
			em.persist(mb);
			//System.out.println("Mobiles Record inserted successfully\n"+mb);
			 
			 
		 
			if(quantity>0)
			 {
			     int purchaseid;
			     System.out.println("enter the purchase id");
			     purchaseid=sc.nextInt();
			     pudetails.setPurchaseid(purchaseid);
			     
			     
				 String cname;
				 System.out.println("enter customer name");
				 sc.nextLine();
				 cname=sc.nextLine();
				 String patternName="^[A-Z][a-z]{0,19}$";
				 Pattern p = Pattern.compile(patternName);     //
				     
				 Matcher m = p.matcher(cname); 
				     
				 boolean matchFound = m.find();
				 if(matchFound)
				 {
				     //System.out.println(cname);
				     pudetails.setCname(cname);
				 }
				 else
					 System.out.println("match not found");
				     
				  
				 
			     String mailid;
			     System.out.println("enter mailid of the customer");
			     mailid=sc.nextLine();
			     String patternName1="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
			     Pattern p1 = Pattern.compile(patternName1);     //
			     
			     Matcher m1 = p1.matcher(mailid); 
			     
			     boolean matchFound1 = m1.find();
			     if(matchFound1)
			     {
			       //System.out.println(mailid);
			    	 pudetails.setMailid(mailid);
			     }
			     else 
			     {
			       System.out.println("Match not found");
			     }
			     
			     
			     
			     String phoneno;
			     System.out.println("enter phoneno");
			     phoneno=sc.nextLine();
			     String patternName2="^\\d{10}$";
			     Pattern p2 = Pattern.compile(patternName2);     //
			     
			     Matcher m2 = p2.matcher(phoneno); 
			     
			     boolean matchFound2 = m2.find();
			     if(matchFound2)
			     {
			       //System.out.println(phoneno);
			    	 pudetails.setPhoneno(phoneno);
			     }
			     else 
			     {
			       System.out.println("Match not found");
			     }
			     
			     String purchasedate;
			     System.out.println("enter the purchase date");
			     purchasedate=sc.nextLine();
			     pudetails.setPurchasedate(purchasedate);
			    
			     String mobileid;
			     System.out.println("enter mobile id");
			     mobileid=sc.nextLine();
			     String patternName3="^\\d{4}$";
			     Pattern p3 = Pattern.compile(patternName3);     //
			     Matcher m3 = p3.matcher(mobileid); 
			     boolean matchFound3 = m3.find();
			     if(matchFound3)
			     {
			       //System.out.println(mobileid);
			    	 pudetails.setMobileid(mobileid);
			     }
			     else 
			     {
			       System.out.println("Match not found");
			     }
			 
			     pudetails.setMobiles(mb);
			     
			     em.persist(pudetails);
			 
				 
				 em.getTransaction().commit();
				 System.out.println("Mobiles Record inserted successfully\n"+mb);
				 
				 System.out.println("purchase details Record inserted successfully\n"+pudetails);
			 }
			 else
			 {
				 System.out.println("mobiles are not available");
			 }
				
			 em.close();
			 ef.close(); 
		     
	 }
	    int purchaseid;
		String cname;
		String mailid;
		String phoneno;
		String purchasedate;
		private Mobiles mobiles;
	 public void updateMobileQuantities(String mobileid)
	 {
		//create an EntityManagerFactory
		 EntityManagerFactory ef=Persistence.createEntityManagerFactory("pu");
		//create an EntityManager
		 EntityManager em=ef.createEntityManager();
		 //start the transaction
		 em.getTransaction().begin(); 
		 
		 //Mobiles mb=new Mobiles(mobileid,name,price,quantity,purchasedetails);
		 
		 //PurchaseDetails pd=new PurchaseDetails(purchaseid,cname,mailid,phoneno,purchasedate,mobileid, mobiles);
		 
		 mb=em.find(Mobiles.class,mobileid);
		 sc.nextLine();
		 

		 System.out.println("enter quantity to update the record:"); 
		 quantity=sc.nextInt();
		 
		 mb.setQuantity(quantity);
		 
		 //commit the transaction
			em.getTransaction().commit();
			System.out.println("Record Updated Successfully");
			
			em.close();
			ef.close();
	 }
	 
	 public void delete(int mobileid)
	 {
			//create an EntityManagerFactory
			 EntityManagerFactory ef=Persistence.createEntityManagerFactory("pu");
			 
			//create an EntityManager
			 EntityManager em=ef.createEntityManager();
			 Mobiles mb=new Mobiles();
			 
			//begin a new transaction
			 em.getTransaction().begin(); 
			 //finding record based on id
			 mb=em.find(Mobiles.class,mobileid);
			 
			 if(mb!=null)
			 {
				 //removing record based on id if not null
				 em.remove(mb);
				 System.out.println("record deleted succesfully");
			 }
			 else
			 {
				 System.out.println("mobile of this id are not available");
			 }
			//commit the transaction
			 em.getTransaction().commit();
			 
			//close entitymanager and entitymanagerfactory
			 em.close();
			 ef.close();
	  }
	 
	 public void search()
		{
			//create an EntityManagerFactory
			EntityManagerFactory ef=Persistence.createEntityManagerFactory("pu");
			
			//create an EntityManager
			EntityManager em=ef.createEntityManager();
			
			//begin a new transaction
			em.getTransaction().begin();
			System.out.println("enter min price:");
			int min_price=sc.nextInt();
			System.out.println("enter max price:");
			int max_price=sc.nextInt();
			//query for rangeofprice
			TypedQuery<Mobiles> query=em.createQuery("select mob from Mobiles mob where mob.price between :min_price and :max_price",Mobiles.class);
			query.setParameter("max_price",max_price );
			query.setParameter("min_price",min_price );
			//list storing all mobiles in given range
			List<Mobiles> mobileinprice=query.getResultList();
			if(mobileinprice.isEmpty())
			{
				 System.out.println("mobile of this price range are not available");
			}
			else
			{
				System.out.println("mobile of this price range are:");
				//printing list
				for(Mobiles mobile:mobileinprice)
				{
					System.out.println("mobileId: "+mobile.getMobileid()+" mobilename: "+mobile.getName()+" price: "+mobile.getPrice());
				}
			}
			//commit the transaction
			em.getTransaction().commit();
			//close entitymanager and entitymanagerfactory
			ef.close();
			em.close();
		}
		
	//method to view mobile data
		public List<Mobiles> display()
		{
			//create an EntityManagerFactory
			EntityManagerFactory ef=Persistence.createEntityManagerFactory("pu");
			
			//create an EntityManager
			EntityManager em=ef.createEntityManager();
			
			//begin a new transaction
			em.getTransaction().begin();
			Query query=em.createNamedQuery("view");
			@SuppressWarnings("unchecked")
			List<Mobiles> list=query.getResultList();
			//close entitymanager and entitymanagerfactory
			ef.close();
			em.close();
			return list;
		}
	     
	 

}
