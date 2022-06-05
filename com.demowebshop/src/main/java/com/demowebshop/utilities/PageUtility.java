package com.demowebshop.utilities;

import org.openqa.selenium.WebElement;

public class PageUtility {
	
	public void clickOnElement(WebElement element) {
		element.click();
	}

	public void enterText(WebElement element, String textValue) {
		element.sendKeys(textValue);
	}

	public String getElementText(WebElement element) {
		return element.getText();
	}
	
}
