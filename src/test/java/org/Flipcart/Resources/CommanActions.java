package org.Flipcart.Resources;
import org.FlipcartTestRunner.*;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class CommanActions {
	
	WebDriver driver = Hooks.driver;

	public void windowHandling() {

        String parentWindow = driver.getWindowHandle();
	    
	    Set<String> windows =  driver.getWindowHandles();
	     
	     for(String x:windows) {
				
				if(!x.equals(parentWindow)) {
					
					driver.switchTo().window(x);
				}
			}
		
	}

}
