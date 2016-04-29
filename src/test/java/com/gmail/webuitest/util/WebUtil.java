package com.gmail.webuitest.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gmail.webuitest.pageobjects.EmailHomePage;

public class WebUtil {

	public static EmailHomePage goToSignInPage(WebDriver driver) {
		
		driver.get("http://gmail.com");
		return PageFactory.initElements(driver, EmailHomePage.class);
	}

}

