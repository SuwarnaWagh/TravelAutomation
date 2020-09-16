package ParaBank.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageOtherLinksNavigationPage {
	
	public void solutionsTab(WebDriver driver) {
		driver.findElement(By.className("Solutions")).click();
	}
	public String getTitle(WebDriver driver) {
		return driver.findElement(By.className("title")).getText();
	}
	public void aboutusTab(WebDriver driver) {
		driver.findElement(By.linkText("About Us")).click();//a[contains(@href,'About Us')
	}
	public String getParagraph(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@id='rightPanel']/p[3]")).getText();
	}
	public void servicesTab(WebDriver driver) {
		driver.findElement(By.linkText("Services")).click();
	}
	public String getHeading(WebDriver driver) {
		return driver.findElement(By.className("heading")).getText();
	}
	public List<WebElement> getBookSoapServices(WebDriver driver) {
		List<WebElement> element = driver.findElements(By.xpath("//span[@class='porttypename']"));
		return element;
	}
	public List<WebElement> getBookStoreServices(WebDriver driver) {
		List <WebElement> element= new ArrayList <WebElement>();
		
		for(int i=1;i<=8;i++) {
			String xpathElement=null;
			xpathElement = "//table[2]//tr["+i+"]/td[1]";

			element.add(driver.findElement(By.xpath(xpathElement)));
		}
		
		return element;
	}
	public List<WebElement> getParaBankServices(WebDriver driver) {
		List <WebElement> element= new ArrayList <WebElement>();
		
		for(int i=1;i<=26;i++) {
			String xpathElement=null;
			xpathElement = "//table[4]//tr["+i+"]/td[1]";

			element.add(driver.findElement(By.xpath(xpathElement)));
		}
		
		return element;
	}
	
	
	public void productsTab(WebDriver driver) {
		driver.findElement(By.linkText("Products")).click();
	}
	public void Locations(WebDriver driver) {
		driver.findElement(By.linkText("Locations")).click();
	}
	public void AdminPage(WebDriver driver) {
		driver.findElement(By.linkText("Admin Page")).click();
	}
	public void homeLink(WebDriver driver) {
		driver.findElement(By.linkText("Home")).click();
	}
	public String getCaption(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@id='rightPanel']/ul[1]/li[1]")).getText();
	}
	public void aboutLink(WebDriver driver) {
		driver.findElement(By.linkText("about")).click();
	}
	public void contact(WebDriver driver) {
		driver.findElement(By.linkText("contact")).click();
	}
	public void readMore(WebDriver driver) {
		driver.findElement(By.xpath("//a[@href='news.htm']")).click();
	}
	public void homeFooter(WebDriver driver) {
		driver.findElement(By.xpath("//div[@id='footerPanel']//a[@href='/parabank/index.htm']")).click();
	}
	public void aboutUsFooter(WebDriver driver) {
		driver.findElement(By.xpath("//div[@id='footerPanel']//a[@href='about.htm']")).click();
	}
	public void servicesFooter(WebDriver driver) {
		driver.findElement(By.xpath("//div[@id='footerPanel']//a[@href='services.htm']")).click();
	}
	public void siteMapFooter(WebDriver driver) {
		driver.findElement(By.xpath("//div[@id='footerPanel']//a[@href='/parabank/sitemap.htm']")).click();
	}
	public String getSiteMapTitle(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@id='rightPanel']//li[@class='Solutions']")).getText();
	}
	public void contactUsFooter(WebDriver driver) {
		driver.findElement(By.xpath("//div[@id='footerPanel']//a[@href='contact.htm']")).click();
	}
	
}
