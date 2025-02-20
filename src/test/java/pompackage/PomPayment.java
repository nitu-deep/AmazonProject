package pompackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basepackage.BaseAmazonClass;

public class PomPayment extends BaseAmazonClass{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	@FindBy(className="ya-card__whole-card-link")
	List<WebElement> YourAccounts_Items;
	WebElement Payment;
	
	
	
	@FindBy(linkText = "Add a payment method")
	WebElement Add_Payment_Method;
	
	
	//@FindBy(className="css-11aywtz")
	List <WebElement> Card_items;
	WebElement Cardmonthdate;
	WebElement CardSecurityCode;
	WebElement NameonCard;
	WebElement CardNumber;
	@FindBy(className="css-18t94o4")
	WebElement AddCard;
	
	
	public PomPayment()
	{
		PageFactory.initElements(driver, this);
	}
	public void Your_Payment() {
		Payment = YourAccounts_Items.get(5);
		Payment.click();
	}
	public void Add_A_Payment_Method()
	{
		Add_Payment_Method.click();
	}
	public void Payment_CreditCard() {	
		WebElement addCardButton = wait.until(ExpectedConditions.refreshed(
		    ExpectedConditions.presenceOfElementLocated(By.id("apx-add-credit-card-action-test-id"))
		));
		addCardButton.click();
	}

	public void Payment_Cardnumber(String numb) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
		driver.switchTo().frame(iframe);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dialog = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='dialog']")));
		dialog.isDisplayed();

		Card_items = driver.findElements(By.className("css-11aywtz"));
		Card_items.get(0).sendKeys("5123456789012346");
	}
	public void Payment_Error_Cardnumber() {
		WebElement cardnumber = driver.findElement(By.xpath("//div[text()='Enter a valid card number']"));
        System.out.println("Card number Error: " + cardnumber.getText());
	}
	
	public void Payment_CardExpiry(String date) {
		Cardmonthdate=Card_items.get(1);
		Cardmonthdate.sendKeys(date);
	}
	public void Payment_Securitycode(String code) {
		CardSecurityCode=Card_items.get(2);
		CardSecurityCode.sendKeys(code);
	}
	public void Payment_Name(String name) {
		NameonCard=Card_items.get(3);
		NameonCard.sendKeys(name);
	}
	public void Payment_AddCardandcontinue() {
	AddCard.click();
}
}
