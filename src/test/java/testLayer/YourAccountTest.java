package testLayer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseAmazonClass;
import pompackage.PomLogin;

public class YourAccountTest extends BaseAmazonClass {
	PomLogin log;
	@BeforeMethod
	public void initsetup() {
		initiation();		
		log = new PomLogin();	
	}
	
	@Test(priority=1)
	public void Your_Account_TC23_Sublist_Options() {
	
		log.initiateWeb();
		log.myAccountClick();
	}
		
	@Test(priority=2)
	public void Your_order_TC24_Different_options () {
		log.initiateWeb();
		log.myAccountClick();
		log.Your_order();
	}
	
	@Test(priority=3)
	public void Your_Address_TC25_Address_option() {
		log.initiateWeb();
		log.myAccountClick();
		log.Your_Address();
	}
	
	@Test(priority=4)
	public void Payment_TC39_Default_method() {
		log.initiateWeb();
		log.myAccountClick();
		log.Your_Payment();
	}
	@AfterMethod
	public void close() {
		driver.close();
	}
}