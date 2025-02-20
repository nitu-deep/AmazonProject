package pompackage;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;

import basepackage.BaseAmazonClass;

public class PomAddress extends BaseAmazonClass {
	@FindBy(className="ya-card__whole-card-link")
	List<WebElement> YourAccounts_Items;
	
	@FindBy(className ="add-new-address-button")
	WebElement NewAddress;
		
	@FindBy(id="address-ui-widgets-enterAddressFullName")
	WebElement FullName;
	
	@FindBy(id="address-ui-widgets-enterAddressPhoneNumber")
	WebElement PhoneNumber;
	@FindBy(id="address-ui-widgets-enterAddressLine1")
	WebElement StreetAddress;
	@FindBy(id="address-ui-widgets-enterAddressCity")
	WebElement City;
	@FindBy(id="address-ui-widgets-enterAddressPostalCode")
	WebElement PostalCode;
	@FindBy(id="address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId")
	WebElement Province;
	@FindBy(id="address-ui-widgets-form-submit-button")
	WebElement AddAddress;
	WebElement Address;
	
	@FindBy(className = "a-section")
	WebElement error;
	
	public PomAddress()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Your_Address() {
		Address = YourAccounts_Items.get(3);
		Address.click();
	}
	public void New_Address() {
		NewAddress.click();
	}
	public void Address_FullName(String Name) {
		FullName.sendKeys(Name);
	}
	
	public void Address_Phonenumber(String Number) {
		PhoneNumber.sendKeys(Number);
	}
	public void Address_StreetAddress(String Street) {
	StreetAddress.sendKeys(Street);
	}
	public void Address_City(String Cityname) {
		City.sendKeys(Cityname);
	}
	public void Address_Province(String setVal) {
		//Province.click();
		// Create a Select object
        Select select = new Select(Province);
        // Select an option by visible text
        select.selectByVisibleText(setVal);
        // Click on a specific option by visible text (e.g., "Option Text")
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            if (option.getText().equals(setVal)) {
                option.click();
                break;
            }
        }
	}
	public void Address_Postal(String PoCode) {
		PostalCode.click();
		PostalCode.sendKeys(PoCode);
	}
	public void Address_Addaddress() {
		AddAddress.click();
	}
	
	public void Full_Name_Error() {
		WebElement fullName = driver.findElement(By.xpath("//div[text()='Please enter a name.']"));
        System.out.println("Full Name Error: " + fullName.getText());
	}
	
	public void Phone_Number_Error() {
		WebElement phoneNumber = driver.findElement(By.xpath("//div[text()='Please enter a phone number so we can call if there are any issues with delivery.']"));
        System.out.println("Phone Number Error: " + phoneNumber.getText());
	}
	
}
