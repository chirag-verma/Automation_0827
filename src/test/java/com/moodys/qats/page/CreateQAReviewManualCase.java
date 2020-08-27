package com.moodys.qats.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateQAReviewManualCase {
	WebDriver driver;

	public CreateQAReviewManualCase(WebDriver driver) {

		this.driver = driver;
	}

	public void clickoncreatecase() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Create Case']")).click();
	}

	public void clickoncreatemanualcase() {
		driver.findElement(By.xpath("//button[text()='Create Manual Case']")).click();
	}

	public void createmanualcaseandclick(String actid, String CaseDesc,String Source,String Leadanalystname) throws InterruptedException {
		if (driver.getTitle().equals("QA Manager")) {

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget1Ifr");
			Thread.sleep(2000);
		}
		
	

		driver.findElement(By.xpath("//input[@name='$PpyDisplayHarness$pManualRatingAction$l1$pRatingActionID']"))
				.sendKeys(actid);

		driver.findElement(By.xpath("//input[@name='$PpyDisplayHarness$pManualRatingAction$l1$pRatingActionDesc']"))
				.sendKeys(CaseDesc);

		Select sel = new Select(driver
				.findElement(By.xpath("//select[@name='$PpyDisplayHarness$pManualRatingAction$l1$pSourceName']")));

		sel.selectByVisibleText(Source);

		driver.findElement(By.xpath("//img[@name='CalendarImg-74605107']")).click();

		driver.findElement(By.xpath("//a[@class='today-link']")).click();

		driver.findElement(By.xpath("//label[text()='Lead Analyst Name']/following-sibling::div/input[@type='text']"))
				.sendKeys(Leadanalystname);

		driver.findElement(By.xpath("//label[text()='PACR']/following-sibling::div/input[@type='text']")).sendKeys("");

		driver.findElement(By.xpath("//button[text()='Create Case']")).click();

		Thread.sleep(4000);

		driver.navigate().refresh();

		Thread.sleep(4000);
	}
	
	public List<WebElement> CreateCase_CheckBoxList(){
		List<WebElement> ls= driver.findElements(By.xpath("//input[@type='checkbox']//following::input[@type='checkbox']"));
		return ls;
	}
	
	
	
	public String getactionidoffirstcase(){
		return driver.findElements(By.xpath("//div[@class='gridHeaderLabel ']/following::td[@data-attribute-name='Action/Shell/RTG ID']")).get(0).getText();
	}


}
