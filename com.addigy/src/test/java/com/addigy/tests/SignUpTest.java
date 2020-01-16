package com.addigy.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.addigy.driverManager.DriverManager;
import com.addigy.driverManager.DriverManagerFactory;
import com.addigy.driverManager.DriverType;
import com.addigy.pages.SignupPage1;

public class SignUpTest {
	DriverManager driverManager;
	WebDriver driver;
	SignupPage1 signupPage;

	@BeforeClass
	public void navigateToSignUpPage() {
		driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
		driver = driverManager.getWebDriver();
		driver.get("https://dev.addigy.com/signup");
		Assert.assertEquals("Register | Addigy", driver.getTitle());

	}

	@Test
	public void signUpTest() {
		signupPage = new SignupPage1(driver);
		signupPage.signUp("Dilshat", "Yalkun", "dyalkun@company.com", "Diltek LLC", "United States", "Florida");
		System.out.println("Signup Page title is: " + driver.getTitle());
	}

	@Test(dependsOnMethods = "signUpTest")
	public void verifyConfirmationPage() throws InterruptedException {

		Thread.sleep(3000);
		String signUpConpageTitle = driver.getTitle();
		System.out.println("Confirmation Page Title Is :" + signUpConpageTitle);
		Assert.assertEquals(signUpConpageTitle, "Thank you | Addigy");

	}

	@AfterClass

	public void teardown() {

		driver.quit();

	}

}
