package QAProject.TravelYaari.TestCases;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import QAProject.TravelYaari.SearchBus;
import QAProject.TravelYaari.TestBase;



public class FindBusWithMinPrice extends TestBase{
	SearchBus searchbus = new SearchBus();
	@Test
	public void getMinimumPriceDetails() throws InterruptedException {
		int min = Integer.MAX_VALUE;
		try {
			driver.get("https://www.travelyaari.com/");
			driver.findElement(By.id("from-city")).clear();
			driver.findElement(By.id("to-city")).clear();
			searchbus.enterFrom("Pune", driver);
			Thread.sleep(2000);
			searchbus.enterTo("Mumbai", driver);
			searchbus.clickOnSearchBus(driver);
			ArrayList<String> p = searchbus.price(driver);
			for (int i = 0; i < p.size(); i++) {
				//System.out.println(p.get(i).toString());
				if (Integer.parseInt(p.get(i).toString()) < min) {
					min = Integer.parseInt(p.get(i).toString());
				}
			}
			System.out.println("Minimum price is = " + min);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in main");
		}
	}
	@AfterMethod
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
