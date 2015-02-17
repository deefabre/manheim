package com.manheim.test.manheim.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

@DefaultUrl("http://shoestore-manheim.rhcloud.com")
public class MonthPage extends PageObject {

	@FindBys({
	    @FindBy(css = "td.shoe_result_value.shoe_brand > a")
	    })
	    public List<WebElement> shoeBrandList;

	@FindBys({
	    @FindBy(css = "td.shoe_result_value.shoe_name")
	    })
	    public List<WebElement> shoeNameList;
	
	@FindBys({
	    @FindBy(css = "td.shoe_result_value.shoe_price")
	    })
	    public List<WebElement> shoePriceList;
	
	@FindBys({
	    @FindBy(css = "td.shoe_result_value.shoe_description")
	    })
	    public List<WebElement> shoeDescriptionList;
	
	@FindBys({
	    @FindBy(css = "td.shoe_result_value.shoe_release_month")
	    })
	    public List<WebElement> shoeReleaseMonth;
	
	@FindBys({
	    @FindBy(css = "tr.shoe_result_row > td.shoe_image > img")
	    })
	    public List<WebElement> shoeImageList;
	
    @FindBy(css="body > div.title > h2")
    private WebElement montResultsTitle;

    public MonthPage(WebDriver driver) {
        super(driver);
    }

    public Boolean verifyShoeBrand(String brand, int index) {
    	return shoeBrandList.get(index).getText().contains(brand);
    }
    
    public Boolean verifyShoeName(String name, int index) {
    	return shoeNameList.get(index).getText().contains(name);
    }
    
    public Boolean verifyShoePrice(String price, int index) {
    	return shoePriceList.get(index).getText().contains(price);
    }
    
    public Boolean verifyShoeDescription(String description, int index) {
    	return shoeDescriptionList.get(index).getText().contains(description);
    }
    
    public Boolean verifyShoeReleaseMonth(String month, int index) {
    	return shoeReleaseMonth.get(index).getText().contains(month);
    }
    
    public Boolean verifyMontResultsTitle(String title) {
    	return montResultsTitle.getText().contains(title);
    }
    
    public Boolean verifyShoeImage(String image, int index) {
    	return shoeImageList.get(index).getAttribute("src").contains(image);
    }
    
    public int shoesCount() {
    	
    	try {
    	     int i = shoeNameList.size();
    	     return i;
    	} catch (Exception e) {
    		return 0;
    	}
    }
}