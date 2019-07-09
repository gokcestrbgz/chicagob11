package testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AllertsExamples {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
            public void jsAlertTest(){
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        WebElement clickJsAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        clickJsAlert.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        String actualText = driver.findElement(By.id("result")).getText();
        String expectedText = "You successfuly clicked an alert";

        Assert.assertEquals(actualText,expectedText,"Text in first test does not match!");

    }
    @Test
    public void jsConfirmTest(){
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        WebElement clickConfirmTest = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        clickConfirmTest.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        String actualText = driver.findElement(By.id("result")).getText();
        String expectedTExt = "You clicked: Ok";
        Assert.assertEquals(actualText.equals(expectedTExt
        ),"Text in second test does not match!");
    }

    @Test
     public void jsPromt(){
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        WebElement clickJSPromt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        clickJSPromt.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello Alert");
        alert.accept();

        String actualText = driver.findElement(By.id("result")).getText();
        String expectedTExt = "You entered: Hello Alert";
        Assert.assertEquals(actualText,expectedTExt,"Text in third test does not match!");
    }


}
