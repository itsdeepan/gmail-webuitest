package com.gmail.webuitest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailAccountPage {

	public EmailHomePage clickSignOut(WebDriver driver) {
		WebElement profileButton = driver.findElement(By.xpath(".//div[@id='gbwa']/following-sibling::div[2]//a"));
		profileButton.click();
		WebElement signoutLinkage = driver.findElement(By.xpath("//a[@id='gb_71']"));
		signoutLinkage.click();
		return PageFactory.initElements(driver, EmailHomePage.class);
	}

	public boolean isInboxExist(WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@title,'Inbox')]")));
		return driver.findElements(By.partialLinkText("Inbox")).size() > 0;
		
	}

	public EmailComposePage clickComposeButton(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='button'][@gh='cm']")));
		WebElement composeButton = driver.findElement(By.xpath("//div[@role='button'][@gh='cm']"));
		composeButton.click();
		return PageFactory.initElements(driver, EmailComposePage.class);
	}

	public void clickInboxWithNewMail(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@title,'Inbox')]")));
		WebElement inboxLinkage = driver.findElement(By.xpath("//a[contains(@title,'Inbox')]"));
		inboxLinkage.click();
		
	}

	public EmailViewPage clickNewEmail(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='y6']/span/b")));
		WebElement newEmail = driver.findElement(By.xpath("//div[@class='y6']/span/b"));
		newEmail.click();
		return PageFactory.initElements(driver, EmailViewPage.class);
	}

}
