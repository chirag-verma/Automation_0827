package com.moodys.qats.page;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QATS_HomePage {
	
	WebDriver driver;
	
	public QATS_HomePage(WebDriver driver) throws IOException {
		this.driver=driver;
	
		// TODO Auto-generated constructor stub
	}

	public String HomePageTitle(){
		
		return driver.getTitle();
	}
	
	public  void clickonQAReview(){
		
			driver.findElement(By.xpath("//span[text()='Create QA Review']")).click();
		
	}
	
	public void clickonCreateManualCase(){
		
		driver.findElement(By.xpath("//span[text()='Create Manual Case']")).click();
	}
	

	public  void clickonDashboardWorkbasket() throws InterruptedException{
		Thread.sleep(2000);
	
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//span[text()='Dashboard']")).click();
		
		driver.switchTo().frame("PegaGadget1Ifr");
		Thread.sleep(2000);
	}
	
	public  void clickonDashboardcreatecase() throws InterruptedException{
		Thread.sleep(2000);
	
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//span[text()='Dashboard']")).click();
		
		driver.switchTo().frame(1);
		Thread.sleep(2000);
	}
	
	
	

}
