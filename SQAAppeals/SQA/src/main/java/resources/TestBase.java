package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
	public  Properties OR =null;
	public static WebDriver driver = null;
	public  WebDriver initializeDriver() throws IOException
	{
		OR = new Properties();
		FileInputStream fis = new FileInputStream("C:\\WorkSpace\\SQAAppeals\\SQA\\src\\main\\java\\resources\\or.properties");	
		OR.load(fis);
		String BrowserName=OR.getProperty("browser");
		
		if (BrowserName.toUpperCase().equals("CHROME")){
			System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();		
			
	}
		if (BrowserName.toUpperCase().equals("FIREFOX"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		if (BrowserName.toUpperCase().equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Drivers\\chromedriver.exe");
			driver = new InternetExplorerDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
		
	}

}
