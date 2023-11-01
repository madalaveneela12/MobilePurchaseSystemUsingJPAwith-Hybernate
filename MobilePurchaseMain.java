package hani.com.client;
import hani.com.entity.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import jakarta.persistence.*;
import java.util.*;
import java.util.regex.*;
import hani.com.dao.*;
import hani.com.service.*;
public class MobilePurchaseMain 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		MobilePurchaseService mpservice=new MobilePurchaseService();
		Scanner sc=new Scanner(System.in);
		int y;
		do 
		{
			System.out.println("1.INSERT MOBILE AND PURCHASE DETAILS");
			System.out.println("2.UPDATE MOBILE DETAILS");
			System.out.println("3.DELETE MOBILE DETAILS");
			System.out.println("4.SEARCH MOBILES");
			System.out.println("enter your choice:");
			int x=sc.nextInt();
			switch(x)
			{
				//insert mobile and purchase details
				case 1:	
				{
					mpservice.insertMobileAndPurchaseDetails();
					break;
				}	
				//update the mobile details
				case 2:
				{
					System.out.println("enter mobileid to update the record:"); 
					sc.nextLine();
					String mobileid=sc.nextLine();
					 mpservice.updateMobileQuantities(mobileid);
					 break;
				}
				//view the details
				case 3:	
				{
					System.out.println(mpservice.display());
					break;
				}
				//delete a mobile details based on id
				case 4:	System.out.println("enter id to delete the record:"); 
						int id=sc.nextInt(); 
						mpservice.delete(id);
						break;
						
				//search for any mobile using range of price
				case 5: mpservice.search();
						break;
				
				default:System.out.println("enter valid choice:");
			}
			
			System.out.println("enter 1 to continue 0 to exit:");
			y=sc.nextInt();
		}while(y==1);

	}

}
