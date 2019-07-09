package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonDepartmentsDropdown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://amazon.com");


        WebElement departments = driver.findElement(By.id("searchDropdownBox"));
        Select departmentsDropdown = new Select(departments);
        //task1 departments dropdown default value
        String firstSelectedOption = departmentsDropdown.getFirstSelectedOption().getText();
        System.out.println(firstSelectedOption);
        //task2 departments dropdown all options
        //task3 verify each options values not empty
        List<WebElement> allDeparmentsDropdownOpt = departmentsDropdown.getOptions();
        System.out.println(allDeparmentsDropdownOpt.size());
        for (WebElement d : allDeparmentsDropdownOpt) {
            System.out.println(d.getText());
            if (!d.getText().isEmpty()) {
                System.out.println("Options Values Not Empty PASSED");
            } else {
                System.out.println("Options Values Empty FAILED!!");
            }
        }

        //task4 select Courses option and verify Courses is selected
        departmentsDropdown.selectByVisibleText("Courses");
        System.out.println(departments.isSelected());



    }

    //task5
    // public static  void verifyDepartemtDropdown(WebDriver selected, String options );
    public static void abc (WebDriver d , String object){
        String option = "search-alias=arts-crafts";
        WebDriver driver = new ChromeDriver();
        WebElement k = driver.findElement(By.id(option));
        if(k.equals(option)== k.isSelected()){
            System.out.println("passed");
        } else{
            System.out.println("failed!");
        }


    }
}