package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties prop;
	
	public ReadConfig() {
		File src =new File("./resources/data.properties");
		
		try {
			FileInputStream Fis = new FileInputStream(src);
			prop =new Properties();
			try {
				prop.load(Fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public String getApplicationURL()
	{
		String url=prop.getProperty("browser");
		return url;
	}
	public String getEnvironmentName()
	{
		String Env=prop.getProperty("Environment");
		return Env;
	}
	public String getLoginUsername()
	{
		String LoginUname=prop.getProperty("Username");
		return LoginUname;
	}
	public String getLoginPassword()
	{
		String LoginPword=prop.getProperty("Password");
		return LoginPword;
	}
	

}
