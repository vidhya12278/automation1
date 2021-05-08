package org.data;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class React extends Basemaven
{
	public static void main(String[] args) throws InvalidFormatException, IOException
	{
		//React y=new React();
		WebDriver driver=browser();
		open("http://www.adactin.com/HotelApp/");
		
		WebElement username = driver.findElement(By.name("username"));
		forwards(username,hotel(1,0));
		WebElement password = driver.findElement(By.name("password"));
		forwards(password,hotel(1,1));
		WebElement login = driver.findElement(By.id("login"));
		loginclick(login);
		
		WebElement location = driver.findElement(By.name("location"));
		sends(location,reg(1,2));
		WebElement hotels = driver.findElement(By.name("hotels"));
		sends(hotels,reg(1,3));
		WebElement roomtype = driver.findElement(By.name("room_type"));
		sends(roomtype,reg(1,4));
		WebElement roomno = driver.findElement(By.name("room_nos"));
		sends(roomno,reg(1,5));
		WebElement datein = driver.findElement(By.name("datepick_in"));
		sends(datein,"01/05/2020");
		WebElement dateout = driver.findElement(By.name("datepick_out"));
		sends(dateout,"04/05/2020");
		WebElement adultroom  = driver.findElement(By.name("adult_room"));
		sends(adultroom,reg(1,7));
		WebElement childroom = driver.findElement(By.name("child_room"));
		sends(childroom,reg(1,8));
		WebElement submit = driver.findElement(By.name("Submit"));
		loginclick(submit);
	}

	

}
