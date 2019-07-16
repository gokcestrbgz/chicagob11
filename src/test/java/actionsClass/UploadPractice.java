package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

public class UploadPractice {
    @Test
    public void uploadTest(){
        Driver.getDriver().get("http://practice.cybertekschool.com/upload");
        WebElement chooseFileInput = Driver.getDriver().findElement(By.id("file-upload"));
        chooseFileInput.sendKeys("C:/Users/rgokc/Desktop");

        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));
        uploadButton.click();
    }
}
