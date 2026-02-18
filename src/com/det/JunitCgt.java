package com.det;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import com.apache.commons.io.FileUtils;
import com.apache.poi.xssf.usermodel.XSSFCell;
import com.apache.poi.xssf.usermodel.XSSFRow;
import com.apache.poi.xssf.usermodel.XSSFSheet;
import com.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.junit.After;
import com.junit.AfterClass;
import com.junit.Before;
import com.junit.BeforeClass;
import com.junit.Test;
import com.openqa.selenium.By;
import com.openqa.selenium.OutputType;
import com.openqa.selenium.TakesScreenshot;
import com.openqa.selenium.WebDriver;
import com.openqa.selenium.WebElement;
import com.openqa.selenium.chrome.ChromeDriver;
import com.openqa.selenium.support.ui.ExpectedConditions;
import com.openqa.selenium.support.ui.WebDriverWait;

import com.junit.FixMethodOrder;
import com.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class JunitCgt {
		static WebDriver wb;
		static long starttime;
		@BeforeClass
		public static void BrowserLauncher() {
			wb = new ChromeDriver();
			wb.manage().window().maximize();
			wb.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			wb.get("https://www.flipkart.com/");
		}
		@AfterClass
		public static void Quit() {
//			wb.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			wb.quit();
		}
		@Before
		public void start() {
			starttime = System.currentTimeMillis();
		}
		@After
		public void endTime() {
			long end = System.currentTimeMillis();
			System.out.println("After Time Taken is :" + (end - starttime));
		}
		@Test
		public void test1_popUp(){
			try {
				WebElement popu = wb.findElement(By.xpath("//span[contains(text(),'Login')]"));
				popu.click();
				System.out.println("Suscessfully Login");
			}
			catch(Exception w) {
				System.out.println("Popup not available: "+w);
		}
			System.out.println("Task1:popup");
			
		}
		@Test
		public void test2_searchBox() throws InterruptedException {
			WebElement sb = wb.findElement(By.xpath("//input[@name=\"q\"]"));
			sb.sendKeys("oneplus 9r");
			WebElement ss = wb.findElement(By.xpath("//button[@type=\"submit\"]"));
			ss.click();
			wb.findElement(By.xpath("//div[contains(text(),\"OnePlus 9R 5G (Carbon Black, 128 GB)\")]")).click();			
			String parentwindow = wb.getWindowHandle();
			Set<String>allWindows = wb.getWindowHandles();
			
			for(String win : allWindows ) {
				if(!win.equals(parentwindow)) {
					wb.switchTo().window(win);
				}
			}
		}
		@Test
		public void test3_proofAndXl() throws IOException {

			WebDriverWait wait = new WebDriverWait(wb, Duration.ofSeconds(20));

			By product = By.xpath("//div[contains(text(),'9R 5G')]");

			String ProductName = wait.until(
			        ExpectedConditions.refreshed(
			                ExpectedConditions.visibilityOfElementLocated(product)
			        )
			).getText();

			
			File file = new File("C:\\Users\\User\\eclipse\\committers-2025-09\\eclipse\\Junit\\OnePlus.xlsx");
			FileOutputStream ff = new FileOutputStream(file);
			XSSFWorkbook ww = new XSSFWorkbook();
			XSSFSheet ws = ww.createSheet("TresureHunt");
			XSSFRow row = ws.createRow(0);
			XSSFCell cell = row.createCell(0);
			
			cell.setCellValue(ProductName);
			ww.write(ff);
			ff.close();
			ww.close();
			
		}
		@Test
		public void test4_screenshot() throws IOException {
			TakesScreenshot ts =(TakesScreenshot) wb;
			File temp = ts.getScreenshotAs(OutputType.FILE);
			wb.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			File perm = new File("C:\\Users\\User\\eclipse\\committers-2025-09\\eclipse\\Junit\\OnePlusSS3.png");
			FileUtils.copyFile(temp, perm);
			
			System.out.println("Everything is done");
			
		}
		
	}

