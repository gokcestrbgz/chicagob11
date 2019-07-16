package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class DragandDropExamples {


    @Test
    public void dragAndDropTest(){
        //1- get the page
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        //2-Locate the element
        WebElement source = Driver.getDriver().findElement(By.id("draggable"));
        WebElement target = Driver.getDriver().findElement(By.id("droptarget"));
        //3-Create an object of actions class.
        Actions actions = new Actions(Driver.getDriver());
        //4-Use actions objects and execute dragAngDrop method
        actions.dragAndDrop(source,target).perform();
        //5-Verify the text-assert the text is expected
        String expectedText = "You did great!";
        String actualText = target.getText();
        Assert.assertEquals(actualText,expectedText,"text not as an expected!");
        //Another way to DragAndDrop action
        //actions.clickAndHold(source).moveToElement(target).release().perform();



    }
}

