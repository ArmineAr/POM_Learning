package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    WebDriver driver;  // not to pass each time web driver as argument and creating new driver,
    //we create it here and the child pages inharits it
    Duration timeout= Duration.ofSeconds(10);

  abstract void openUrl(); // as its abstract is must be overridden in its children
    /// , we could also not declare it abstract

  WebElement getVisibleElement(By locator){
      WebDriverWait wait= new WebDriverWait(driver, timeout);
       return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    WebElement isElementVisible(By locator){
        WebDriverWait wait= new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    boolean checkElementExists(By locator){ // !!!if we call just find element it will give us Exception
      //and in accertion it cant work , so we user findElements() coz if there is no such element
        //instead of exceoption it will return us an EMPTY list, so if the list is not empty that the element exists
      return !driver.findElements(locator).isEmpty();
    }
   WebElement getWebElement(By locator){
        return driver.findElement(locator);
    }
    String getWebElementText(By locator){

      return driver.findElement(locator).getText();
    }
    public boolean checkPageLoaded(By locator, String text) {
        if(checkElementExists(locator)){
        return getWebElementText(locator).equalsIgnoreCase(text); }
        else return false;  // !!!! we put here false, not to get exception in which case we can't
        //do assertion in tests
    }
     void fillInField(By locator, String text){
      driver.findElement(locator).sendKeys(text);
    }

    void clickToElement(By locator) {
        getVisibleElement(locator).click();
    }

    boolean checkIfElementSelected(By locator) {
        return getVisibleElement(locator).isSelected();
    }

    void selectDropdownElementByText(By locator, String text) {
        Select select = new Select(getWebElement(locator)); // !!!!!
        select.selectByVisibleText(text);
    }
}
