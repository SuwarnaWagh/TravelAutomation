package QAProject.TravelYaari;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestBase {
	protected WebDriver driver;
	//protected static Actions act;
	//ArrayList<String> price = new ArrayList<>();
	
	protected TestBase(){
		System.setProperty("webdriver.chrome.driver", "I:/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
}
