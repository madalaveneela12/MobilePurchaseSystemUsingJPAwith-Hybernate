package hani.com.entity;
import jakarta.persistence.Entity;


import jakarta.persistence.*;

@Entity                  //to create table in database
public class PurchaseDetails
{
	@Id
	
	int purchaseid;
	String cname;
	String mailid;
	String phoneno;
	String purchasedate;
	String mobileid;
	@OneToOne(cascade=CascadeType.ALL)                          //create foreign key
	@JoinColumn(name="mobiles_mobileid",referencedColumnName="mobileid")
	private Mobiles mobiles;
	//getter and setter methods
	public int getPurchaseid() {
		return purchaseid;
	}
	public void setPurchaseid(int purchaseid) {
		this.purchaseid = purchaseid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getPurchasedate() {
		return purchasedate;
	}
	public void setPurchasedate(String purchasedate) {
		this.purchasedate = purchasedate;
	}
	public String getMobileid() {
		return mobileid;
	}
	public void setMobileid(String mobileid) {
		this.mobileid = mobileid;
	}
	public Mobiles getMobiles() {
		return mobiles;
	}
	public void setMobiles(Mobiles mobiles) {
		this.mobiles = mobiles;
	}
	//parameterized constructor
	public PurchaseDetails(int purchaseid, String cname, String mailid, String phoneno, String purchasedate,
			String mobileid, Mobiles mobiles) {
		super();
		this.purchaseid = purchaseid;
		this.cname = cname;
		this.mailid = mailid;
		this.phoneno = phoneno;
		this.purchasedate = purchasedate;
		this.mobileid = mobileid;
		this.mobiles = mobiles;
	}
	@Override
	public String toString() {
		return "PurchaseDetails [purchaseid=" + purchaseid + ", cname=" + cname + ", mailid=" + mailid + ", phoneno="
				+ phoneno + ", purchasedate=" + purchasedate + ", mobileid=" + mobileid + ", mobiles=" + mobiles + "]";
	}
	//default constructor
	public PurchaseDetails()
	{
		
	}
	
	
	
	
	
	
}
