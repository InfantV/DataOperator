package com.det;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class MobilePurchase {

	static long start ;
	
	static WebDriver driver;
	
	@BeforeClass
	public static void browserLaunch() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=674893540034&hvpos=&hvnetw=g&hvrand=14381868502154284794&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1007809&hvtargid=kwd-64107830&hydadcr=14452_2316413&gad_source=1");
		System.out.println("Browser Launch "); // browser set up
	} 
	
	
	@AfterClass
	public static void quit() {
		
		driver.quit();
		System.out.println("Browser quit "); //browser close
		
	}

	
	@Before
	public void startTime() {
			
		start=System.currentTimeMillis();
		
	}
	
	@After
	public void endTime() {
		
		Long end=System.currentTimeMillis();
		System.out.println("After Time Taken: " +(end-start));
	}
	@Test
	public void Method1() {
		
		try {
			
			WebElement siginpopup=driver.findElement(By.xpath("//span[text()='Sign in']"));
			siginpopup.click();
			System.out.println("Popup handled succesfully");
			
		} catch (Exception e) {
				System.out.println("Popup not present: "+e);
		}
		
		
		System.out.println("Method 1: Popup "); // popup handle
		
	}
	
	@Test
	public void Method2() {
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("realme mobile");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println("Method 2: searched succesfully"); // search realme mobile in search
		
	}
	
	
	@Test
	public void Method3() throws IOException {
		
		
		WebElement firstproduct =driver.findElement(By.partialLinkText("NARZO 80 Lite 5G (Crystal Purple, 4GB+128GB) | 6000mAh Long-Lasting Battery |"));
		
		String ProductName=firstproduct.getText();
		
		File file = new File("C:\\Users\\admin\\eclipse-workspace\\JunitProject\\Flipkart.xlsx");
		FileOutputStream fo= new FileOutputStream(file);
		XSSFWorkbook wb= new XSSFWorkbook();
		XSSFSheet  sheet=wb.createSheet("Mobile Purchase");
		XSSFRow row=sheet.createRow(0);
		XSSFCell cell=row.createCell(0);
		
		cell.setCellValue(ProductName);
		wb.write(fo);
		fo.close();
		wb.close();
		
		org.junit.Assert.assertEquals(ProductName, "NARZO 80 Lite 5G (Crystal Purple, 4GB+128GB) | 6000mAh Long-Lasting Battery | MediaTek Dimensity 6300 5G | AI Assist | IP64 Rated Water & Dust Resistance | Military-Grade Durability");
		
		System.out.println("Method 3: Elemnet has stored in excel ");//In method 3  choose 1 st mobile i just want 1st product to gettext and store in excel
	} 
	
	@Test
	public void Method4() {
		
		WebElement firstproduct =driver.findElement(By.partialLinkText("NARZO 80 Lite 5G (Crystal Purple, 4GB+128GB) | 6000mAh Long-Lasting Battery |"));
		
		firstproduct.click();
		
		String Parent=driver.getWindowHandle();
		
		Set<String>	allwindows=driver.getWindowHandles();
		
		for (String window: allwindows) {
			
			
			if (!window.equals(Parent)) {
				
				driver.switchTo().window(window);
			}
			
		}
		
		System.out.println("Method 4: Window handled"); // window handle
	}
	
	@Test
	public void Method5() throws IOException {
		
		TakesScreenshot tc= (TakesScreenshot) driver;	
		
		File temp= tc.getScreenshotAs(OutputType.FILE);
		File perm = new File("C:\\Users\\admin\\eclipse-workspace\\JunitProject\\screenshots.png");
		FileUtils.copyFile(temp, perm);
		
		System.out.println("Method 5: Screenshot Captured "); // screenshot
	}
	
}
