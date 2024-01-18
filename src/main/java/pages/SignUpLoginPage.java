package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpLoginPage extends BasePage {

    public SignUpLoginPage(WebDriver driver) {   //constructor to create homepage object, why WebDriver ??/ TODO
        super.driver = driver;
       // PageFactory.initElements(driver, this); this is in case we use page factory finby for elements
    }

    @Override
    void openUrl() {
        driver.get("https://automationexercise.com/login");
    }

    @FindBy(css = "div.signup-form h2")
    WebElement newUserSignUp;
    private static final By NEWUSERSIGNUP = By.cssSelector("div.signup-form h2");
    private static final By SIGNUPNAME = By.cssSelector("input[data-qa='signup-name']");
    private static final By SIGNUPEMAIl = By.cssSelector("input[data-qa='signup-email']");
    private static final By SIGNUPBUTTON = By.cssSelector("button[data-qa='signup-button']");


    public boolean checkSignUPLoginPageLoaded() {
        return checkPageLoaded(NEWUSERSIGNUP, "New User Signup!");
    }

    public void fillInSignUpName(String name) {
        fillInField(SIGNUPNAME, name);
    }

    public void fillInSignUpEmail(String email) {
        fillInField(SIGNUPEMAIl, email);
    }

    public void clickSignUpButton() {
        clickToElement(SIGNUPBUTTON);
    }

}