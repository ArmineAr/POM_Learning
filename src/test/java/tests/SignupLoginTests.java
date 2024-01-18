package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.SignUpLoginPage;
import pages.SignUpPage;

public class SignupLoginTests extends BaseTest{

    @Test(priority = 1, enabled = true)
    void test1(){
        SoftAssert softAssert = new SoftAssert();
        // this is no longer needed as it is creaded in BaseTest and inherit from there
        // WebDriver driver= setUpWebDriver("chrome");
        HomePage homePage= new HomePage(driver);
        homePage.openUrl();
        homePage.clickToSignUpSignIn();

        SignUpLoginPage signUpLoginPage= new SignUpLoginPage(driver);
        Assert.assertTrue(signUpLoginPage.checkSignUPLoginPageLoaded()); // How to degub to see that its correct ??? TODO

        signUpLoginPage.fillInSignUpName("Armine");
        signUpLoginPage.fillInSignUpEmail("test+3@test.com");
        signUpLoginPage.clickSignUpButton();

        SignUpPage signUpPage= new SignUpPage(driver);
        Assert.assertTrue(signUpPage.checkSignupPageLoaded());

        signUpPage.selectGenderTitleRadioButton("Mrs.");
        Assert.assertTrue(signUpPage.checkIsTitleMrsSelected());

        signUpPage.fillInPassword("123");
        signUpPage.selectDayDropdown("16");
        signUpPage.selectMonthDropdown("August");
        signUpPage.selectYearDropdown("1989");

        signUpPage.selectSignUpNewsletter();
        signUpPage.selectSpecialOffer();
        signUpPage.fillInFirstName("armine");
        signUpPage.fillInLASTName("arel");
        signUpPage.fillInCompany("abs");
        signUpPage.fillInAddress("abs safaqq");
        signUpPage.fillInAddress2("1224");
        signUpPage.selectCountry("Israel");
        signUpPage.fillInState("DW");
        signUpPage.fillInCity("asfasfs");
        signUpPage.fillInZipcode("124124");
        signUpPage.fillInMobile("+3514124124");
        signUpPage.clickCreateAccountButton();
        Assert.assertTrue(signUpPage.checkAccountCreated());

    }
}
