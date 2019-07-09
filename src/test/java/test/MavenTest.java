package test;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MavenTest {
    public static void main(String[] args) {
     //   System.out.println("hello mvn");
        Faker faker = new Faker();


       /* System.out.println(faker.name().name());
        System.out.println(faker.phoneNumber().phoneNumber());
        System.out.println(faker.address().streetAddress());*/

        WebDriverManager.chromedriver().setup();
       // WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys(faker.name().name()+ Keys.ENTER);


    }
}
