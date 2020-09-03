package ParaBank.TestCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ParaBank.pages.LoginPage;
import ParaBank.testbase.BaseClass;

public class HomePage_TC03 extends BaseClass{

	LoginPage loginPage = new LoginPage();
	
	@Test
	public void OnlyUsername() {
		loginPage.enterUsername(driver, "absdwq");
		loginPage.submitLogin(driver);
		String ActualErrorMessage = loginPage.invalidUserNameErrorMessage(driver);
		//driver.findElement(By.name("username")).sendKeys("swara1");
		//driver.findElement(By.xpath("//input[@class='button']")).click();
		//String errorMessage = driver.findElement(By.xpath("//*[text()='Please enter a username and password.']")).getText();
		assertEquals(ActualErrorMessage, "Please enter a username and password.");
	}
	@Test
	public void OnlyPassword() {
		loginPage.enterPassword(driver, "12wqer");
		loginPage.submitLogin(driver);
		String ActualErrorMessage = loginPage.invalidUserNameErrorMessage(driver);
		/*driver.findElement(By.name("password")).sendKeys("Admin12");
		driver.findElement(By.xpath("//input[@class='button']")).click();
		String errorMessage = driver.findElement(By.xpath("//*[text()='Please enter a username and password.']")).getText();*/
		assertEquals(ActualErrorMessage, "Please enter a username and password.");
	}
	@Test
	public void InvalidUserNamePassword() {
		loginPage.enterUsername(driver, "121212");
		loginPage.enterPassword(driver, "wqwqqw");
		loginPage.submitLogin(driver);
		String ActualErrorMessage = loginPage.invalidUsernamePasswordErrorMessage(driver);
		/*driver.findElement(By.name("username")).sendKeys("Swati");
		driver.findElement(By.name("password")).sendKeys("12345677Swat");
		driver.findElement(By.xpath("//input[@class='button']")).click();
		String errorMessage = driver.findElement(By.xpath("//*[text()='The username and password could not be verified.']")).getText();*/
		assertEquals(ActualErrorMessage, "The username and password could not be verified.");
	}
	@Test
	public void BlankUserNamePassword() {
		loginPage.enterUsername(driver, "");
		loginPage.enterPassword(driver, "");
		loginPage.submitLogin(driver);
		String ActualErrorMessage = loginPage.invalidUserNameErrorMessage(driver);
		/*driver.findElement(By.name("username")).sendKeys("");
		driver.findElement(By.name("password")).sendKeys("");
		driver.findElement(By.xpath("//input[@class='button']")).click();
		String errorMessage = driver.findElement(By.xpath("//*[text()='Please enter a username and password.']")).getText();*/
		assertEquals(ActualErrorMessage, "Please enter a username and password.");
	}
	@Test
	public void ValidUserNamePassword() {
		loginPage.enterUsername(driver, "swara");
		loginPage.enterPassword(driver, "Admin");
		loginPage.submitLogin(driver);
		/*driver.findElement(By.name("username")).sendKeys("swara");
		driver.findElement(By.name("password")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@class='button']")).click();*/
		assertEquals(driver.getTitle(), "ParaBank | Accounts Overview");
	}
}
