package com.gmail.webuitest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailViewPage {

	public String getEmailSubject(WebDriver driver) {
		return driver.findElement(By.xpath("//h2[@class='hP']")).getText();
	}

	public String getEmailBody(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='adn ads']//div[@dir='ltr']")).getText();
	}

}

