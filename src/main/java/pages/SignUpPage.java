package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage{

    public SignUpPage(WebDriver driver) {
        super.driver = driver;
    }

    @Override
    void openUrl() {
        driver.get("https://automationexercise.com/signup");
    }

    private static final By ENTERACCOUNTINFO = By.xpath("//h2/b[text()='Enter Account Information']");
    private static final By ACCOUNTCREATED = By.xpath("//h2/b[text()='Account Created!']");
    private static final By TITLEMR= By.id("id_gender1");
    private static final By TITLEMRS= By.id("id_gender1");
    private static final By PASSWORD= By.cssSelector("input[data-qa='password']");
    private static final By DAYS= By.cssSelector("select[data-qa='days']");
    private static final By MONTH= By.cssSelector("select[data-qa='months']");
    private static final By YEARS= By.cssSelector("select[data-qa='years']");
    private static final By SIGNUPCHECKBOX= By.id("newsletter");
    private static final By SPECIALOFFERCHECKBOX= By.id("optin");
    private static final By FIRSTNAME= By.id("first_name");
    private static final By LASTNAME= By.id("last_name");
    private static final By COMPANYNAME= By.id("company");
    private static final By ADDRESS= By.id("address1");
    private static final By ADDRESS2= By.id("address2");
    private static final By COUNTRY= By.id("country");
    private static final By STATE= By.id("state");
    private static final By CITY= By.id("city");
    private static final By ZIPCODE= By.id("zipcode");
    private static final By MOBILENUMBER= By.id("mobile_number");
    private static final By CREATEACCOUNTBUTTON= By.cssSelector("button[data-qa='create-account']");



    public boolean checkSignupPageLoaded() {
        return checkPageLoaded(ENTERACCOUNTINFO,"Enter Account Information");
    }
    public boolean checkAccountCreated() {
        return getWebElementText(ACCOUNTCREATED).equalsIgnoreCase("ACCOUNT CREATED!");
    }

    public void selectGenderTitleRadioButton(String title){
        if(title.equalsIgnoreCase("Mr.")){
        clickToElement(TITLEMR);
        } else if (title.equalsIgnoreCase("Mrs.")){
            clickToElement(TITLEMRS);
        }
    }

    public boolean checkIsTitleMrSelected(){
       return checkIfElementSelected(TITLEMR);
    }
    public boolean checkIsTitleMrsSelected(){
      return checkIfElementSelected(TITLEMRS);
    }
    public void fillInPassword(String name) {
        fillInField(PASSWORD, name);
    }
    public void selectDayDropdown(String day){
        selectDropdownElementByText(DAYS, day);
    }
    public void selectMonthDropdown(String month){
        selectDropdownElementByText(MONTH, month);
    }
    public void selectYearDropdown(String year){
        selectDropdownElementByText(YEARS, year);
    }

    public void selectSignUpNewsletter(){
        clickToElement(SIGNUPCHECKBOX);
    }

    public void selectSpecialOffer(){
        clickToElement(SPECIALOFFERCHECKBOX);
    }
    public void fillInFirstName(String name) {
        fillInField(FIRSTNAME, name);
    }
    public void fillInLASTName(String lastName) {
        fillInField(LASTNAME, lastName);
    }
    public void fillInCompany(String company) {
        fillInField(COMPANYNAME, company);
    }
    public void fillInAddress(String address) {
        fillInField(ADDRESS, address);
    }
    public void fillInAddress2(String address2) {
        fillInField(ADDRESS2, address2);
    }
    public void selectCountry(String country){
        selectDropdownElementByText(COUNTRY, country);
    }
    public void fillInState(String state) {
        fillInField(STATE, state);
    }
    public void fillInCity(String city) {
        fillInField(CITY, city);
    }
    public void fillInZipcode(String zipcode) {
        fillInField(ZIPCODE, zipcode);
    }
    public void fillInMobile(String mobileNumber) {
        fillInField(MOBILENUMBER, mobileNumber);
    }
    public void clickCreateAccountButton(){
        clickToElement(CREATEACCOUNTBUTTON);
    }

}
