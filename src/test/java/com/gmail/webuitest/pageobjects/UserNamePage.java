package com.gmail.webuitest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserNamePage {

	public void fillUserName(WebDriver driver, String userName) {
		
		WebElement usernameTextBox = driver.findElement(By.xpath("//input[@id='Email']"));
		usernameTextBox.clear();
		usernameTextBox.sendKeys(userName);
		
		
	}

	public PasswordPage clickNextButton(WebDriver driver) {
		WebElement nextButton = driver.findElement(By.xpath("//input[@id='next']"));
		nextButton.click();
		return PageFactory.initElements(driver, PasswordPage.class);
	}

	public boolean isSignInButtonExixt(WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='signIn']")));
		return driver.findElements(By.xpath("//input[@id='signIn']")).size() > 0;
		
	}

}
