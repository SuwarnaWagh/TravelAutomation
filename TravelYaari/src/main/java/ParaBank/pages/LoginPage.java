package ParaBank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public void enterUsername(WebDriver driver,String username) {
		driver.findElement(By.name("username")).sendKeys(username);
	}
	public void enterPassword(WebDriver driver,String pwd) {
		driver.findElement(By.name("password")).sendKeys(pwd);
	}
	public void submitLogin(WebDriver driver) {
		driver.findElement(By.xpath("//input[@class='button']")).click();
	}
	public String invalidUserNameErrorMessage(WebDriver driver) {
		return driver.findElement(By.xpath("//*[text()='Please enter a username and password.']")).getText();
	}
	public String invalidPasswordErrorMessage(WebDriver driver) {
		return driver.findElement(By.xpath("//*[text()='Please enter a username and password.']")).getText();
	}
	public String invalidUsernamePasswordErrorMessage(WebDriver driver) {
		return driver.findElement(By.xpath("//*[text()='The username and password could not be verified.']")).getText();
	}
	public String blankUsernamePasswordErrorMessage(WebDriver driver) {
		return driver.findElement(By.xpath("//*[text()='Please enter a username and password.']")).getText();
	}
	public void clickOnRegister(WebDriver driver) {
		driver.findElement(By.xpath("//*[text()='Register']")).click();
	}
	public void forgotLoginInfo(WebDriver driver) {
		driver.findElement(By.xpath("//*[text()='Forgot login info?']")).click();
	}
	public void clickOnSolution(WebDriver driver) {
		driver.findElement(By.xpath("//*[text()='//*[text()='Solutions']")).click();
	}
	public void clickOnAboutUs(WebDriver driver) {
		driver.findElement(By.xpath("//*[text()='About Us']")).click();
	}
	public void clickOnServices(WebDriver driver) {
		driver.findElement(By.xpath("//*[text()='Services']")).click();
	}
	public void clickOnProducts(WebDriver driver) {
		driver.findElement(By.xpath("//*[text()='Products']")).click();
	}
	public void clickOnLocations(WebDriver driver) {
		driver.findElement(By.xpath("//*[text()='Locations']")).click();
	}
	public void clickOnAdminPage(WebDriver driver) {
		driver.findElement(By.xpath("//*[text()='Admin Page']")).click();
	}
	public void clickOnParaBankIsNowReOpened(WebDriver driver) {
		driver.findElement(By.xpath("")).click();
	}
	public void clickOnNewOnlineBillPay(WebDriver driver) {
		driver.findElement(By.xpath("")).click();
	}
	public void clickOnNewOnlineAccountTransfers(WebDriver driver) {
		driver.findElement(By.xpath("")).click();
	}
	public void clickOnREADMORE(WebDriver driver) {
		driver.findElement(By.xpath("")).click();
	}

	public void clickOnWithdrawFunds(WebDriver driver) {
		driver.findElement(By.xpath("")).click();
	}
	public void clickOnTransferFundsViaOnlineServices(WebDriver driver) {
		driver.findElement(By.xpath("")).click();
	}
	public void clickOnCheckBalances(WebDriver driver) {
		driver.findElement(By.xpath("")).click();
	}
	public void clickOnMakeDeposits(WebDriver driver) {
		driver.findElement(By.xpath("")).click();
	}
	public void clickOnBillPay(WebDriver driver) {
		driver.findElement(By.xpath("")).click();
	}
	public void clickOnAccountHistory(WebDriver driver) {
		driver.findElement(By.xpath("")).click();
	}
	public void clickOnTransferFundsViaATMServices(WebDriver driver) {
		driver.findElement(By.xpath("")).click();
	}
	public void clickOnFooterHome(WebDriver driver) {
		driver.findElement(By.xpath("")).click();
	}
	public void clickOnFooterAboutUs(WebDriver driver) {
		driver.findElement(By.xpath("")).click();
	}
	public void clickOnFooterServices(WebDriver driver) {
		driver.findElement(By.xpath("")).click();
	}
	public void clickOnFooterProducts(WebDriver driver) {
		driver.findElement(By.xpath("")).click();
	}
	public void clickOnFooterLocations(WebDriver driver) {
		driver.findElement(By.xpath("")).click();
	}
	public void clickOnFooterForum(WebDriver driver) {
		driver.findElement(By.xpath("")).click();
	}
	public void clickOnFooterSiteMap(WebDriver driver) {
		driver.findElement(By.xpath("")).click();
	}
	public void clickOnFooterContactUs(WebDriver driver) {
		driver.findElement(By.xpath("")).click();
	}
	public void clickOnHomeOrangeButton(WebDriver driver) {
		driver.findElement(By.xpath("")).click();
	}
	public void clickOnAboutOrangeButton(WebDriver driver) {
		driver.findElement(By.xpath("")).click();
	}
	public void clickOnContactOrangeButton(WebDriver driver) {
		driver.findElement(By.xpath("")).click();
	}
}
