package com.gmail.webuitest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailViewPage {

	public String getEmailSubject(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ha']/h2[@class='hP']")));
		return driver.findElement(By.xpath("//div[@class='ha']/h2[@class='hP']")).getText();
	}

	public String getEmailBody(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='gs']//div[@dir='ltr']")).getText();
	}

}

