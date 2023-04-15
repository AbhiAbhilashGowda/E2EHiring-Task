package com.automation.stepdef;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;

import com.automation.base.Base;
import com.automation.framework.Elements;
import com.automation.pages.RegisterPage;
import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Register extends Base {

	RegisterPage scenA = new RegisterPage();
	Faker fkobj = new Faker();

	@Given("^I launch application$")
	public void i_launch_the_application() throws InterruptedException {

		Base.driver.get(Base.reader.getUrl());
		Thread.sleep(2000);
		System.out.println("Launch the application");
	}

	@Then("I click on Register")
	public void i_click_on_register() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(2000);
		Elements.click(RegisterPage.clickonRegister);
		Thread.sleep(3000);
	} 

	@Then("^I enter first name$")
	public void i_enter_first_name() throws Throwable {
		Elements.click(RegisterPage.enterFirstName);

		String firstName = fkobj.name().firstName();
		System.err.println(firstName);
		Elements.TypeText(RegisterPage.enterFirstName, firstName);

		Thread.sleep(4000);

	}

	@Then("^I enter last name$")
	public void i_enter_last_name() throws Throwable {
		Elements.click(RegisterPage.enterLastName);
		String lastName = fkobj.name().lastName();
		System.err.println(lastName);
		Elements.TypeText(RegisterPage.enterLastName, lastName);
		Thread.sleep(2000);

	}

	@Then("I open new TAB enter URl")
	public void i_open_new_tab_enter_u_rl() throws Throwable {
//		Thread.sleep(2000);
//		Base.driver.switchTo().newWindow(WindowType.TAB);
//		Thread.sleep(2000);
//		Base.driver.get("https://www.mail7.io/");
//		Thread.sleep(2000);
//	
//		Elements.click(RegisterPage.clickonCreateEmail);
//		Thread.sleep(2000);
//		Elements.click(RegisterPage.clickonOpenInbox);
	}

	@Then("^I enter New emailid$")
	public void i_enter_new_emailid() throws Throwable {
		Thread.sleep(2000);
		Elements.click(RegisterPage.enterRandomEmail);
		Thread.sleep(2000);
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		WebElement upload = Base.driver.findElement(By.xpath("//input[@placeholder='Email ID']"));
		    upload.sendKeys("username" + randomInt + "@mail7.io");
		   // WebElement enteredmail=upload;
		    
		Thread.sleep(3000);
		Base.driver.findElement(By.xpath("//input[@placeholder='Email ID']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(2000);
		Base.driver.findElement(By.xpath("//input[@placeholder='Email ID']")).sendKeys(Keys.chord(Keys.CONTROL, "c"));

	}

	@Then("^I enter New password \"([^\"]*)\"$")
	public void i_enter_new_password_something(String pass) throws Throwable {
		Thread.sleep(2000);
		Elements.TypeText(RegisterPage.enterNewPassword, pass);
		Thread.sleep(2000);

	}

	@Then("^I click on Register button$")
	public void i_click_on_register_button() throws Throwable {
		Thread.sleep(2000);
		Elements.click(RegisterPage.clickRegisterforRegisteration);
		Thread.sleep(200);
		Base.driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(200);
		Base.driver.get("https://www.mail7.io/");
		Thread.sleep(3000);
		Elements.click(RegisterPage.lounchinginbox);
		//Elements.TypeText(RegisterPage.lounchinginbox, upload);
		Thread.sleep(2000);
		Base.driver.findElement(By.xpath("(//input[@name='username'])[1]")).sendKeys(Keys.chord(Keys.CONTROL, "v"));
		Thread.sleep(200);
		Elements.click(RegisterPage.gotoInbox);
		Thread.sleep(4000);
//		//Elements.click(RegisterPage.clickonPasteEmail);
//		Thread.sleep(2000);
//		Elements.clearTxtBox(RegisterPage.clickonPasteEmail);
//		Thread.sleep(200);
//		//Base.driver.findElement(By.xpath("//input[@id='deusername']")).sendKeys(Keys.chord(Keys.CONTROL,"v"));
//		Thread.sleep(2000);
//		Elements.click(RegisterPage.clickonRefresh);
//		Thread.sleep(5000);
		Elements.click(RegisterPage.clickonE2eInbox);
		Thread.sleep(5000);
		Base.driver.switchTo().frame(0);
		Actions act = new Actions(Base.driver);
		WebElement element = Base.driver.findElement(By.cssSelector("tbody tr td span"));
		act.doubleClick(element).build().perform();
		Thread.sleep(2000);
		// element.getText();
		// System.out.println("the otp is:"+element);
		WebElement otp = Base.driver.findElement(By.xpath("//body[1]/table[1]/tbody[1]/tr[3]/td[1]"));
		String verify = otp.getText();

		// .sendKeys(Keys.chord(Keys.CONTROL,"c"));
		Thread.sleep(2000);
		System.out.println(verify);
		System.err.println(verify);
		Thread.sleep(2000);
		Set<String> allWindows = Base.driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindows);
		Base.driver.switchTo().window(tabs.get(0));
		Elements.TypeText(RegisterPage.passotp, verify);
		Thread.sleep(2000);

		Elements.click(RegisterPage.verifyOtp);
		Thread.sleep(3000);

	}

}