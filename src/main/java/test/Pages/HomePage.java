package test.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HomePage extends BasePage {

    String baseURL = "https://www.trendyol.com";
    // create a new ArrayList
    private static List<String> links
            = new ArrayList<String>();

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public HomePage goToHomePage() {

        driver.get(baseURL);
        getBoutiques();
        return this;
    }


    public void getBoutiques() {

        System.out.println("GETTING BOUTIQUES");
        List<WebElement> list = driver.findElements(By.cssSelector("[data-enhanced*=\"Butik Banner\"]"));
        for(WebElement el : list) {
            links.add(el.getAttribute("href"));
        }
        System.out.println(links);

    }

    public HomePage checkLinks() throws IOException {
        for (String link : links) {
//            Open links and check log from selenium logger
//            driver.get(link);
//            getLogs(link);

//            Check links with restassure
            int statusCode = new HttpResponseCode().httpResponseCodeViaGet(link);
            System.out.println(
                    "---------- response for "
                            + link + ": " + statusCode);
        }
        return this;

    }


    public void getLogs(){
        System.out.println("GETTING LOGS - this only works with chrome");
        String currentURL = driver.getCurrentUrl();

        LogEntries logs = driver.manage().logs().get("performance");

        int status = -1;

        System.out.println("\nList of log entries:\n");

        for (Iterator<LogEntry> it = logs.iterator(); it.hasNext();)
        {
            LogEntry entry = it.next();

            try
            {
                JSONObject json = new JSONObject(entry.getMessage());
                JSONObject message = json.getJSONObject("message");
                String method = message.getString("method");

                if (method != null
                        && "Network.responseReceived".equals(method))
                {
                    JSONObject params = message.getJSONObject("params");

                    JSONObject response = params.getJSONObject("response");
                    String messageUrl = response.getString("url");

                    if (messageUrl.equals(currentURL))
                    {
                        status = response.getInt("status");

                        System.out.println(
                                "---------- response for "
                                        + messageUrl + ": " + status);
                    }
                }

            } catch (JSONException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}
