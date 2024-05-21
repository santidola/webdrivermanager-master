package io.github.bonigarcia.wdm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Automatizacion {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

       
        WebElement usuario = driver.findElement(By.name("username"));
        WebElement contrasena = driver.findElement(By.name("password"));

        usuario.sendKeys("Admin");
        contrasena.sendKeys("admin123");

        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'oxd-button oxd-button--medium oxd-button--main orangehrm-login-button')]")));

        btn.click();
        
       
        wait.until(ExpectedConditions.urlContains("/dashboard"));

        WebElement admin = driver.findElement(By.xpath("//a[contains(@class,'oxd-main-menu-item')]"));

        admin.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement add =driver.findElement(By.xpath("//i[contains(@class,'oxd-icon bi-plus oxd-button-icon')]"));  

        add.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement desple =driver.findElement(By.xpath("//i[contains(@class,'oxd-icon bi-caret-down-fill oxd-select-text--arrow')]")); 

        desple.click();

        driver.findElement(By.xpath("//div[contains(@class, 'oxd-select-dropdown --positon-bottom')]")).findElements(By.tagName("div")).get(1).click();


        WebElement enname =driver.findElement(By.xpath("//input[contains(@placeholder,'Type for hints...')]")); 

        enname.click();

        enname.sendKeys("Ranga Akunur");

        driver.findElement(By.xpath("//div[contains(@class, 'oxd-select-dropdown --positon-bottom')]")).findElements(By.tagName("div")).get(1).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // WebElement desple2 =driver.findElement(By.xpath("//div[contains(@class,'oxd-select-text-input')]")); 

        // desple2.click();

        driver.findElements(By.xpath("//div[contains(@class,'oxd-select-text oxd-select-text--active')]")).get(1).click();

        driver.findElement(By.xpath("//div[contains(@class, 'oxd-select-dropdown --positon-bottom')]")).findElements(By.tagName("div")).get(1).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<WebElement> sername = driver.findElements(By.xpath("//input[contains(@class,'oxd-input oxd-input--active')]")); 

        sername.get(1).click();

        sername.get(1).sendKeys("andres");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<WebElement> inputs = driver.findElements(By.xpath("//input[contains(@class,'oxd-input oxd-input--active')]")); 

        inputs.get(1).click();
        inputs.get(1).sendKeys("dola123456$");
        inputs.get(2).click();
        inputs.get(2).sendKeys("dola123456$");

        driver.findElement(By.xpath("//button[contains(@class, 'oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space')]")).click();
    }
}