package testng;

import org.testng.annotations.Test;

public class DependinciesTestNG {


    @Test
    public void login(){
        System.out.println("Logging in...");
    }
     @Test(dependsOnMethods = "login")
    public void makePurchase(){
         System.out.println("making the purchase...");
     }

     @Test
    public void homePage(){
         System.out.println("Home page tested");
     }
}
