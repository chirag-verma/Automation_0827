package com.moodys.qats.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard {
	WebDriver driver;
	
	public Dashboard(WebDriver driver){
		
		this.driver=driver;
	}
  public void clickonworkbasket(String workbasket){
	  
	  driver.findElement(By.xpath("//span[@data-name='"+workbasket+"']")).click();
  }
  
  public void clickonfirstcase(String framename){
	  
	  driver.findElements(By.xpath("//a[@title='Click here to open the object']")).get(0).click();
	  driver.switchTo().defaultContent();
		driver.switchTo().frame(framename);
  }
}
