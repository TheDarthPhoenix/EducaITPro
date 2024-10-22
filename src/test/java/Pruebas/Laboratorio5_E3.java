package Pruebas;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Paginas.paginaLogin;

public class Laboratorio5_E3 {
	
	WebDriver driver;
	paginaLogin login;
	
	
	String URL="https://demo.guru99.com/test/newtours/index.php";
	String PATH="..\\EducaITPro\\Drivers\\chromedriver.exe";
    
	@BeforeSuite
	public void setUp() {
		
		    System.setProperty("webdriver.chrome.driver", PATH);
		    driver=new ChromeDriver();
		    driver.get(URL);
		    driver.manage().window().maximize();
	}
	
	
	@AfterSuite
	public void cierreNavegador() {
		
		driver.close();
	}
	@Test
	public void popUp() throws InterruptedException {
		WebElement btnAlert=driver.findElement (By.id("alertButton"));
		btnAlert.click();
		Thread.sleep(2000);
		Alert popUp=driver.switchTo().alert();
		popUp.accept();
	
		
	}
}
		