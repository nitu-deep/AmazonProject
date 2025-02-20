package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseAmazonClass;

public class PomOrder extends BaseAmazonClass {
	
	@FindBy(linkText=" Orders ")
	WebElement order;
	
	@FindBy(linkText="Buy Again")
	WebElement Buyagain;
	
	@FindBy(linkText="Not Yet Shipped")
	WebElement Notyetshipped;
	
	@FindBy(linkText="Cancelled Orders")
	WebElement Cancelled;
	
	public PomOrder()
	{
		PageFactory.initElements(driver, this);
	}
	public void Past_orders() {
		order.click();
	}
	public void Buy_Again() {
		Buyagain.click();
	}
	public void Not_Shipped() {
		Notyetshipped.click();
	}
	public void Cancelled_Order() {
		Cancelled.click();
	}
}