package test;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import test.Pages.HomePage;
import test.Pages.LoginPage;
import io.cucumber.java.en.Given;

import java.io.IOException;
import java.util.List;

public class TestSteps extends TestRunner {

    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);


    @Given("^open homepage$")
    public void open_homepage() {
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage();

    }

    @And("^click boutique links$")
    public void click_boutique_links() throws IOException {
        homePage.checkLinks();
    }

    @Given("^go to login page$")
    public void go_to_login_page() {
        loginPage.goToLoginPage();

    }

    @Given("^enter email and password$")
    public void enter_my_email_and_password(DataTable table) throws Throwable {
        List<List<String>> data = table.asLists(String.class);
        System.out.println(data);
        String username = data.get(0).get(0);
        String password = data.get(0).get(1);

       loginPage.login(username,password);
    }


}
