package com.sample.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sample.test.demo.HomePage;
import com.sample.test.demo.TestBase;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;

public class Features extends TestBase {

	
	HomePage homePage;
	
	
	public Features() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		homePage = new HomePage();
        PageFactory.initElements(driver, homePage);
	}
	
	
	@Test (priority=1)
	public void Title() {
		
		System.out.println("******* To verify order should be placed successfully *******");
		
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Pizza Order Form");  //Expected to PASS

	}

    @Test (priority=2)
    public void PizzaMenu() throws Throwable {
    	
    	HomePage.selectdDropDownList(PizzaTypes.LARE_NOTOPPINGS); 
    	Thread.sleep(3000);
   
    	
}
    
    @Test (priority=3)
    public void ToppingsMenu1() throws InterruptedException {


    	homePage.ToppingsOneDropDownList(PizzaToppings.SALAMI);    //using with select function
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
    public void PickUpInformation() {
    	
    	homePage.PickUpInformation(Name, Email, PhoneNumber);
    	
    }
    
    @Test (priority=6)
    public void PaymentInfo() throws InterruptedException {
    	
    	boolean radiovalue = homePage.ccPayment().isSelected();

    	if (radiovalue==false)
    	homePage.ccPayment().click();
    	Thread.sleep(3000);
    	
    }
    

    @Test (priority=7)
    public void OrderPizza() throws InterruptedException {
     
    	scrollToElement(homePage.Orderbutton());
    	Thread.sleep(3000);
    	clickElement(homePage.Orderbutton());

    }
    
    
}
