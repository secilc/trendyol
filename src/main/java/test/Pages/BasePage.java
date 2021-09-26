package test.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

public class BasePage {
//    did not use these
//    private static final int TIMEOUT = 5;
//    private static final int POLLING = 100;

    WebDriver driver;
    private FluentWait<WebDriver> wait;

//    Ajax waiter ?
//    public BasePage(WebDriver driver) {
//        this.driver = driver;
//        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
//        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
//    }

//    Fluent wait
    BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMillis(5000))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class);

    }


    void waitForElementToAppear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    void clickBy(By byLocator) {
        waitForElementToAppear(byLocator);
        WebElement el = driver.findElement(byLocator);
        el.click();
    }

    void sendKeyBy(By byLocator, String text) {
        waitForElementToAppear(byLocator);
        WebElement el = driver.findElement(byLocator);
        el.sendKeys(text);
    }

    WebElement untilWaitElementPresence(By byLocator) {
        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(byLocator));
        return el;
    }

}
