package EducaITPro;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Laboratorio3Tarea {
    WebDriver driver;
    String URL = "http://automationpractice.pl/index.php?controller=authentication#account-creation";

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "..\\EducaITPro\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void irUrl() {
        driver.get(URL);
    }

    @BeforeClass
    public void maxVentana() {
        driver.manage().window().maximize();
    }

    // Primer test: Registro de usuario
    @Test(description = "CP_001")
    public void registrarUsuario() {
        WebElement txt_Email = driver.findElement(By.id("email_create"));
        txt_Email.sendKeys("micorreo" + Math.random() + "@correo.com");

        WebElement btn_Create = driver.findElement(By.name("SubmitCreate"));
        btn_Create.click();

        WebDriverWait mywait = new WebDriverWait(driver, 10);
        mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id,'id_gender1')]")));

        driver.findElement(By.id("id_gender1")).click();

        WebElement txt_FirstName = driver.findElement(By.name("customer_firstname"));
        txt_FirstName.sendKeys("Juan Cruz");

        WebElement txt_Password = driver.findElement(By.name("passwd"));
        txt_Password.sendKeys("123456");

        Select drp_Months = new Select(driver.findElement(By.id("months")));
        drp_Months.selectByValue("4");

        WebElement btn_Register = driver.findElement(By.xpath("//*[text()='Register']"));
        btn_Register.click();

        Assert.assertEquals("http://www.automationpractice.pl/index.php?controller=authentication", driver.getCurrentUrl());
    }

    // Segundo test: Inicio de sesión
    @Test(description = "CP_002")
    public void iniciarSesion() {
        WebElement txt_Email = driver.findElement(By.id("email"));
        txt_Email.sendKeys("micorreo@correo.com");

        WebElement txt_Password = driver.findElement(By.id("passwd"));
        txt_Password.sendKeys("123456");

        WebElement btn_SignIn = driver.findElement(By.id("SubmitLogin"));
        btn_SignIn.click();

        // Verificar que el usuario inició sesión correctamente
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Welcome')]")).isDisplayed());
    }

    // Captura de pantalla tras cada método de test
    @AfterMethod
    public void capturaPantalla() throws IOException {
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen, new File("..\\EducaITPro\\Evidencias\\pantalla_" + System.currentTimeMillis() + ".png"));
    }

    @AfterClass
    public void finPrueba() {
        System.out.println("Fin de Prueba");
    }

    @AfterTest
    public void cierreNavegador() {
        driver.close();
    }

    @AfterSuite
    public void finSuite() {
        System.out.println("Fin de Suite");
    }
}

