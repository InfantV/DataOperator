package org.FlipcartTestRunner;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.Flipcart.Resources.*;
import org.FlipcartTestRunner.*;
import org.FlipcartPageFac.*;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlipcartStepDefantion extends CommanActions {
	
	CommanActions c = new CommanActions();
	Flipcart f= new Flipcart();
	
	WebDriver driver;
	
	static WebDriverWait wait;
	
	static String parentWindow;
	
     static Set<String> windows;
	
	@Given("User opens flipkart browser")
	public void user_opens_flipkart_browser() {
		   
		   driver = Hooks.driver;
		
		   driver.get("https://www.flipkart.com/");
		   
		   wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
	}

	@And("User searches Realme mobile")
	public void user_searches_realme_mobile() {
	  
		f.getSearch().sendKeys("Realme",Keys.ENTER);
	   
	}

	@When("clicks the second mobile from the options")
	public void clicks_the_second_mobile_from_the_options() {
	   
		 f.getChild().click();
		
		
	    
	}

	@When("add the mobile to cart")
	public void add_the_mobile_to_cart() throws InterruptedException {
		
		c.windowHandling();
		
		WebElement addToCart = wait.until(
		        ExpectedConditions.presenceOfElementLocated(
		                By.xpath("//*[name()='svg']/ancestor::div[1]")));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", addToCart);

		addToCart.click();
		//js.executeScript("arguments[0].click();", addToCart);
		
		Thread.sleep(5000);
	    
		driver.findElement(By.xpath("//span[text()='Cart']")).click();

	}

	@Then("User takes screenshot of the cart page")
	public void user_takes_screenshot_of_the_cart_page() throws IOException {
	    
		TakesScreenshot ts = (TakesScreenshot)driver;
		File tss = ts.getScreenshotAs(OutputType.FILE);
		File ss = new File("C:\\Users\\felix\\eclipse-workspace\\cucumberDemo\\target\\ss.png");
		FileUtils.copyFile(tss,ss);
		
	}
	
	@When("User searches mobile by using one dimensional list")
	public void user_searches_mobile_by_using_one_dimensional_list(DataTable dataTable) {
	    
		List<String> mobile = dataTable.asList();
		
		driver.findElement(By.xpath("(//input[@name=\"q\"])[1]")).sendKeys(mobile.get(1),Keys.ENTER);
		
	}
	
	@When("User searches mobile by using one dimensional map")
	public void user_searches_mobile_by_using_one_dimensional_map(io.cucumber.datatable.DataTable dataTable) {
	   
		Map<String,String> mobile = dataTable.asMap(String.class,String.class);
	   
	   driver.findElement(By.xpath("(//input[@name=\"q\"])[1]")).sendKeys(mobile.get("phone3"),Keys.ENTER);
		
	}
	
	@When("User searches mobile {string}")
	public void user_searches_mobile(String mobile) {
	   
		driver.findElement(By.xpath("(//input[@name=\"q\"])[1]")).sendKeys(mobile,Keys.ENTER);
		  
	}

}