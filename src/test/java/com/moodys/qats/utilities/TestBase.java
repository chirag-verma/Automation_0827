package com.moodys.qats.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public Properties prop;

	public static WebDriver driver;

	public TestBase() throws IOException {

		FileInputStream ip = new FileInputStream("Config.Properties");
		prop = new Properties();

		prop.load(ip);

	}

	public static void initialization() {

		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		/* Launching the browser? */
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		driver.get("https://pega-orp-qa-11.ad.moodys.net:8443/prweb/PRServlet/");

	}
}
