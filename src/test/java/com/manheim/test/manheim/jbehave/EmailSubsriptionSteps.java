package com.manheim.test.manheim.jbehave;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.manheim.test.manheim.steps.EndUserSteps;

public class EmailSubsriptionSteps {
	
	public String emailString = "test@test.com";
	public String message = "Thanks! We will notify you of our new shoes at this email: " + emailString;

    @Steps
    EndUserSteps endUser;

    @Given("I am on shoestore-manheim")
    public void givenTheUserIsOnHomePage() {
        endUser.is_the_home_page();
    }

    @When("I enter valid e-mail in an area to submit email address and submit")
    public void whenTheUserEntersValidEmail() {
    	endUser.entersEmail(emailString);
    }
    
    @Then("I should get <Thanks! We will notify you of our new shoes at this email: users email> message")
    public void thenTheyShouldSeeValidResponse() {
    	endUser.verifyEmailSubscriptionMessage(message);
    }
}
