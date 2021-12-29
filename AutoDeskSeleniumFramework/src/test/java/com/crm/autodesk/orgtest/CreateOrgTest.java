package com.crm.autodesk.orgtest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.autodesk.genericutiltiy.ExcelUtiltiy;
import com.crm.autodesk.genericutiltiy.FileUtiity;
import com.crm.autodesk.genericutiltiy.JavaUtility;
import com.crm.autodesk.genericutiltiy.WebDriverUtility;

public class CreateOrgTest {
		public static void main(String[] args) throws Throwable {
			
			/*  create Object to lib */
			JavaUtility jLib = new JavaUtility();
			ExcelUtiltiy eLib = new ExcelUtiltiy();
			FileUtiity fLib = new FileUtiity();
			WebDriverUtility wLib = new WebDriverUtility();
			
			
			//read common data from properties File
		
	        String  URL = fLib.getProPertyKeyValue("url");
	        String USERNAME = fLib.getProPertyKeyValue("username");
	        String PASSWORD = fLib.getProPertyKeyValue("password");
	        String BROWSER = fLib.getProPertyKeyValue("browser");
	        
	        //getRanDom Num
	        int ranDomNum = jLib.getRanDomNumber();
	        
			//read test data from Excel File

	       String orgNAme  =  eLib.getDataFromExcel("org", 1, 2)+ ranDomNum;
	        
	        
	        WebDriver driver;           
       if(BROWSER.equals("firefox")) {
            driver = new FirefoxDriver();
       }else if(BROWSER.equals("chrome")) {
            driver = new ChromeDriver();
       }else if(BROWSER.equals("ie")) {
            driver = new InternetExplorerDriver();
       }else {
    	   
    	   
    	   
            driver = new ChromeDriver();
       }   	
       //step 1 : login
       wLib.waitForPageToLoad(driver);
         driver.get(URL);
        driver.findElement(By.name("user_name")).sendKeys(USERNAME);
        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
        driver.findElement(By.id("submitButton")).click();        
      // step 2 : navigate to Organization module
        driver.findElement(By.linkText("Organizations")).click();        
      // step 3 : click on "create Organization" Button
        driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();        
      // step 4 : enter all the details & create new Organization
        driver.findElement(By.name("accountname")).sendKeys(orgNAme);
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();       
      // step 5 : verify Organization name in header of the msg
        String actSuc_msg =  driver.findElement(By.className("dvHeaderText")).getText();
        if(actSuc_msg.contains(orgNAme)) {
        	System.out.println("org is sucussfully created..PASS");
        }else {
        	System.out.println("org is not created..FAIL");
        }
      //step 6 : logout
        wLib.mouseOverOnElemnet(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));

        driver.findElement(By.linkText("Sign Out")).click();
        driver.quit(); 
	}

}
