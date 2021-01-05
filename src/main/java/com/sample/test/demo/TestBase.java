package com.sample.test.demo;

import static org.testng.Assert.fail;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    private Configuration config;
    protected WebDriver driver;
    protected String Pagetitle;
    protected String Email;
    protected String PhoneNumber;
    protected String Name;
    
    protected String url;

    @BeforeClass(alwaysRun = true)
    public void init() throws Throwable {
        config = new Configuration();
        url = config.getUrl();
        Pagetitle=config.getTitle();
        Name=config.getName();
        Email=config.getEmail();
        PhoneNumber=config.getPhoneNumber();        
        initializelDriver();
        navigateToSite();
    }

    private void navigateToSite() {
        driver.get(url);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        try {
            driver.quit();

        } catch (Exception e) {
        }
    }

    private void initializelDriver() {
        if (config.getBrowser().equalsIgnoreCase("chrome")) {
            if (config.getPlatform().equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/mac/chromedriver");
            } else {
                System.setProperty("webdriver.chrome.driver",
                        "src/test/resources/chromedriver/windows/chromedriver.exe");
            }
            driver = new ChromeDriver();
        }
        else {
            fail("Unsupported bfrowser " + config.getBrowser());
        }
       
    }

    public Object executeScript(String script, Object...args){
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script,args);
	}
    
    public void clickElement(WebElement element){
		executeScript("arguments[0].click();", element);
		System.out.println("The Button is clicked");
	}
    
    public void scrollToElement(WebElement element){
		executeScript("window.scrollTo(arguments[0],arguments[1])",element.getLocation().x,element.getLocation().y);
		System.out.println("scroll to WebElement...");

	}
	
    
    public boolean isDisplayed(WebElement element){
		try{
			element.isDisplayed();
			System.out.println("element is Displayed..");
			
			return true;
		}
		catch(Exception e){
			System.out.println("element is not Displayed.."+e.getMessage());
			return false;
		}
	}
    
    public static void markFail(String message){
		System.out.println("Script FAIL.."+message);
		Assert.assertTrue(false, message);
	}
    
	
}
