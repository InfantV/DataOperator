package org.FlipcartTestRunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	        public static WebDriver driver;
	
	@Before
	public void browserLaunch() {
		
		System.out.println("Start");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\eclipse\\committers-2025-09\\eclipse\\CucumberProject\\target\\chromedriver.exe");
		
        driver = new ChromeDriver();
	}
	
	@After
    public void browserTerminate() {
		
	    driver.quit();
		
		System.out.println("end");
	}

}