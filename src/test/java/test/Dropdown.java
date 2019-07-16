package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.Config;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Dropdown {
    @Test
    public void testing(){
        System.out.println(Config.getProperty("url"));
    }
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");

        //first-> we need to locate the select element
        WebElement month = driver.findElement(By.id("month"));

        //second-> create an object from Select class.(comes from Selenum Library)
        //thirs-> When creating Select obhject you must pass your selected element(WebElement) in it
        Select monthDropdown = new Select(month);

        //TEST:
        //verify the default value
        //how many options or what options has to be there
        // select one options and verify if it is selected.
        //ACTIONS:
        //we can get selected option: getFirstSelectedOption
        String firstSelectedOption = monthDropdown.getFirstSelectedOption().getText();
        System.out.println(firstSelectedOption);
        //ways to select certain option
        //1- by index
        monthDropdown.selectByIndex(1);
        //2- by visible text
        monthDropdown.selectByVisibleText("December");
        //3- by value
       monthDropdown.selectByValue("8");
        //we can get all options: getOptions
       List <WebElement> months = monthDropdown.getOptions();
       for(WebElement m: months){
           System.out.println(m.getText());
       }










    }
}
