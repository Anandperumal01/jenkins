package testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeClass;

public class APITestBASE {
	public Properties prop;
	
	@BeforeClass
	public Properties setup() throws IOException {
		
		prop=new Properties();
		FileInputStream ip=new FileInputStream("D:\\September\\RestAssuredAutomation\\src\\test\\resources\\Properties\\Config.properties");
		prop.load(ip);
		
		return prop;
		
	}

}
