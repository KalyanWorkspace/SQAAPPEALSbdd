package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourServicesPage {
public WebDriver driver;
	
	public YourServicesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By yourservices = By.xpath("//h3[@class='giga primary-font-light push--bottom']");

	public WebElement yourServices()
	{
		return driver.findElement(yourservices);
	}
	

}
