package test.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    String baseURL = "https://www.trendyol.com/giris?";
    private By usernameBy = By.id("login-email");
    private By passwordBy = By.id("login-password");
    private By submitButtonBy = By.cssSelector("button[type='submit']");
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public LoginPage goToLoginPage() {

        driver.get(baseURL);
        return this;
    }

    public LoginPage login(String username, String password) {
        sendKeyBy(usernameBy, username);
        sendKeyBy(passwordBy, password);
        clickBy(submitButtonBy);
        return new LoginPage(driver);
    }

}
