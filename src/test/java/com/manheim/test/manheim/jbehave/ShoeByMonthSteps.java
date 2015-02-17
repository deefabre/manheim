package com.manheim.test.manheim.jbehave;

import java.util.Map;
import java.util.Map.Entry;

import static org.fest.assertions.Assertions.assertThat;

import net.thucydides.core.annotations.Steps;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.google.common.base.Splitter;
import com.manheim.test.manheim.steps.EndUserSteps;

public class ShoeByMonthSteps {

    @Steps
    EndUserSteps endUser;

    @When("I select a month for shoe release")
    public void whenTheUserSelectsMonth(@Named("month") String month) {
        endUser.selectMonth(month);
    }

    @Then("month should display a small Blurb of each shoe")
    public void thenMonthDisplayBlurb(@Named("blurb") String blurb) {
		if (!blurb.trim().isEmpty()) {
			Map<String, String> map = Splitter.on(';')
					.withKeyValueSeparator("=").split(blurb.trim());
			for (Entry<String, String> entry : map.entrySet()) {
				endUser.verifyBlurb(entry.getValue(),
						Integer.parseInt(entry.getKey()));
			}
		} else {
			endUser.verifyNoResultsOnPage();
		}
    }
    
    @Then("Month should display an image each shoe being released")
    public void thenMonthDisplayImage(@Named("image") String image) {
    	if (!image.trim().isEmpty()) {
			Map<String, String> map = Splitter.on(';')
					.withKeyValueSeparator("=").split(image.trim());
			for (Entry<String, String> entry : map.entrySet()) {
				endUser.verifyImage(entry.getValue(),
						Integer.parseInt(entry.getKey()));
			}
		} else {
			assertThat(true).isTrue();
		}
    }
    
    @Then("shoe should have a suggested price pricing")
    public void thenMonthDisplayPrice(@Named("price") String price) {
    	
    	if (!price.trim().isEmpty()) {
			Map<String, String> map = Splitter.on(';')
					.withKeyValueSeparator("=").split(price.trim());
			for (Entry<String, String> entry : map.entrySet()) {
				endUser.verifyPrice(entry.getValue(),
						Integer.parseInt(entry.getKey()));
			}
		} else {
			assertThat(true).isTrue();
		}
    }

}
