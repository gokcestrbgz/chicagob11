package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SmartbearLink {

    public static void verifyNames (WebDriver driver, String givenName){
        List<WebElement> allName = driver.findElements(By.xpath("//table[@id=‘ctl00_MainContent_orderGrid’]/tbody/tr/td[2]"));
    }
}
