package QAProject.TravelYaari;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchBus {
	public ArrayList<String> price = new ArrayList<String>();
	
	public void enterFrom(String from, WebDriver driver) {
		Actions act;
		act = new Actions(driver);
		driver.findElement(By.id("from-city")).sendKeys(from);
		act.sendKeys(Keys.TAB).build().perform();
	}

	public void enterTo(String to, WebDriver driver) {
		driver.findElement(By.id("to-city")).sendKeys(to);
		// act.sendKeys(Keys.TAB).build().perform();
	}	

	public void clickOnSearchBus(WebDriver driver) {
		// driver.findElement(By.xpath("//button[text()='SEARCH BUS']")).click();
		isElementPresent(driver.findElement(By.xpath("//button[text()='SEARCH BUS']")));
	}
	
	public void clickOnFromDate(WebDriver driver, String dteStr) {
		driver.findElement(By.id("from-date")).click();//*[@class='pika-button pika-day']//button[@type='button']
		List<WebElement> dates = driver.findElements(By.xpath("//*[@type='button']"));
		for(int i = 0; i < dates.size(); i++) {
			if(dates.get(i).getText().equals(dteStr)) {
				dates.get(i).click();
				break;
			}
		}
		System.out.println("date selected");
		//isElementPresent(driver.findElement(By.xpath("//button[text()='SEARCH BUS']")));
	}

	public ArrayList<String> price(WebDriver driver) {
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='fare-st-blk']/div[@class='dark-txt']"));
		for (int i = 0; i < list.size(); i++) {
			// System.out.println(list.get(i).getText());
			String str = list.get(i).getText();

			String str1 = str.replaceAll("\\s+", "");
			String str2 = str1.replaceAll("₹", "-");
			// System.out.println(str2.substring(1));
			if (str2.substring(1).contains("-")) {
				
				price.add(StringUtils.substringBefore(str2.substring(1), "-"));
			} else {
				price.add(str2.substring(1));
			}
		}
		return price;
	}

	public boolean isElementPresent(WebElement ele) {//*[@class='dark-txt']
		if (ele.isDisplayed()) {
			ele.click();
			return true;
		} else {
			return false;
		}
	}
	 public int getOperatorDetailsCountResult(WebDriver driver) {
		 List<WebElement> operatorName = driver.findElements(By.xpath("//*[@class='dark-txt']"));
		 System.out.println("Result shows operator are : "+operatorName.size());
		 return operatorName.size();
	 }
	 
	 public ArrayList<String> getOperatorDetails(WebDriver driver) {
		 ArrayList<String> oprtrName = new ArrayList<String>();
		 List<WebElement> operatorName = driver.findElements(By.xpath("//*[@class='dark-txt']"));
		 for(int i = 0; i < operatorName.size(); i++) {
			 oprtrName.add(operatorName.get(i).getText());
		 }
		 return oprtrName;
	 }
	 
}
