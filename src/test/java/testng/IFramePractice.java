package testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IFramePractice {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/iframe");
    }

    @Test
    public void testIsDisplay(){
        driver.switchTo().frame("mce_0_ifr");
        String actualTextInsideIframe = driver.findElement(By.xpath("//p")).getText();
        String expectedText = "Your content goes here.";
        Assert.assertEquals(actualTextInsideIframe,expectedText,"Text inside iframe is NOt matching");
        driver.switchTo().parentFrame();
        String actualHeaderTExt = driver.findElement(By.xpath("//h3")).getText();
        String expectedHeaderText = "An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(actualHeaderTExt,expectedHeaderText,"Header text is NOT matching");


    }

}
