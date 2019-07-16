package recap;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WindowHandlePractice {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/windows");
    }
    @AfterClass
    public void close(){
        driver.close();
    }



    @Test
    public void cybertekWindowTest(){
        System.out.println("Title before clicking: " + driver.getTitle());

        String mainwHandling = driver.getWindowHandle();
        driver.findElement(By.linkText("Cybertek School")).click();

        for(String handle : driver.getWindowHandles()){
            System.out.println(handle);
            if(!handle.equals(mainwHandling)){
                driver.switchTo().window(handle);
                break;
            }
        }
        System.out.println("Title after click: " + driver.getTitle());


    }
}
