package ParaBank.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ParaBank.testbase.BaseClass;
import ParaBank.testbase.ConfigFileReader;

public class HomePage_TC01 extends BaseClass{
	//public WebDriver driver = null;
	boolean isDisplayed ;
	String caption = null;
	ConfigFileReader configFileReader;
	
	@Test
	public void Verify_PARA_BANK_logo_is_present_with_the_caption() throws InterruptedException {
		configFileReader = new ConfigFileReader();
		driver.get(configFileReader.getApplicationUrl());
		WebElement logo = driver.findElement(By.cssSelector("img[title='ParaBank']"));
		Thread.sleep(3000);
		isDisplayed = logo.isDisplayed();
		caption = driver.findElement(By.cssSelector("p.caption")).getText();
		System.out.println("Result is " + isDisplayed + " & caption is " + caption);
		
	}

  @AfterMethod
  public void afterMethod() {
	  Assert.assertEquals(isDisplayed, true);
	  Assert.assertEquals(caption, "Experience the difference");
  }

}
