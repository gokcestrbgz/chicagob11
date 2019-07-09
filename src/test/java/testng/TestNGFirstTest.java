package testng;

import org.testng.Assert;
import org.testng.annotations.*;


public class TestNGFirstTest {

    @BeforeClass
    public void setUp(){
        System.out.println("Before class runnig");
    }
    @AfterClass
    public void tearDown(){
        System.out.println("After class is runnig");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method is running...");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method runnig");
    }

    @Test
    public void firstTest(){
        System.out.println("This is the firs test runnig.");

        Assert.assertEquals("a","a","first test a-b is failed");

       /* if("a".equals("b")){
            System.out.println("verification passed");
        }else{
            System.out.println("verification failed");
        }*/

    }
    @Test
    public void secondTest(){
        System.out.println("This is the second test running.");
    }

    @Test
    public void titleTest(){
        String actualTitle ="Google - Apples";
        String expectedTitleContains ="apples";
        Assert.assertTrue(actualTitle.contains(expectedTitleContains),"Actual title does not contain expected value.");
    }
    @Test
    public void onPurposeFail(){
        Assert.fail("This id on purposefail");
    }

}
