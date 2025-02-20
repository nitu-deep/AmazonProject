package basepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseAmazonClass {
	public static Properties prop=new Properties();
	public static WebDriver driver;
 
 	public BaseAmazonClass() {
 		try {
			 FileInputStream file=new FileInputStream("E:\\Pardeep\\Testing\\JAVA\\workspace\\AmazonProject\\src\\test\\java\\Environmentvariables\\Config.properties");
			 prop.load(file);
 		}
 		catch(FileNotFoundException e) {
 			e.printStackTrace();
 		}
 		catch(IOException a) {
 			a.printStackTrace();
 		}
 	}
 	
 	public static void initiation() {
		String browsername= prop.getProperty("browser");
		if (browsername.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--user-agent=YourCustomUserAgent");
			driver=new ChromeDriver(options);
		}
		else if(browsername.equals("firefox")){
			System.setProperty("webdriver.gecko.driver","geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get(prop.getProperty("url"));
 	}
}

