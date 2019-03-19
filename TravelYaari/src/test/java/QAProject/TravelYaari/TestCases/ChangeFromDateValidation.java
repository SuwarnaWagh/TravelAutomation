package QAProject.TravelYaari.TestCases;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import QAProject.TravelYaari.SearchBus;
import QAProject.TravelYaari.TestBase;

public class ChangeFromDateValidation extends TestBase {
	
	SearchBus searchbus = new SearchBus();
	@Test
	public void selectDate() throws InterruptedException {
		driver.get("https://www.travelyaari.com/");
		driver.findElement(By.id("from-city")).clear();
		driver.findElement(By.id("to-city")).clear();
		searchbus.enterFrom("Pune", driver);
		Thread.sleep(2000);
		searchbus.enterTo("Mumbai", driver);
		Thread.sleep(2000);
		searchbus.clickOnFromDate(driver, "26");
		searchbus.clickOnSearchBus(driver);
		Thread.sleep(2000);
		searchbus.getOperatorDetailsCountResult(driver);
		ArrayList<String> opratorName = searchbus.getOperatorDetails(driver);
		System.out.println(opratorName);
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
