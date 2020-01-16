package com.addigy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SignupPage1 extends BasePage1 {

	public SignupPage1(WebDriver driver) {
		super(driver);
	}

	WebElement firstName = driver.findElement(By.id("signup_firstname"));

	WebElement lastName = driver.findElement(By.id("signup_lastname"));

	WebElement businessEmail = driver.findElement(By.xpath("//*[@id=\"signup_email\"]"));

	WebElement companyName = driver.findElement(By.cssSelector("#signup_company"));

	Select country = new Select(driver.findElement(By.id("signup_country")));

	Select state = new Select(driver.findElement(By.id("signup_state")));

	WebElement signupButton = driver
			.findElement(By.xpath("//*[@id=\"page-container\"]/div[1]/div[2]/div/form[2]/div[4]/button"));

	public void signUp(String firstNameValue, String lastNameValue, String businessEmailvalue, String companyNameValue,
			String countryNameValue, String stateNameValue) {
		this.enterFirstName(firstNameValue);
		this.enterLastName(lastNameValue);
		this.enterBusinessEmail(businessEmailvalue);
		this.enterCompanyName(companyNameValue);
		this.selectCountry(countryNameValue);
		this.selectState(stateNameValue);
		this.clickSignupButton();
	}

	public void enterFirstName(String firstNameValue) {
		highLightElement(driver, firstName);
		firstName.sendKeys(firstNameValue);
	}

	public void enterLastName(String lastNameValue) {
		highLightElement(driver, lastName);
		lastName.sendKeys(lastNameValue);
	}

	public void enterBusinessEmail(String businessEmailvalue) {
		highLightElement(driver, businessEmail);
		businessEmail.sendKeys(businessEmailvalue);
	}

	public void enterCompanyName(String companyNameValue) {
		highLightElement(driver, companyName);
		companyName.sendKeys(companyNameValue);
	}

	public void selectCountry(String countryNameValue) {

		country.selectByVisibleText(countryNameValue);
	}

	public void selectState(String stateNameValue) {
		
		state.selectByVisibleText(stateNameValue);
	}

	public void clickSignupButton() {
		highLightElement(driver, signupButton);
		signupButton.click();
	}

	public void highLightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

	}

}
