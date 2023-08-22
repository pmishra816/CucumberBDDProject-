package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties properties;
	
	String path="Config.properties";
	
	//constructor
	public ReadConfig() throws IOException {
		properties=new Properties();
		
		FileInputStream fis = new FileInputStream(path);
		properties.load(fis);
		
	}
	
	public String getBrowser() {
		String value = properties.getProperty("browser");
		
		if(value!=null)
		{
			return value;
		}
		else
			throw new RuntimeException("Url not specified in config file");
	}

}
