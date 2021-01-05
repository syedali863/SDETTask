package com.sample.test.demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.sample.test.demo.constants.Constants;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;

public class HomePage  extends TestBase{

	public WebDriver driver;

	@FindBy(id=Constants.DropDown_Pizza1)
	static WebElement Pizzadropdown;

	@FindBy(xpath = Constants.DropDown_Toppings1)
	WebElement Toppings;
	
	@FindBy(xpath = Constants.DropDown_Toppings2)
	WebElement Toppings2;
		
	@FindBy(id = Constants.NameField)
	WebElement Emails;
	
	@FindBy(id = Constants.EmailField)
	WebElement Names;
	
	@FindBy(id = Constants.PhoneField)
	WebElement Phones;
	
	@FindBy(xpath = Constants.MissingDialog)
	WebElement MissingDialog;
	
	@FindBy(xpath = Constants.Dialog_Close)
	WebElement DialogClose;
	
	@FindBy(id = Constants.Order_Button)
	WebElement OrderButton;
	
	@FindBy(id = Constants.Pizza_Quantity)
	WebElement PizzaQuantity;

	@FindBy(id = Constants.ccPayment)
	WebElement cPayment;
	
	
	public static  WebElement verifyDropDownPizza(){
		return Pizzadropdown;
	}
	
	public WebElement Toppings(){
		return Toppings;
	}
	
	public WebElement ToppingsTwo(){
		return Toppings2;
	}
	
	public WebElement verifyMissingDialog(){
		return MissingDialog;
	}
	
	public WebElement verifyDialogClose(){
		return DialogClose;
	}
	
	public WebElement Orderbutton(){
		return OrderButton;
	}
	
	public WebElement PizzaQuantity(){
		return PizzaQuantity;
	}
	
	public WebElement ccPayment(){
		return cPayment;
	}
	
	
	
	
	  @SuppressWarnings("unlikely-arg-type")
	public static void selectdDropDownList(PizzaTypes toppings) {
	  
	  
	  
	  Select pizza = new Select(verifyDropDownPizza());
	  
	  List<WebElement> Selectpizza= pizza.getOptions();
	  
	  System.out.println(Selectpizza.size()+"\n");
	  
	  int totalsize = Selectpizza.size()-1;
	  
	  System.out.println("Total size of pizza list " +totalsize+"\n");
	  
	  
	  for (int i =0; i<Selectpizza.size(); i++) {
	  
	  String Pizz = Selectpizza.get(i).getText(); 
	  System.out.println(Pizz);
	  System.out.println(toppings.getDisplayName());
	  
	  
	  if (Selectpizza.get(i).getAttribute("value").equals(toppings.getDisplayName())) {
	  
	  
	  Selectpizza.get(i).click();
	  
	  
	  break; 
	  
	  } }
	  
	  
	  }
	 
		
	
	public void ToppingsOneDropDownList(PizzaToppings toppings) {

		
		Select top = new Select(Toppings());

		List<WebElement> topp1= top.getOptions();
		int totalsize = topp1.size()-1;
		System.out.println("Total size of toppings list " +totalsize +"\n");
		
		for (int i =0; i<topp1.size(); i++) {
			
			
			String topp = topp1.get(i).getText();
			System.out.println(topp +"\n");
			
	
			if (topp.contains(toppings.getDisplayName())) {
					
				topp1.get(i).click();
				
				
				break;
				
			}
		}
	
}
	
	
	public void ToppingsTwoDropDown(PizzaToppings toppings) {

		
		Select topp = new Select(ToppingsTwo());

		List<WebElement> top= topp.getOptions();
		int totalsize = top.size()-1;
		System.out.println("Total size of toppings list " +totalsize +"\n");
		
		for (int i =0; i<top.size(); i++) {
			
			
			String topptwo = top.get(i).getText();
			
	
			if (topptwo.contains(toppings.getDisplayName())) {
					
				top.get(i).click();
				break;
				
			}
		}
	
}
	
	
	public void PickUpInformation(String name, String email, String number) {
		
			Names.sendKeys(name);
			Emails.sendKeys(email);
			Phones.sendKeys(number);
		
	}
	
	
}