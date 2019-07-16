package data;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Config;
import utilities.Driver;

public class TestData {
    @Test
    public void m()  {
      /*  Properties p = new Properties();
        String path = "configuration.properties";
        FileInputStream file = new FileInputStream(path);
        p.load(file);
        System.out.println(p.getProperty("username"));
        System.out.println(p.getProperty("password"));*/

        Driver.getDriver().get("http://www.google.com");
        Driver.getDriver().findElement(By.name("q")).sendKeys("apple" + Keys.ENTER);
        WebElement search = Driver.getDriver().findElement(By.name("q"));
        search.sendKeys(Config.getProperty("search")+Keys.ENTER);




    }
}
