package com.gmail.webuitest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.gmail.webuitest.pageobjects.EmailAccountPage;
import com.gmail.webuitest.pageobjects.EmailComposePage;
import com.gmail.webuitest.pageobjects.EmailViewPage;
import com.gmail.webuitest.pageobjects.PasswordPage;
import com.gmail.webuitest.pageobjects.EmailHomePage;
import com.gmail.webuitest.util.WebUtil;



public class GmailSignInTest {
	
	WebDriver driver = new FirefoxDriver();
	
	@Test
	public void gmailLoginShouldBeSuccessful(){
		
		//1. Go to Gmail Website
		EmailHomePage userNamePage = WebUtil.goToSignInPage(driver);

		//2. Fill in the User Name
		userNamePage.fillUserName(driver,"itsdeepan@gmail.com");

		//3. Click Next button
		PasswordPage passwordPage = userNamePage.clickNextButton(driver);
		
		//4. Fill in the password
		passwordPage.fillPassword(driver,"3@SW156hy");
		
		//5. Click the Signin button
		EmailAccountPage emailAccountPage = passwordPage.clickSigninButton(driver);
		
		//6. Verify User did signin
		Assert.assertTrue("Inbox should exist",emailAccountPage.isInboxExist(driver));
		
		//7. Signout
		userNamePage = emailAccountPage.clickSignOut(driver);
		
		//8. Verify user did signout
		Assert.assertTrue("Signin button should exist",userNamePage.isSignInButtonExixt(driver));
	}
	
	@Test
	public void sendAndReceiveMailTest()
	{
		//1. Go to Gmail Website
		EmailHomePage emailHomePage = WebUtil.goToSignInPage(driver);

		//2. Fill in the User Name
		emailHomePage.fillUserName(driver,"itsdeepan@gmail.com");

		//3. Click Next button
		PasswordPage passwordPage = emailHomePage.clickNextButton(driver);
		
		//4. Fill in the password
		passwordPage.fillPassword(driver,"3@SW156hy");
		
		//5. Click the Signin button
		EmailAccountPage emailAccountPage = passwordPage.clickSigninButton(driver);

		//2. Click compose 
		EmailComposePage emailComposePage = emailAccountPage.clickComposeButton(driver);
		
		//3. Fill in recipient
		emailComposePage.fillRecipient(driver,"itsdeepan@gmail.com");
		
		//4. Fill in subject
		final String expectedSubject = "This is test message";
		emailComposePage.fillSubject(driver,expectedSubject);
		
		//5. Fill in email body
		final String expectedBodyMsg = "Hi all Testers! Good morning!";
		emailComposePage.fillBody(driver,expectedBodyMsg);
		
		//6. Click send
		emailAccountPage = emailComposePage.clickSend(driver);
		
		//7. Click Inbox again
		emailAccountPage.clickInboxWithNewMail(driver);
		
		//8. Click email
		EmailViewPage emailViewPage = emailAccountPage.clickNewEmail(driver);
		
		//9. Verify the email subject and email body is correct
		String actualSubject = emailViewPage.getEmailSubject(driver);
		Assert.assertEquals("Subject shoul be the same.",expectedSubject,actualSubject);
		
		String actualBodyMsg = emailViewPage.getEmailBody(driver);
		Assert.assertEquals("Body message should be the same.",expectedBodyMsg,actualBodyMsg );
		
		//10. Signout
		emailHomePage = emailAccountPage.clickSignOut(driver);
		
	}
	
	
	@After
	public void tearDown(){
		
		driver.quit();
	}


}
