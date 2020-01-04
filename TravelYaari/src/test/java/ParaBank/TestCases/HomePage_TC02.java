package ParaBank.TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import ParaBank.testbase.BaseClass;
import ParaBank.testbase.ConfigFileReader;

public class HomePage_TC02 extends BaseClass{

	//public WebDriver driver = null;
	String titleDisplayed = null;
	ConfigFileReader configFileReader;
	
	@Test
	public void TitleOfThePageClickingOnPARABANKlogo() {
		configFileReader= new ConfigFileReader();
		driver.get(configFileReader.getApplicationUrl());
		driver.findElement(By.cssSelector("img[title='ParaBank']")).click();
		titleDisplayed = driver.getTitle();
		System.out.println("Title is "+titleDisplayed);
	}


	@AfterMethod
	public void afterMethod() {
		Assert.assertEquals(titleDisplayed, "ParaBank | Welcome | Online Banking");		
	}

}
