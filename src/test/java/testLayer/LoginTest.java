package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseAmazonClass;
import pompackage.PomLogin;

public class LoginTest extends BaseAmazonClass {
	PomLogin log;
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void initsetup() {
		initiation();		
		log = new PomLogin();	
	}
	
	@Test(priority = 1)
	public void Create_Account_TC13_Sign_in_button() {
		String actual = log.verify();
		Assert.assertEquals(actual, "Amazon Sign In");
	}
	@Test(priority = 2)
	public void Create_Account_TC14_Valid_email_id () {
		log.typeusername(prop.getProperty("email"));
		log.loginClick();
	}
		//Wrong or invalid e-mail address or mobile phone number. Please correct it and try again.
	@Test(priority = 4)
	public void Create_Account_TC15_invalid_email_id () {
		log.typeusername("email");
		log.loginClick();
	}
	@Test(priority = 3)
	public void Create_Account_TC18_Correct_Password () {
		log.typeusername(prop.getProperty("email"));
		log.loginClick();
		log.typepassword(prop.getProperty("password"));
		log.loginClick();
	}
	@Test(priority = 5)
	public void Create_Account_TC19_InCorrect_Password () {
		log.typeusername(prop.getProperty("email"));
		log.loginClick();
		log.typepassword("abcd");
		log.loginClick();
	}
	@AfterMethod
	public void close() {
		driver.close();
	}

}
