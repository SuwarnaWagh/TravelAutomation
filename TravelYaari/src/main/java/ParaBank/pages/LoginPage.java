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
}
