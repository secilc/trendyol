package test;

import test.Drivers.Browser;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/test"
        //        tags = {"~@Ignore"}
        //        format = {
        //                "pretty",
        //                "html:target/cucumber-reports/cucumber-pretty",
        //                "json:target/cucumber-reports/json-reports/CucumberTestReport.json",
        //                "rerun:target/cucumber-reports/rerun-reports/rerun.txt"
                )
public class TestRunner extends AbstractTestNGCucumberTests{
    public static WebDriver driver;
    public TestNGCucumberRunner testNGCucumberRunner;

    @Parameters({"browser_name"})
    @BeforeClass(alwaysRun = true)
    public void setUpClass(String browser_name) throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());

        Browser browser = new Browser();
        browser.setUp(browser_name);
        driver = browser.getDriver();
        driver.manage().window().fullscreen();
    }

//    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
//    public void feature(CucumberFeatureWrapper cucumberFeature) {
//
//        testNGCucumberRunner.runScenario(cucumberFeature.getCucumberFeature());
//    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
        driver.quit();
    }
}
