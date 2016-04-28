package com.gmail.webuitest.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gmail.webuitest.pageobjects.UserNamePage;

public class WebUtil {

	public static UserNamePage goToSignInPage(WebDriver driver) {
		
		driver.get("http://gmail.com");
		return PageFactory.initElements(driver, UserNamePage.class);
	}

}

