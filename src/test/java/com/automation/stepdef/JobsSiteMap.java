package com.automation.stepdef;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import com.automation.base.Base;
import com.automation.framework.Elements;
import com.automation.pages.JobsSiteMapPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class JobsSiteMap extends Base {

	JobsSiteMapPage scenA = new JobsSiteMapPage();

    @Given("^I launched the application$")
    public void i_launch_the_application() throws Throwable {
		Base.driver.get(Base.reader.getUrl());
		Thread.sleep(2000);
		System.out.println("Launch the application");
		Thread.sleep(2000);
		String title=Base.driver.getTitle();
		Thread.sleep(2000);
		System.out.println(title);
	}

    @Then("^I will fetch the URL$")
    public void i_will_fetch_the_url() throws Throwable {
    
	
		List<WebElement> jobLinks =driver.findElements(By.tagName("loc"));
		
		List<String> texts = new ArrayList<String>();
		
		for (WebElement element : jobLinks) {
		    texts.add(element.getText());
		}
	
		for(String text:texts) {

		System.out.println(text);
		    Base.driver.get(text);
			
		}
	}
		
		
    }
    

    

