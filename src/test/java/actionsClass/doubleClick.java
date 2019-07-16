package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class doubleClick {
    Actions actions;

    @Test
    public void doubleClickTest () throws InterruptedException {
        //1-Get the webApp
        Driver.getDriver().get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml");
        //2- Locate the WebElement
        WebElement puff = Driver.getDriver().findElement(By.id("puff_header"));
        //3-Create an object the Actions class.
        actions = new Actions(Driver.getDriver());
        //4- Use the method coming from Actions class.
        actions.doubleClick(puff).perform();
        Thread.sleep(1000);
        Assert.assertFalse(puff.isDisplayed());

    }



    @Test
    public void doubleClickTestIfare() throws InterruptedException {
        //1-Get the webApp
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        //2-switch the iframe
        Driver.getDriver().switchTo().frame("iframeResult");
        //3-locate the webElement inside of the iframe
        WebElement clicktoRed =  Driver.getDriver().findElement(By.xpath("//p[@id='demo']"));
        //4- instantiating the instance of actions class
        actions = new Actions(Driver.getDriver());
        actions.doubleClick(clicktoRed).perform();
        Thread.sleep(2000);
        Assert.assertTrue(clicktoRed.getAttribute("style").contains("red"));


    }
}
