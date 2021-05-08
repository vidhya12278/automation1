package org.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.collect.Table.Cell;

public class Base {
		static WebDriver  driver;
		public static WebDriver browserlaunch()
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Desktop\\dev\\Data\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
			
			}
		public  static void open(String url)
		{
			driver.get(url);
	    }
		public static void forward(WebElement r,String text) 
		{
			r.sendKeys(text);
	    }
		
		public static String getData(int  rowno, int colno) throws IOException
		{
			File f=new File("C:\\Users\\user\\Desktop\\dev\\Data\\Excel1\\Data.xlsx");
			FileInputStream g=new FileInputStream(f);
			Workbook w=new XSSFWorkbook(g);
			Sheet s= w.getSheet("Sheet1");
			Row p = s.getRow(rowno);	
			org.apache.poi.ss.usermodel.Cell x = p.getCell(colno);
			CellType cellType = x.getCellType();
			String value="";
			if(cellType==CellType.STRING)
			{
				value = x.getStringCellValue();
			}
			else
				if(cellType==CellType.NUMERIC)
				{
					if(DateUtil.isCellDateFormatted(x))
					{
						Date d = x.getDateCellValue();
						SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
						 value = sm.format(d);
		    		}
					else {
						double u = x.getNumericCellValue();
						long l=(long)u;
						value = String.valueOf(l);
								}
				}
		    return value;
			}
		public static void loginclick(WebElement y) 
		{
			y.click();
	    }


}
