package ParaBank.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	protected WebDriver driver;
	ConfigFileReader configFileReader;
	
	@BeforeClass
	public void setupApplication() {
		configFileReader= new ConfigFileReader();
		Reporter.log("----Browser Session Started----" , true);
		//DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		options.addArguments("disable-infobars");
		options.addArguments("--disable-notifications");
		options.setAcceptInsecureCerts(true);
		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		//capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void closeApplication()
	{
	  driver.quit();
	  Reporter.log("=====Browser Session End=====", true);
	}
	
}
