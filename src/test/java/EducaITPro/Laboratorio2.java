package EducaITPro;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Laboratorio2 {

	@Test
	public void lab2_E1test() {
		
		System.setProperty("webdriver.chrome.driver", "..\\EducaITPro\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
		
		driver.manage().window().maximize();
	
		WebElement txt_Email=driver.findElement(By.id("email_create"));
		txt_Email.sendKeys("micorreo"+ Math.random() +"@correo.com");	
		
		WebElement btn_Create=driver.findElement(By.id("SubmitCreate")); 
		btn_Create.click();
		
		WebDriverWait mywait = new WebDriverWait(driver, 10);
		
		WebElement rb_gender = mywait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
		
		rb_gender.click();
		
		WebElement txt_FirstName=driver.findElement(By.name("customer_firstname"));
		txt_FirstName.sendKeys("Andrea");
		
		WebElement txt_Password=driver.findElement(By.name("passwd"));
		txt_Password.sendKeys("123456");
		
		Select months=new Select(driver.findElement(By.id("months")));
		months.selectByValue("4");
		
		WebElement btn_Register=driver.findElement(By.xpath("//*[text()='Register']"));
		btn_Register.click();
		
		
		
		
		
		
		
	}
}