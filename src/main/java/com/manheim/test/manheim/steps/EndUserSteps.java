package com.manheim.test.manheim.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import static org.fest.assertions.Assertions.assertThat;

import com.manheim.test.manheim.pages.HomePage;
import com.manheim.test.manheim.pages.MonthPage;

@SuppressWarnings("serial")
public class EndUserSteps extends ScenarioSteps {

    HomePage homePage;
    
    MonthPage monthPage;

    public EndUserSteps(Pages pages) {
        super(pages);
    }

    @Step
    public void entersEmail(String emailString) {
        homePage.enterEmail(emailString);
        homePage.submitEmail();
    }

    @Step
    public void verifyEmailSubscriptionMessage(String emailMessage) {
    	assertThat(homePage.verifyEmailMessage(emailMessage)).isTrue();
    }

    @Step
    public void selectMonth(String monthLinkText) {
    	homePage.selectMonth(monthLinkText);
    }

    @Step
    public void is_the_home_page() {
        homePage.open();
    }
    
    @Step
    public void verifyBlurb(String blurb, int index) {
    	assertThat(monthPage.verifyShoeDescription(blurb,index)).isTrue();
    }
    
    @Step
    public void verifyImage(String image, int index) {
    	assertThat(monthPage.verifyShoeImage(image,index)).isTrue();
    }
    
    @Step
    public void verifyPrice(String price, int index) {
    	assertThat(monthPage.verifyShoePrice(price,index)).isTrue();
    }
    
    @Step
    public void verifyNoResultsOnPage() {
    	assertThat(monthPage.shoesCount()).isLessThanOrEqualTo(0);
    }
}

