package orangeHRM;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import orangeHRM.utils.BrowserFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/",
        tags = {"@login"},
        format = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"})
public class RunTest {
    @BeforeClass
    public static void openBrowser() {
        BrowserFactory.startBrowser();
    }

    @AfterClass
    public static void closeBrowser() {
        System.out.println("close the browser after the scenario");
        BrowserFactory.stopBrowser();
    }
}