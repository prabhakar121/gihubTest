package sampleTest1;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest {
	WebDriver wd = null;

	@Test
	public void loadGoogle() {
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();

		wd.manage().window().maximize();
		wd.get("https://www.google.co.in/");
		wd.findElement(By.name("q")).sendKeys("chennai");
		wd.findElement(By.name("q")).submit();
	}

	@AfterMethod
	public void tearDown() throws IOException {
		File scr = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scr, new File("\\Users\\Admin\\workspace\\C2_WebdriverTest\\ScreenShot\\google.jpeg"));

	}

}
