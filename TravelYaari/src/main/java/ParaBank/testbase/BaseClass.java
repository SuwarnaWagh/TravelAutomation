package ParaBank.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import ParaBank.utilities.EventDriver;

public class BaseClass {
	protected WebDriver wdriver;
	protected EventFiringWebDriver driver;
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
		wdriver = new ChromeDriver(options);
		driver = new EventFiringWebDriver(wdriver);
		EventDriver ed = new  EventDriver();
		driver.register(ed);
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
