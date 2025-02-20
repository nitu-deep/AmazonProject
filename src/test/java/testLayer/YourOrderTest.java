package testLayer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseAmazonClass;
import pompackage.PomLogin;
import pompackage.PomOrder;

public class YourOrderTest extends BaseAmazonClass {
	PomOrder order;
	PomLogin login;
	public YourOrderTest()
	{
		super();
	}
	
	@BeforeMethod
	public void initsetup() {
		initiation();		
		login = new PomLogin();
		order = new PomOrder();	
	}
	
	@Test(priority=1)
	public void Your_order_TC24_Different_options () {
		login.initiateWeb();
		login.myAccountClick();
		login.Your_order();
	}
	
	@Test(priority=2)
	public void Your_order_TC56_Buy_again() {
		login.initiateWeb();
		login.myAccountClick();
		login.Your_order();
		
		order.Buy_Again();
	}
	
	@Test(priority=3)
	public void Your_order_TC57_Notyetshipped() {
		login.initiateWeb();
		login.myAccountClick();
		login.Your_order();
		
		order.Not_Shipped();
	}
	
	@Test(priority=4)
	public void Your_order_TC58_CancelledOrder() {
		login.initiateWeb();
		login.myAccountClick();
		login.Your_order();
		
		order.Cancelled_Order();
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
}
