package com.qa.hs.keyword.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Base {

	public WebDriver driver;
	public Properties prop;
	public Sheet sheet;
	
	public WebDriver init_driver(String browserName)
	{
		if(browserName.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver","D:\\My Documents\\chromedriver_win32 (1)\\chromedriver.exe");
			if(prop.getProperty("headless").equals("No"))
			{
				ChromeOptions options =new ChromeOptions();
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
			}
			else
			{
				driver = new ChromeDriver();
			}
		}
		if(browserName.equals("firefox")) 
		{
			System.getProperty("webdriver.firefox.marionette","D:\\My Documents\\chromedriver_win32 (1)\\chromedriver.exe");
			if(prop.getProperty("headless").equals("No"))
			{
				FirefoxOptions options =new FirefoxOptions();
				options.addArguments("--headless");
				driver = new FirefoxDriver(options);
			}
			else
			{
				driver = new FirefoxDriver();
			}
		}
		return driver;
	}
	
	public Properties init_properties()
	{
		prop =new Properties();
		try {
			FileInputStream ip =new FileInputStream("D:\\Workspace1\\KeywordDrivenHubSpot\\src\\main\\java\\com\\qa\\hs\\keyword\\config\\config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public Sheet init_Excel(String Sheetname ) 
	{ 
	    try {
	    	 File file = new File("D:\\Workspace1\\KeywordDrivenHubSpot\\src\\main\\java\\com\\qa\\hs\\keyword\\scenario\\hubspot_scenarios.xlsx");
	    	 FileInputStream inputStream = new FileInputStream(file);
	    	 Workbook wb = null;
	    	 wb = new XSSFWorkbook(inputStream);
	    	 Sheet sheet = wb.getSheet(Sheetname);
	    	 
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return sheet;
        
	}
}
