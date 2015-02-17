package com.manheim.test.manheim.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@DefaultUrl("http://shoestore-manheim.rhcloud.com")
public class HomePage extends PageObject {

	@FindBy(id = "remind_email_input")
	public WebElement email;	

	@FindBy(xpath = "//*[@id='remind_email_form']/div/input[@type='submit']")
	public WebElement submitEmail;	

	@FindBy(id = "promo_code_input")
	public WebElement promoCode;	

	@FindBy(xpath = "//*[@id='promo_code_form']/div/input[@type='submit']")
	public WebElement submitPromoCode;	

	@FindBy(id = "brand")
	public WebElement brand;	

	@FindBy(id = "search_button")
	public WebElement search;
	
	@FindBy(id = "search_button")
	public WebElement emailResult;
	
	@FindBy(css = "#flash > div")
	public WebElement emailMessage;
	

    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    public WebElementFacade findMonthLink(String linktext) {
    	return this.element(By.linkText(linktext));
    }
    
    public void selectMonth(String month) {
    	findMonthLink(month).click();
    }

    public void enterEmail(String emailstring) {
        $(email).type(emailstring);
    }

    public void submitEmail() {
        $(submitEmail).click();
    }
    
    public void enterPromoCode(String promocode) {
        $(email).type(promocode);
    }

    public void submitPromoCode() {
        $(submitPromoCode).click();
    }
    
    public void selectBrand(String brandSelect) {
        $(brand).selectByValue(brandSelect);
    }

    public void searchByBrand() {
        $(search).click();
    }
    
    public Boolean verifyEmailMessage(String message) {
    	return emailMessage.getText().contains(message);
    }
}