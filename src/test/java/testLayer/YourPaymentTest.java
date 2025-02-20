package testLayer;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseAmazonClass;
import pompackage.PomAddress;
import pompackage.PomLogin;
import pompackage.PomOrder;
import pompackage.PomPayment;

public class YourPaymentTest extends BaseAmazonClass {
	PomOrder order;
	PomLogin login;
	PomAddress address;
	PomPayment payment;
	
	public YourPaymentTest()
	{
		super();
	}
	@BeforeMethod
	public void initsetup() {
		initiation();		
		login = new PomLogin();
		order = new PomOrder();	
		address = new PomAddress();
		payment=new PomPayment();
	}
	@Test(priority=1)
	public void Payment_Card_number() {
		login.initiateWeb();
		login.myAccountClick();
		payment.Your_Payment();
		payment.Add_A_Payment_Method();
		payment.Payment_CreditCard();
		payment.Payment_Cardnumber("5123456789012346");
	}
	@Test(priority=2)
	public void Payment_CardExpiry() {
		login.initiateWeb();
		login.myAccountClick();
		payment.Your_Payment();
		payment.Add_A_Payment_Method();
		payment.Payment_CreditCard();
		payment.Payment_Cardnumber("5123456789012346");
		payment.Payment_CardExpiry("0534");
	}
	@Test(priority=3)
	public void Payment_SecurityCode() {
		login.initiateWeb();
		login.myAccountClick();
		payment.Your_Payment();
		payment.Add_A_Payment_Method();
		payment.Payment_CreditCard();
		payment.Payment_Cardnumber("5123456789012346");
		payment.Payment_CardExpiry("0534");
	
		payment.Payment_Securitycode("100");
	}
	@Test(priority=4)
	public void Payment_Cardname() {
		login.initiateWeb();
		login.myAccountClick();
		payment.Your_Payment();
		payment.Add_A_Payment_Method();
		payment.Payment_CreditCard();
		payment.Payment_Cardnumber("5123456789012346");
		payment.Payment_CardExpiry("0534");	
		payment.Payment_Securitycode("100");
		payment.Payment_Name("Sangeeta Gupta");
			}
	@Test(priority=5)
	public void Payment_Addandcontiune() {
	login.initiateWeb();
	login.myAccountClick();
	payment.Your_Payment();
	payment.Add_A_Payment_Method();
	payment.Payment_CreditCard();
	payment.Payment_Cardnumber("5123456789012346");
	payment.Payment_CardExpiry("0534");	
	payment.Payment_Securitycode("100");
	payment.Payment_Name("Sangeeta Gupta");
	payment.Payment_AddCardandcontinue();
	
	}
	@Test(priority=6)
	public void Payment_Cardnumber_error() {
	login.initiateWeb();
	login.myAccountClick();
	payment.Your_Payment();
	payment.Add_A_Payment_Method();
	payment.Payment_CreditCard();
	payment.Payment_Cardnumber("  ");
	payment.Payment_CardExpiry("0534");	
	payment.Payment_Error_Cardnumber();
}
}
