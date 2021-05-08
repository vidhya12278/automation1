package org.data;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Basemaven
{
	static WebDriver driver;
	static Select s;
	public  static  WebDriver  browser()
	{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Desktop\\dev\\Firstday\\driver\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	return driver;
	}
	public  static void open(String url)
	{
		driver.get(url);
    }
	/*public  void open(String url)
	{
		d.get(url);
	}*/
	
	//username and password
	public static void forwards(WebElement p,String  text)
	{
		p.sendKeys(text);
	}
	
	public static String hotel(int rowno,int colno) throws InvalidFormatException, IOException 
	{
		File file = new File("C:\\Users\\user\\Desktop\\dev\\Data\\excel\\hote.xlsx");
		
		Workbook w=new XSSFWorkbook(file);
		Sheet s = w.getSheet("sheet1");
		Row r = s.getRow(rowno);
		Cell c = r.getCell(colno);
		CellType cellType = c.getCellType();
		String value="";
		if(cellType==CellType.STRING)
		{
		value=c.getStringCellValue();	
		}
		else 
		
			if(DateUtil.isCellDateFormatted(c))
			{
				double d = c.getNumericCellValue();
				long l=(long)d;
				value=String.valueOf(l);
				}
	return value;
		}
	public static  void loginclick(WebElement f)
	{
		f.click();
		}
	public static void sends(WebElement s,String text) 
	{
	s.sendKeys(text);
}
	
	public static  String reg(int rowno,int colno) throws InvalidFormatException, IOException 
	{
File file = new File("C:\\Users\\user\\Desktop\\dev\\Data\\excel\\hote.xlsx");
			Workbook w=new XSSFWorkbook(file);
		Sheet s = w.getSheet("sheet1");
		Row r = s.getRow(rowno);
		Cell c = r.getCell(colno);
		CellType cellType = c.getCellType();
		String value="";
			if(cellType==CellType.STRING)
		{
		value=c.getStringCellValue();	
		}
		else 
			if(DateUtil.isCellDateFormatted(c))
			{
				    Date e=c.getDateCellValue();
				    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				    value=sdf.format(e);
			}
			else
			{
				double d = c.getNumericCellValue();
				long l=(long)d;
				value=String.valueOf(l);
					}
		return value;
		}
public static  void select(WebElement a) 
{
	 s=new Select(a);
	 s.selectByValue("London");

}
	
	public static  void loginclick1(WebElement o)
	{
		o.click();
	}
	}

