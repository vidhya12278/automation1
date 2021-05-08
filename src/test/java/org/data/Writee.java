package org.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Writee {
	public static void main(String[] args) throws IOException, InvalidFormatException {
		
		File f = new File("C:\\Users\\user\\Desktop\\dev\\Data\\excel\\test.xlsx");
		
		FileInputStream fin=new FileInputStream(f);
		
		Workbook w=new XSSFWorkbook(fin);
		Sheet s = w.createSheet("sheet");
		Row r = s.createRow(0);
		Cell c = r.createCell(0);
		String st = c.getStringCellValue();
		System.out.println(st);
		if(st.equals("name"))
		{
			c.setCellValue("student");
			
		}
		
		c.setCellValue("name");
		FileOutputStream fos= new FileOutputStream(f);
		w.write(fos);
		
		System.out.println("done");
		
	}

}
