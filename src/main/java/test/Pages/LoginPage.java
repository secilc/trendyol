package test.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    String baseURL = "https://www.trendyol.com/giris?";
    private By usernameBy = By.cssSelector("[data-testid=\"email-input\"]");
    private By passwordBy = By.cssSelector("[data-testid=\"password-input\"]");
    private By submitButtonBy = By.cssSelector("button[type='submit']");
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public LoginPage goToLoginPage() {

        driver.get(baseURL);
        waitForElementToAppear(submitButtonBy);
        return this;
    }

    public LoginPage login(String username, String password) {
        sendKeyBy(usernameBy, username);
        sendKeyBy(passwordBy, password);
        clickBy(submitButtonBy);
        return this;
    }

}
