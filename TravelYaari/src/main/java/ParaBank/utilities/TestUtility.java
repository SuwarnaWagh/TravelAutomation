package ParaBank.utilities;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ParaBank.testbase.ConfigFileReader;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TestUtility {
	ConfigFileReader configFileReader;

	public void takeScreenshot(WebDriver driver) {
		configFileReader = new ConfigFileReader();
		try {
			//Screenshot screenshot = new Ashot().takeScreenshot(driver); To take full page screenshot
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File(configFileReader.getPageScreenshotPath()+"Page_IMG"+System.currentTimeMillis()+".jpg"));
		}catch(Exception ex) {
			System.out.println("We found exception while taking screenshot");
		}
	}
	
	public void takeScreenshotOfElement(WebDriver driver, WebElement element) {
		configFileReader = new ConfigFileReader();
		Screenshot screenshot= new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver,element);

		try {
			ImageIO.write(screenshot.getImage(), "jpg", new File(configFileReader.getElementScreenshotPath()+"Ele_IMG"+System.currentTimeMillis()+".jpg"));//"c:\\ElementScreenshot.jpg"
		} catch (IOException e) {
			System.out.println("Exception in takeScreenshotOfElement");
		}
	}
	
/*	new File("c:\\ElementScreenshot.jpg")
	new File(filePath+"Page_IMG"+System.currentTimeMillis()+".jpg")
	I:\\Screenshots\\PageScreenshot\\Page_IMG001122.jpg*/
}
