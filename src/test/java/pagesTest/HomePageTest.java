package pagesTest;

import org.testng.annotations.Test;

import baseUtil_7_26_2024.BaseClass;

public class HomePageTest extends BaseClass {

	@Test()
	public void clickLoginButtonTest() {
		homePage.clickLoginButton();
	}

	@Test(groups = { "regressionTest" })
	public void clickAutomationButtonAndDirectToEnrollmentPageTest() {
		homePage.clickLoginButton();
		homePage.clickAutomationButtonAndDirectToEnrollmentPage();
	}

	// happy path
	@Test
	public void openApplicationAndSubmitButtonTest() {
		homePage.clickLoginButton();
		homePage.clickAutomationButtonAndDirectToEnrollmentPage();
		homePage.openApplicationAndSubmitButton();
	}

	@Test()
	public void firstNameValidationTest() {
		homePage.clickLoginButton();
		homePage.clickAutomationButtonAndDirectToEnrollmentPage();
		homePage.firstNameValidation();
	}

	@Test
	public void middleNameValidationTest() {
		homePage.clickLoginButton();
		homePage.clickAutomationButtonAndDirectToEnrollmentPage();
		homePage.middleNameValidation();
	}

	@Test
	public void lastNameValidationTest() {
		homePage.clickLoginButton();
		homePage.clickAutomationButtonAndDirectToEnrollmentPage();
		homePage.lastNameValidation();
	}

	@Test
	public void iAmDropDownValidationTest() {
		homePage.clickLoginButton();
		homePage.clickAutomationButtonAndDirectToEnrollmentPage();
		homePage.iAmDropDownValidation();
	}

	@Test
	public void courseWishToEnrollValidationTest() {
		homePage.clickLoginButton();
		homePage.clickAutomationButtonAndDirectToEnrollmentPage();
		homePage.courseWishToEnrollValidation();
	}

	@Test
	public void phoneNumberValidationTest() {
		homePage.clickLoginButton();
		homePage.clickAutomationButtonAndDirectToEnrollmentPage();
		homePage.phoneNumberValidation();
	}

	@Test
	public void emailAddressValidationTest() {
		homePage.clickLoginButton();
		homePage.clickAutomationButtonAndDirectToEnrollmentPage();
		homePage.emailAddressValidation();
	}

	@Test
	public void passwordValidationTest() {
		homePage.clickLoginButton();
		homePage.clickAutomationButtonAndDirectToEnrollmentPage();
		homePage.passwordValidation();
	}

	@Test
	public void genderValidationTest() {
		homePage.clickLoginButton();
		homePage.clickAutomationButtonAndDirectToEnrollmentPage();
		homePage.genderValidation();
	}

	@Test
	public void personalImageValidation() {
		homePage.clickLoginButton();
		homePage.clickAutomationButtonAndDirectToEnrollmentPage();
		homePage.personalImageValidation();
	}

	@Test
	public void photoIdValidationTest() {
		homePage.clickLoginButton();
		homePage.clickAutomationButtonAndDirectToEnrollmentPage();
		homePage.photoIdValidation();
	}

	@Test
	public void enrolementPageErrorMessageValidationTest() {
		homePage.clickLoginButton();
		homePage.clickAutomationButtonAndDirectToEnrollmentPage();
		homePage.enrolementPageErrorMessageValidation();
	}

}