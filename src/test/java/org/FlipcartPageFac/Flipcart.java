package org.FlipcartPageFac;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.FlipcartTestRunner.*;

public class Flipcart{
	
	WebDriver driver = Hooks.driver;
	
	public Flipcart() {
		
		PageFactory.initElements(driver, this);
		
		}
	@FindBy(xpath="(//input[@name='q'])[1]")
	private WebElement search;
	
	@FindBy(xpath="(//div[@class='RG5Slk'])[2]")
	private WebElement child;

	public WebElement getChild() {
		return child;
	}

	public WebElement getSearch() {
		return search;
	}

}
