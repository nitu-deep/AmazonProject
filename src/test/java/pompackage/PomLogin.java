package pompackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basepackage.BaseAmazonClass;

public class PomLogin extends BaseAmazonClass {
	
	@FindBy(id="ap_email")
	WebElement username;
	@FindBy(id="ap_password")
	WebElement password;	
	@FindBy(id="continue")
	WebElement continueBtn;
	
	@FindBy(linkText="Your Account")
	WebElement myAccount;
	
	@FindBy(className="ya-card__whole-card-link")
	List<WebElement> YourAccounts_Items;
	
	WebElement Order;
	WebElement Payment;
	WebElement Address;
	
	public PomLogin()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void typeusername(String user) {
		username.sendKeys(user);
	}
	
	public void typepassword(String pass) {
		password.sendKeys(pass);
	}
		
	public String verify() {
		return driver.getTitle();
	}
	
	public void loginClick() {
		continueBtn.click();
	}
	
	public void myAccountClick() {
		myAccount.click();
	}
	
	public void Your_order() {
		Order = YourAccounts_Items.get(0);
		Order.click();
	}
	public void Your_Address() {
		Address = YourAccounts_Items.get(3);
		Address.click();
	}
	
	public void Your_Payment() {
		Payment = YourAccounts_Items.get(4);
		Payment.click();
	}
	
	public void initiateWeb()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Login steps
		typeusername(prop.getProperty("email"));
		loginClick();
		typepassword(prop.getProperty("password"));
		loginClick();
		
		// Wait for Window Security Popup to appear
        try {
            Thread.sleep(2000);  // Adjust sleep time if needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
		try {
			Robot robot = new Robot();
	        // Enter password
	        String password = prop.getProperty("pin");
	        for (char c : password.toCharArray()) {
	            robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
	            robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
	        }
	
	        // Press Enter to submit
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	
	    } catch (AWTException e) {
	        e.printStackTrace();
	    }
		
		//Find My Account List
		WebElement account_list = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList")));
		Actions action=new Actions(driver);
		action.moveToElement(account_list).build().perform();
	}
}
