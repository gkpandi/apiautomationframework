package automationframework.resources;

import java.io.FileInputStream;
import java.util.Properties;

public class Config {

	private static Config instance = new Config();
	
	private Properties properties;
	
	private Config()
	{
		properties = new Properties();
		try
		{
			String configFile = "src//test//java//com//fedex//shipment//automation//resources//global.properties";
			properties.load(new FileInputStream(configFile));
		}
		catch(Exception ex)
		{
			System.out.println("Error loading in property fie");
		}
	}
	
	public static Config getConfigs()
	{
		return instance;
	}
	
	public String getPropertyValue(String key)
	{
		return properties.getProperty(key);
	}
	
}
