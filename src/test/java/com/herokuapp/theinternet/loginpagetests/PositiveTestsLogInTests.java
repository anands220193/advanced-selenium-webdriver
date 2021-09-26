package com.herokuapp.theinternet.loginpagetests;

import Pages.LoginPage;
import Pages.SecureAreaPage;
import Pages.WelcomePage;
import base.TestUtilities;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTestsLogInTests extends TestUtilities {

	@Test
	public void logInTest() {
		log.info("Starting logIn test");

		// open main page
		WelcomePage welcomePage=new WelcomePage(driver,log);
		welcomePage.openPage();
		takeScreenShot("Welcome page opened");

		// Click on Form Authentication link
		LoginPage loginPage=welcomePage.clickFormAuthenticationLink();
		takeScreenShot("Login Page opened");

		//Add new cookie
		Cookie ck=new Cookie("username","tomsmith","the-internet.herokuapp.com","/",null);
		loginPage.setCookie(ck);

		// execute login
		SecureAreaPage secureAreaPage=loginPage.logIn("tomsmith","SuperSecretPassword!");
		takeScreenShot("Secure Area Page opened");

		//Get cookies
		String username=secureAreaPage.getCookie("username");
		log.info("Username Cookie :"+username);

		String session=secureAreaPage.getCookie("rack.session");
		log.info("Session Cookie :"+session);

		// verifications
		// new url
		Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());

		// log out button is visible
		Assert.assertTrue(secureAreaPage.isLogOutButtonVisible(),"LogOut Button is not visible");

		// Successful log in message
		String expectedSuccessMessage = "You logged into a secure area!";
		String actualSuccessMessage = secureAreaPage.getSuccessMessageText();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);

	}
}
