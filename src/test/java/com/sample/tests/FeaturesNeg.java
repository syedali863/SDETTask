package com.sample.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sample.test.demo.HomePage;
import com.sample.test.demo.TestBase;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;

public class FeaturesNeg extends TestBase {

	
	HomePage homePage;
	
	
	public FeaturesNeg() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		homePage = new HomePage();
        PageFactory.initElements(driver, homePage);
		
	}
	
	
	@Test (priority=1)
	public void Title() {
		
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Pizza Order");  //Expected to be Fail / It should Fail

	}

	 @Test (priority=2)
	    public void PizzaMenu() throws Throwable {
	    	
	    	HomePage.selectdDropDownList(PizzaTypes.LARE_NOTOPPINGS); 
	    	Thread.sleep(3000);
	   
	    	
	}
	    
	    @Test (priority=3)
	    public void ToppingsMenu1() throws InterruptedException {


	    	homePage.ToppingsOneDropDownList(PizzaToppings.SALAMI);    
	    	Thread.sleep(2000);
	}
	    
	    
	    @Test (priority=4)
	    public void ToppingsMenu2() throws InterruptedException {


	    	homePage.ToppingsTwoDropDown(PizzaToppings.OLIVES);
	    	Thread.sleep(2000); 
	    	
	    	homePage.PizzaQuantity().clear();
	    	homePage.PizzaQuantity().sendKeys("2");
	}
	    
    
    
    @Test (priority=5)
    public void PaymentInfo() throws InterruptedException {
    	
    	boolean radiovalue = homePage.ccPayment().isSelected();

    	if (radiovalue==false)
    	homePage.ccPayment().click();
    	Thread.sleep(3000);
    	
    }
    

    @Test (priority=6, description="Verifying dialog box should appear for missing fields ")
    public void OrderWithMissingInfo() throws InterruptedException {
    	
    	
    	
    	scrollToElement(homePage.Orderbutton());
    	Thread.sleep(3000);
    	clickElement(homePage.Orderbutton());
    	Thread.sleep(4000);
    	String modal = homePage.verifyMissingDialog().getText();
    	if (modal.contains("Missing")) {
    		System.out.println("modal dialog appeared with error message");
    		homePage.verifyDialogClose().click();
    		Thread.sleep(3000);
    		
    	} 
    
    }
    	
}
