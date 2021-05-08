package org.data;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Reaction extends Base
{

public static void main(String[] args) throws IOException {
 WebDriver driver=browserlaunch();
			
			open("https://www.facebook.com/");
			
			WebElement email = driver.findElement(By.id("email"));
			forward(email,getData(1,0));
			WebElement pass = driver.findElement(By.id("pass"));
			forward(pass,getData(1,1));
			WebElement login = driver.findElement(By.id("loginbutton"));
			loginclick(login);
		}

	}


