
	package testLayer;

	import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseAmazonClass;
import pompackage.PomAddress;
import pompackage.PomLogin;
import pompackage.PomOrder;

	public class YourAddressTest extends BaseAmazonClass {
		PomOrder order;
		PomLogin login;
		PomAddress address;
		public YourAddressTest()
		{
			super();
		}
		@BeforeMethod
		public void initsetup() {
			initiation();		
			login = new PomLogin();
			order = new PomOrder();	
			address = new PomAddress();
		}
		
		private void goToNewAddress()
		{
			login.initiateWeb();
			login.myAccountClick();
			login.Your_Address();
			address.New_Address();
		}
		
		@Test(priority=1)
		public void Open_NewAddress() {
			goToNewAddress();
		}
		@Test(priority=2)
		public void Your_Address_TC27_valid_Fullname() {
			goToNewAddress();
			address.Address_FullName("Priyanka");
		}
		
		@Test(priority=3)
		public void Your_Address_TC29_valid_Phonenumber() {
			goToNewAddress();
			address.Address_FullName("Priyanka");
			address.Address_Phonenumber("6752468985");
		}
		@Test(priority=4)
		public void Your_Address_TC31_Address (){
			goToNewAddress();
			address.Address_FullName("Priyanka");
			address.Address_Phonenumber("6752468985");
			address.Address_StreetAddress("Dixie");
		}
		@Test(priority=5)
		public void Your_Address_TC33_City() {
			goToNewAddress();
			address.Address_FullName("Priyanka");
			address.Address_Phonenumber("6752468985");
			address.Address_StreetAddress("Dixie");
			address.Address_City("Mississauga");
		}
		@Test(priority=6)
		public void Your_Address_TC34_Province_dropdown () {
			goToNewAddress();
			address.Address_FullName("Priyanka");
			address.Address_Phonenumber("6752468985");
			address.Address_StreetAddress("Dixie");
			address.Address_City("Mississauga");
			address.Address_Province("Ontario");	
		}
		@Test(priority=7)
		public void Your_Address_TC35_Valid_Postalcode() {
			goToNewAddress();
			address.Address_FullName("Priyanka");
			address.Address_Phonenumber("6752468985");
			address.Address_StreetAddress("Dixie");
			address.Address_City("Mississauga");
			address.Address_Province("Ontario");
			address.Address_Postal("K3J 2L8");
		}
		@Test(priority=8)
		public void Your_Address_TC37_Add_address_button() {
			goToNewAddress();
			address.Address_FullName("Priyanka");
			address.Address_Phonenumber("6752468985");
			address.Address_StreetAddress("Dixie");
			address.Address_City("Mississauga");
			address.Address_Province("Ontario");
			address.Address_Postal("K3J 2L8");
			address.Address_Addaddress();
		}
		@Test(priority=9)
		public void Your_Address_TC28_empty_Full_name() {
			goToNewAddress();
			address.Address_Phonenumber("6752468985");
			address.Address_StreetAddress("Dixie");
			address.Address_City("Mississauga");
			address.Address_Province("Ontario");
			address.Address_Postal("K3J 2L8");
			address.Address_Addaddress();
			address.Full_Name_Error();
		}
		
		@Test(priority = 10)
		public void Your_Address_TC30_Empty_Phonenumber() {
			goToNewAddress();
			address.Address_FullName("Priyanka");
			address.Address_StreetAddress("Dixie");
			address.Address_City("Mississauga");
			address.Address_Province("Ontario");
			address.Address_Postal("K3J 2L8");
			address.Address_Addaddress();
			address.Phone_Number_Error();
		}
		
		@AfterMethod
		public void close() {
			driver.close();
		}
	}

