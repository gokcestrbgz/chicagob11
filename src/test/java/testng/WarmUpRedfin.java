package testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WarmUpRedfin {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
     public void RedfinVerification() throws InterruptedException {
        driver.get("https://www.redfin.com");

        WebElement inputSearch = driver.findElement(By.id("search-box-input"));
        inputSearch.sendKeys("Napelville" + Keys.ENTER);

        WebElement minDropDown = driver.findElement(By.xpath("//span[starts-with(@class,'quickMinPrice')]"));
        minDropDown.click();

        WebElement min75k =  driver.findElement(By.xpath("//span[starts-with(@class,'quickMinPrice')]//span[.='$75k']"));
        Thread.sleep(1000);
        min75k.click();

        Thread.sleep(1000);

        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Assert.assertTrue(currentUrl.contains("75k"));






    }

}
