package ParaBank.testbase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath = "Configs//Configuation.properties";
	//private final String propertyFilePath = "I:\\GitRepository\\TravelAutomation\\TravelYaari\\Configs\\Configuation.properties";
			 //I:\GitRepository\TravelAutomation\TravelYaari\Configs
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}catch(FileNotFoundException ex) {
			System.out.println("Configuration.properties not found at "+propertyFilePath);
		}
	}
	
	public String getDriverPath() {
		String driverPath = properties.getProperty("chromerdriverpath");
		if (driverPath != null) {
			return driverPath;
		} else {
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
		}
	}
	
	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public String getElementScreenshotPath() {
		String elePath = properties.getProperty("elementscreenshotpath");
		if (elePath != null) {
			return elePath;
		} else {
			throw new RuntimeException("elementscreenshotpath not specified in the Configuration.properties file.");
		}
	}
	public String getPageScreenshotPath() {
		String pagePath = properties.getProperty("pagescreenshotpath");
		if (pagePath != null) {
			return pagePath;
		} else {
			throw new RuntimeException("pagescreenshotpath not specified in the Configuration.properties file.");
		}
	}
}
