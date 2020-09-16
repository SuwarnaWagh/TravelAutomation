package ParaBank.TestCases;



import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import ParaBank.pages.LoginPage;
import ParaBank.pages.LoginPageOtherLinksNavigationPage;
import ParaBank.testbase.BaseClass;

public class LoginPageOtherLinksTest extends BaseClass {
	LoginPageOtherLinksNavigationPage otherlinks = new LoginPageOtherLinksNavigationPage();
	LoginPage loginPage = new LoginPage();
	@Test (priority=0)
	public void SolutionLink() {
		loginPage.enterUsername(driver, "Emma");
		loginPage.enterPassword(driver, "eWatson");
		loginPage.submitLogin(driver);
		otherlinks.solutionsTab(driver);
		String ActualTitle = otherlinks.getTitle(driver); 
		assertEquals(ActualTitle, "Accounts Overview");
	}
	
	@Test (priority=1)
	public void AboutUs() {
		//loginPage.enterUsername(driver, "Emma");
		//loginPage.enterPassword(driver, "eWatson");
		//loginPage.submitLogin(driver);
		String website = null,phone = null;
		otherlinks.aboutusTab(driver);
		String ActualTitle = otherlinks.getTitle(driver); 
		String paragraph=otherlinks.getParagraph(driver);
		String[] Splited = paragraph.split(" ");
		for(int i=0;i<Splited.length;i++) {
			if(Splited[i].length()>12 && Splited[i].substring(4,8).equals("www.")) {
				website=Splited[i].substring(4);
			}
			if(Splited[i].length()>=10 && Splited[i].substring(0,3).equals("888")) {
				phone=Splited[i];
			}
			
		}
		
		System.out.println("WEBSITE & PHONE NUMBER : "+ website +" "+phone);
		assertEquals(ActualTitle, "ParaSoft Demo Website");
		//assertEquals(website,"www.parasoft.com");
		//assertEquals(phone,"888-305-0041");
	}
	
	@Test (priority=1)
	public void Service() {
		otherlinks.servicesTab(driver);
		String ActualTitle = otherlinks.getHeading(driver); 
		List<WebElement> bookSoap = otherlinks.getBookSoapServices(driver);
		Iterator<WebElement> iter = bookSoap.iterator();

		// this will check whether list has some element or not
		while (iter.hasNext()) {

			// Iterate one by one
			WebElement item = iter.next();

			// get the text
			String label = item.getText();

			// print the text
			System.out.println(label);
		}
		List<WebElement> bookStore = otherlinks.getBookStoreServices(driver);
		Iterator<WebElement> iter1 = bookStore.iterator();

		// this will check whether list has some element or not
		while (iter1.hasNext()) {

			// Iterate one by one
			WebElement item = iter1.next();

			// get the text
			String label = item.getText();

			// print the text
			System.out.println(label);
		}
		List<WebElement> ParaBank = otherlinks.getParaBankServices(driver);
		Iterator<WebElement> iter2 = ParaBank.iterator();

		// this will check whether list has some element or not
		while (iter2.hasNext()) {

			// Iterate one by one
			WebElement item = iter2.next();

			// get the text
			String label = item.getText();

			// print the text
			System.out.println(label);
		}
		
		assertEquals(ActualTitle, "Available Bookstore SOAP services:");
		
		
	}
	@Test (priority=1)
	public void AdminPage() {
		otherlinks.AdminPage(driver);
		String ActualTitle = otherlinks.getTitle(driver);
		assertEquals(ActualTitle, "Administration");
	}
	@Test (priority=1)
	public void Home() {
		otherlinks.homeLink(driver);
		String ActualTitle = otherlinks.getCaption(driver);
		assertEquals(ActualTitle,"ATM Services");
	}
	@Test (priority=1)
	public void ReadMore() {
	//	otherlinks.homeLink(driver);
		otherlinks.readMore(driver);
		String ActualTitle =otherlinks.getTitle(driver);
		assertEquals(ActualTitle,"ParaBank News");
	}
	
	@Test (priority=1)
	public void About() {
		otherlinks.aboutLink(driver);
		String ActualTitle = otherlinks.getTitle(driver); 
		assertEquals(ActualTitle, "ParaSoft Demo Website");
	}
	@Test (priority=1)
	public void Contact() {
		otherlinks.contact(driver);
		String ActualTitle=otherlinks.getTitle(driver);
		assertEquals(ActualTitle,"Customer Care");
		
	}
	@Test (priority=1)
	public void HomeFooter() {
		otherlinks.homeFooter(driver);
		String ActualTitle=otherlinks.getCaption(driver);
		assertEquals(ActualTitle,"ATM Services");
	}
	@Test (priority=1)
	public void AboutUsFooter() {
		otherlinks.aboutUsFooter(driver);
		String ActualTitle = otherlinks.getTitle(driver); 
		assertEquals(ActualTitle, "ParaSoft Demo Website");
	}
	@Test (priority=1)
	public void ServicesFooter() {
		otherlinks.servicesFooter(driver);
		String ActualTitle = otherlinks.getHeading(driver); 
		assertEquals(ActualTitle, "Available Bookstore SOAP services:");
	}
	@Test (priority =1)
	public void siteMapeFooter() {
		otherlinks.siteMapFooter(driver);
		String ActualTitle=otherlinks.getSiteMapTitle(driver);
		assertEquals(ActualTitle,"Solutions");
	}
	@Test (priority=1)
	public void contactUsFooter() {
		otherlinks.contactUsFooter(driver);
		String ActualTitle=otherlinks.getTitle(driver);
		assertEquals(ActualTitle,"Customer Care");	
	}
	
}
