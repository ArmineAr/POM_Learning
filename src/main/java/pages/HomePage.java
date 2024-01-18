package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
//    WebDriver driver;  //TODO ????
    // OR we can extend the homePage from BasePage and write the driver there instead

   public HomePage(WebDriver driver){   //constructor to create homepage object
      super.driver=driver;
   }   // now this driver comes from the Base ?????

    @Override
    public void openUrl() {
    driver.get("https://automationexercise.com/");
    }

    private static final By WOMEN = By.partialLinkText("WOMEN");
    private static final By MEN = By.partialLinkText("MEN");
    private static final By KIDS = By.partialLinkText("KIDS");
    private static final By SIGNUPSIGNIN = By.partialLinkText("Signup");

// ??? why varibles with static and functions not statis ??? TODO

    public void clickToWomanCategory(){
    clickToElement(WOMEN);
    }
    public void clickToSignUpSignIn(){
        clickToElement(SIGNUPSIGNIN);
    }

}
