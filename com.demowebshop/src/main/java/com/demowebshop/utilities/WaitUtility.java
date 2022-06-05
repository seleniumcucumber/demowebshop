package com.demowebshop.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static final long PAGE_LOAD_WAIT = 20;
	public static final long EXPLICIT_WAIT=20;
	public enum LocatorType{
		Id,Xpath,Name,Css,LinkText,PartialLinkText
	};
	
	public void waitforElementTobeVisible(WebDriver driver, String target, Enum locatorType) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		if (locatorType.equals(LocatorType.Id)) {
			wait.until(ExpectedConditions.elementToBeClickable(By.id(target)));
		} else if (locatorType.equals(LocatorType.Xpath)) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(target)));
		} else {
			try {
				throw new Exception("Invalid Locator");
				

			} catch (Exception e) {

			}
		}

	}
	
	public void waitforElementTobeSelected(WebDriver driver, String target, Enum locatorType)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		if (locatorType.equals(LocatorType.Id)) {
			wait.until(ExpectedConditions.elementToBeSelected(By.id(target)));
		} else if (locatorType.equals(LocatorType.Xpath)) {
			wait.until(ExpectedConditions.elementToBeSelected(driver.findElement(By.xpath(target))));
		} else {
			try {
				throw new Exception("Invalid Locator");

			} catch (Exception e) {

			}
		}
	}
	
	

}
