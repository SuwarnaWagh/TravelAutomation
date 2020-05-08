package ParaBank.TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import ParaBank.testbase.BaseClass;

public class HomePage_TC03 extends BaseClass{

	@Test
	public void TC03() {
		driver.findElement(By.xpath("//*[(text()='Admin Page')]")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@class='admin']")).click();
		
		
	}
}
