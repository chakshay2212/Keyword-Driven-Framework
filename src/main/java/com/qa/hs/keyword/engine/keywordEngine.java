package com.qa.hs.keyword.engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hs.keyword.base.Base;


public class keywordEngine {

	public static WebDriver driver;
	public static Properties prop;
	public static Base base;
	public static WebElement element;
	
//	public static void main(String ar [])
//	{
//		startExecution("login");
//	}
	
	public static void startExecution (String Sheetname)     
	{
		try {
		 base =new Base();
		 prop =base.init_properties();
		 String sname = prop.getProperty("sheetname");
//		 Sheet sheet  = base.init_Excel(sname);
		 File file = new File("D:\\Workspace1\\KeywordDrivenHubSpot\\src\\main\\java\\com\\qa\\hs\\keyword\\scenario\\hubspot_scenarios.xlsx");
    	 FileInputStream inputStream = new FileInputStream(file);
    	 Workbook wb = null;
    	 wb = new XSSFWorkbook(inputStream);
    	 Sheet sheet = wb.getSheet(sname);
     
		 int k=0;
		 int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum(); 
		 System.out.println(sheet.getSheetName());
		 for (int i=0; i< rowCount; i++)
		 {
				String locatorType = sheet.getRow(i + 1).getCell(k + 1).toString().trim();
				String locatorValue = sheet.getRow(i + 1).getCell(k + 2).toString().trim();
				String action = sheet.getRow(i + 1).getCell(k + 3).toString().trim();
				String value = sheet.getRow(i + 1).getCell(k + 4).toString().trim();
				
				switch (action) {
				case "open browser" :
					 if(value.isEmpty()||value.equals("NA"))
					 {
						 driver = base .init_driver( prop.getProperty("browser"));
					 }
					 else
					 {
						 driver = base .init_driver( value);
					 }
					break;
					
				case "enter url" :
					if (value.isEmpty() || value.equals("NA")) {
						driver.get(prop.getProperty("url"));
					} else {
						driver.get(value);
						Thread.sleep(3000);
					}
					break;
				case "quit" :
					driver.quit();
					break;		
			    }
				switch (locatorType)
				{
				case "id" :
					Thread.sleep(3000);
				    element =driver.findElement(By.id(locatorValue));
					if(action.equalsIgnoreCase("sendkeys"))
					{
						element.clear();
						element.sendKeys(value);
					}
					else if(action.equalsIgnoreCase("click"))
					{
						element.click();
						
						Thread.sleep(3000);
					}
					else if(action.equalsIgnoreCase("isDisplayed"))
					{
//						element.isDisplayed();
					}	
					else if(action.equalsIgnoreCase("getText"))
					{
						String elementText =element.getText();
						System.out.println("text from element : " + elementText);
		
					}	
					locatorType = null;
		
					break;
					
				case "xpath" :
					
					Thread.sleep(3000);
					element =driver.findElement(By.xpath(locatorValue));
					if(action.equalsIgnoreCase("sendkeys"))
					{
						element.clear();
						element.sendKeys(value);
						Thread.sleep(3000);
					}
					else if(action.equalsIgnoreCase("click"))
					{
						element.click();
						Thread.sleep(3000);
					}
					else if(action.equalsIgnoreCase("isDisplayed"))
					{
//						element.isDisplayed();
					}	
					else if(action.equalsIgnoreCase("getText"))
					{
						String elementText =element.getText();
						System.out.println("text from element : " + elementText);
					}	
					locatorType = null;
					
					break;
				case "className" :
					
					Thread.sleep(3000);
					element =driver.findElement(By.className(locatorValue));
					if(action.equalsIgnoreCase("sendkeys"))
					{
						element.clear();
						element.sendKeys(value);
						Thread.sleep(3000);
					}
					else if(action.equalsIgnoreCase("click"))
					{
						element.click();
						Thread.sleep(3000);
					}
					else if(action.equalsIgnoreCase("isDisplayed"))
					{
						element.isDisplayed();
					}	
					else if(action.equalsIgnoreCase("getText"))
					{
						String elementText =element.getText();
						System.out.println("text from element : " + elementText);
						Thread.sleep(3000);
					}	
					locatorType = null;
					break;	
				case "cssselector" :
					
					Thread.sleep(3000);
					element =driver.findElement(By.cssSelector(locatorValue));
					if(action.equalsIgnoreCase("sendkeys"))
					{
						element.clear();
						element.sendKeys(value);
						
					}
					else if(action.equalsIgnoreCase("click"))
					{
						element.click();
					}
					else if(action.equalsIgnoreCase("isDisplayed"))
					{
//						element.isDisplayed();
						///Thread.sleep(3000);
					}	
					else if(action.equalsIgnoreCase("getText"))
					{
						String elementText =element.getText();
						System.out.println("text from element : " + elementText);
		
					}	
					locatorType = null;
					
					break;	
					
				default:
					break;
		}
		 
		 }
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		 
	}
	
	 

}
