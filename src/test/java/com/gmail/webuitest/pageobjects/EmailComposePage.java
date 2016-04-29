package com.gmail.webuitest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailComposePage {

	public void fillRecipient(WebDriver driver, String recipient) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@role='combobox'][@tabindex='1']")));
		WebElement recipientText = driver.findElement(By.xpath("//textarea[@role='combobox'][@tabindex='1']"));
		recipientText.clear();
		recipientText.sendKeys(recipient);
		
	}

	public void fillSubject(WebDriver driver, String subject) {
		WebElement subjectText = driver.findElement(By.xpath("//input[@name='subjectbox']"));
		subjectText.clear();
		subjectText.sendKeys(subject);
		
	}

	public void fillBody(WebDriver driver, String bodyText) {
		WebElement emailbodyText = driver.findElement(By.xpath("//div[@role='textbox'][@tabindex='1']"));
		emailbodyText.clear();
		emailbodyText.sendKeys(bodyText);
		
	}

	public EmailAccountPage clickSend(WebDriver driver) {
		WebElement sendButton = driver.findElement(By.xpath("//tr[@class='n1tfz']/td[1]"));
		sendButton.click();
		return PageFactory.initElements(driver, EmailAccountPage.class);
		
	}

}
