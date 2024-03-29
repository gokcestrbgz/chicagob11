package StarbugzProject;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class RabiaStrabugzDeals {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        dealsHotelOnly();
       // dealsCarsOnly();
       // dealsThingsToDo();
    }

    public static void dealsHotelOnly()throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.orbitz.com");
        WebElement deals = driver.findElement(By.id("primary-header-deals"));
        deals.click();
        Faker faker = new Faker();
        // when click the "Deals" we need to see "Hotel Only " option by default.
        //
        WebElement hotelOnly = driver.findElement(By.xpath("//a[@href='javascript:void(0)'][1]"));
        String destination = faker.address().cityName();
        WebElement inputDestination = driver.findElement(By.xpath("//input[@id='H-destination']"));
        inputDestination.sendKeys(destination);
        if(inputDestination.isDisplayed())  {
            System.out.println("Destination is selected, verification PASSED!");
        } else{
            System.out.println("Destination is NOT selected, verification FAILED!");
        }

        //User should passed valid date- Date should not accept past days
        WebElement checkInDate = driver.findElement(By.name("InDate"));
        String selectCheckInDate =  "8/8/2019";
        checkInDate.sendKeys(selectCheckInDate);
        if(checkInDate.isDisplayed()){
            System.out.println("Check-In Date is selected, verification PASSED!");
        }    else{
            System.out.println("Check-In Date is NOT selected, verification FAILED!");
        }

        //Check-Out date shoul be after Check-in date , it should select  1 after day by default
        WebElement checkOutDate = driver.findElement(By.name("OutDate"));
        checkOutDate.click();
       // Thread.sleep(3000);
        checkOutDate.findElement(By.xpath("//button[@data-day='30']")).click();
        if(checkOutDate.isDisplayed()) {
            System.out.println("Check-Out Date is selected, verification PASSED!");
        } else{
            System.out.println("Check-Out Date is NOT selected, verification FAILED!");
        }
        // String selectCheckOutDate = "10/8/2019";
        //  checkOutDate.sendKeys(selectCheckOutDate);

        WebElement rooms = driver.findElement(By.id("NumRoom"));
        //it should choose "1" by default
        Select roomsDropdown = new Select(rooms);
        String firstSelectedOption =  roomsDropdown.getFirstSelectedOption().getText();
        roomsDropdown.selectByValue("1");


        //it should give 2 by default
        WebElement adultsPlus18 = driver.findElement(By.id("NumAdult1"));
        Select adultsSelectDropdown = new Select(adultsPlus18);
        String adultsPlus18SelectedOption = adultsSelectDropdown.getFirstSelectedOption().getText();
        adultsSelectDropdown.selectByValue("1");
        if(adultsPlus18.isDisplayed())     {
            System.out.println("Aduld verification is Passed");
        }  else{
            System.out.println("Aduld verification is Failed!!");
        }

        //it should choose "0" by default
        WebElement children = driver.findElement(By.xpath("//select[@id='NumChild1'][1]"));
        Select childsSelectDropdown = new Select(children);
        String childSelectedOption = childsSelectDropdown.getFirstSelectedOption().getText();
        childsSelectDropdown.selectByValue("0");

        //user should see "Advance options
        //WebElement advanceOption = driver.findElement(By.xpath("//button[@class='btn-text toggle-trigger open']"));
        //advanceOption.click();

        //after click "Advance option" user should be able to input "Hotel Name"
        //WebElement hotelName = driver.findElement(By.id("ChainName"));
        //String inputHotelName = "hotel";

        //after inputs all options user should be able to click "search"
        WebElement searchButton = driver.findElement(By.id("H-searchButtonExt1"));
        searchButton.click();

    }

    public static void dealsThingsToDo(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.orbitz.com");
        WebElement deals = driver.findElement(By.id("primary-header-deals"));
        deals.click();
        Faker faker = new Faker();

        WebElement thingsToDo = driver.findElement(By.xpath("(//span[@class='tab-label'])[5]"));
        thingsToDo.click();


        WebElement inputDestination = driver.findElement(By.id("A-destination"));
        inputDestination.sendKeys("Chicago");
        WebElement weeklyDealsButton = driver.findElement(By.id("widgetcatalogWizard"));
        weeklyDealsButton.click();

        WebElement fromDate = driver.findElement(By.id("A-fromDate"));
        String selectCheckInDate = "7/8/2019";
        fromDate.sendKeys(selectCheckInDate);

        WebElement toDate = driver.findElement(By.id("A-toDate"));
        toDate.click();
        toDate.findElement(By.xpath("//button[@data-day='22']")).click();


        WebElement searchButton = driver.findElement(By.id("A-searchButtonExt1"));
        searchButton.click();

    }

    public static void dealsCarsOnly(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.orbitz.com");
        WebElement deals = driver.findElement(By.id("primary-header-deals"));
        deals.click();
        Faker faker = new Faker();

        WebElement carsOnly = driver.findElement(By.xpath("(//span[@class='tab-label'])[4]"));
        carsOnly.click();

        WebElement pickingUp = driver.findElement(By.id("C-destination"));
        pickingUp.sendKeys("California");

        WebElement droppingOff = driver.findElement(By.id("C-dropOffLocation"));
        droppingOff.sendKeys("Chicago");

        WebElement pickUpTime = driver.findElement(By.id("PickupTime"));

        WebElement pickUpDate = driver.findElement(By.id("C-fromDate"));
        pickUpDate.click();
        pickUpDate.findElement(By.xpath("(//button[@data-day='8'])[1]")).click();


        WebElement dropOffDate = driver.findElement(By.id("C-toDate"));
        dropOffDate.click();
        dropOffDate.findElement(By.xpath("(//button[@data-day='30'])[2]")).click();

        WebElement searchButton = driver.findElement(By.id("C-searchButtonExt1"));
        searchButton.click();

    }

}
