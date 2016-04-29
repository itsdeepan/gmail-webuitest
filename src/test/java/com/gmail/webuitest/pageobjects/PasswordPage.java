package com.gmail.webuitest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordPage {

	public void fillPassword(WebDriver driver, String password) {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Passwd']")));
		WebElement passwordTextBox = driver.findElement(By.xpath("//input[@id='Passwd']"));
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);
	}

	public EmailAccountPage clickSigninButton(WebDriver driver) {
		WebElement signinButton = driver.findElement(By.xpath("//input[@id='signIn']"));
		signinButton.click();
		return PageFactory.initElements(driver, EmailAccountPage.class);
	}

}
