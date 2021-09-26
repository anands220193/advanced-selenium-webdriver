package alertstests;

import Pages.JavaScriptAlertsPage;
import Pages.WelcomePage;
import base.TestUtilities;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AlertsTests extends TestUtilities {

	@Test
	public void jsAlertTest() {
		SoftAssert softAssert = new SoftAssert();

		// open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();

		// Click on JavaScript Alerts link
		JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();

		// Click JS Alert button
		alertsPage.openJsAlert();


		// Get alert text
		String alertMessage = alertsPage.getAlertText();

		// Click OK button
		alertsPage.acceptAlert();

		// Get Results text
		String result = alertsPage.getResultText();

		// Verifications
		// 1 - Alert text is expected
		softAssert.assertTrue(alertMessage.equals("I am a JS Alert"),
				"Alert message is not expected. Should be 'I am a JS Alert', but it is '" + alertMessage + "'");

		// 2 - Result text is expected
		softAssert.assertTrue(result.equals("You successfully clicked an alert"),
				"result is not expected. Should be 'You successfully clicked an alert', but it is '" + result + "'");
		softAssert.assertAll();
	}

	@Test
	public void jsDismissTest() {
		SoftAssert softAssert = new SoftAssert();

		// open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();

		// Click on JavaScript Alerts link
		JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();

		// Click JS Confirm button
		alertsPage.openJsConfirm();

		// Get alert text
		String alertMessage = alertsPage.getAlertText();

		// Click Cancel button
		alertsPage.dismissAlert();

		// Get Results text
		String result = alertsPage.getResultText();

		// Verifications
		// 1 - Alert text is expected
		softAssert.assertTrue(alertMessage.equals("I am a JS Confirm"),
				"Alert message is not expected. Should be 'I am a JS Confirm', but it is '" + alertMessage + "'");

		// 2 - Result text is expected
		softAssert.assertTrue(result.equals("You clicked: Cancel"),
				"result is not expected. Should be 'You clicked: Cancel', but it is '" + result + "'");
		softAssert.assertAll();
	}

	@Test
	public void jsPromptTest() {
		SoftAssert softAssert = new SoftAssert();

		// open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();

		// Click on JavaScript Alerts link
		JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();

		// Click JS Prompt button
		alertsPage.openJsPrompt();

		// Get alert text
		String alertMessage = alertsPage.getAlertText() + "[FAIL]";

		// Type text into alert
		alertsPage.typeTextIntoAlert("Hello Alert, it's Anand here");

		// Get Results text
		String result = alertsPage.getResultText() + "[FAIL]";

		// Verifications
		// 1 - Alert text is expected
		softAssert.assertTrue(alertMessage.equals("I am a JS prompt"),
				"Alert message is not expected. Should be 'I am a JS prompt', but it is '" + alertMessage + "'");

		// 2 - Result text is expected
		softAssert.assertTrue(result.equals("You entered: Hello Alert, it's Anand here"),
				"result is not expected. Should be 'You entered: Hello Alert, its Anand here', but it is '" + result
						+ "'");
		softAssert.assertAll();
	}
}
