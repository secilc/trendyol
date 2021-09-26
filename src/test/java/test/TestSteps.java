package test;

import io.cucumber.java.en.And;
import test.Pages.HomePage;
import test.Pages.LoginPage;
import io.cucumber.java.en.Given;

import java.io.IOException;

public class TestSteps extends TestRunner {

    @Given("^open homepage$")
    public void open_homepage() {
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage();

    }

    @And("^click boutique links$")
    public void click_boutique_links() throws IOException {
        HomePage homePage = new HomePage(driver);
        homePage.checkLinks();
    }

    @Given("^go to login page$")
    public void go_to_login_page() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();

    }

//    @And("^enter email and password$")
//    public void enter_email_and_password() {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.login();
//
//    }


}
