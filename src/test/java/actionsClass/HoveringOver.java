package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

public class HoveringOver extends TestBase {

    @Test
    public void amazonHover(){
        Driver.getDriver().get("https://amazon.com");
        //1-We locate the WebElement
        WebElement signInLink = Driver.getDriver().findElement(By.id("nav-link-accountList"));
        //2- We create the instance of Actions class.ss
        Actions actions = new Actions(Driver.getDriver());
        //3-We just use the actions abject to call ant method from Actions class.
        actions.moveToElement(signInLink).perform();
        //actions.perform();      --> also u can use


    }

    @Test
    public void hoverPractice(){
        //1-Get the WebApp
    Driver.getDriver().get("http://practice.cybertekschool.com/hovers");
        //2-Locating all the WebElemnts that we will be doing any action on.
    WebElement img1 = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[1]"));
    WebElement img2 = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[2]"));
    WebElement img3 = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[3]"));

    WebElement user1 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
    WebElement user2 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
    WebElement user3 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));

        //3- Creating the object of Actions class
    Actions actions = new Actions(Driver.getDriver());

    //4- Using the actions object
    actions.moveToElement(img1).perform();
    Assert.assertTrue(user1.isDisplayed());

     actions.moveToElement(img2).perform();
      Assert.assertTrue(user2.isDisplayed());

      actions.moveToElement(img3).perform();
      Assert.assertTrue(user3.isDisplayed());

    }

}
