package testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Smartbear7 {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void deleteAll() throws InterruptedException {

        //2. go to the web site

        driver.get(" http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        //3. Enter username: “Tester”

        WebElement inputUsername = driver.findElement(By.id("ctl00_MainContent_username"));

        //4. Enter password: “test”

        WebElement inputPassword = driver.findElement(By.id("ctl00_MainContent_password"));

        //5. Click to Login button

        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));

        inputUsername.sendKeys("Tester");
        inputPassword.sendKeys("test");
        loginButton.click();

      // WebElement checkAll =  driver.findElement(By.id("ctl00_MainContent_btnCheckAll"));
       //checkAll.click();
        List<WebElement> allCheckBoxes = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[1]"));

        for(WebElement checkbox: allCheckBoxes){
            checkbox.click();
        }

        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();


        WebElement message = driver.findElement(By.id("ctl00_MainContent_orderMessage"));
        Assert.assertTrue(message.isDisplayed(),"The message is not displayed");

    }



}
