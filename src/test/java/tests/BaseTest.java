package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class BaseTest {

    static WebDriver driver;   //TODO ???

    @BeforeSuite
    void beforeSuite() {
        System.out.println("Before Suite");
    }

    @BeforeTest
    void beforeTest() {
        System.out.println("before test");
    }

    @AfterTest
    void afterTest() {
        System.out.println("after test");
    }

    @AfterSuite
    void afterSuite() {
        System.out.println("After suit");
    }

    @Parameters({"browser"})
    @BeforeMethod
    void setUpWebDriver(@Optional("chrome") String browser) {

//    we cant use this with Test NG because of the parameter, as test NG has its own parameters to set up in testng.xml
//    WebDriver setUpWebDriver(String browser){ // ?? TODO the only thing changed is Void????
        driver = null;
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        //  return driver;
    }


    void destroy(WebDriver driver) {
        driver.close();
    }
}
