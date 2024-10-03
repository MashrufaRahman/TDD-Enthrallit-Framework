package pagesTest;
import org.testng.annotations.Test;

import baseUtil_7_26_2024.BaseClass;

public class HomePageTest extends BaseClass {

	@Test()
	public void clickLoginButtonTest() {
		homePage.clickLoginButton();
	}
	@Test
	public void clickAutomationButtonAndDirectToEnrollmentPageTest() {
		homePage.clickLoginButton();
		homePage.clickAutomationButtonAndDirectToEnrollmentPage();
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
	homePage.iAmDropDownValidation();
}
@Test
public void courseWishToEnrollValidationTest() {
	homePage.courseWishToEnrollValidation();
}
@Test
public void phoneNumberValidationTest() {
	homePage.phoneNumberValidation();
}
@Test
public void emailAddressValidationTest() {
	homePage.emailAddressValidation();
}
@Test
public void passwordValidationTest() {
	homePage.passwordValidation();
}
@Test
public void genderValidationTest() {
	homePage.genderValidation();
}

@Test
public void enrollmentValidationPage() {
	homePage.clickLoginButton();
	homePage.clickAutomationButtonAndDirectToEnrollmentPage();
	homePage.firstNameValidation();
	homePage.middleNameValidation();
	homePage.lastNameValidation();
}
	
}