package ohrm.com.stepdefs;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseStep {

    private WebDriver driver;

    @Before
    public void SetUp() throws MalformedURLException {
        boolean remotebrowser = true;
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "\\src\\test\\resources\\chromedriver.exe");
        if (remotebrowser == false) {
            if (driver == null) {
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
        } else {

            DesiredCapabilities caps = DesiredCapabilities.chrome();
            caps.setCapability("platform", "Windows 10");
            caps.setCapability("version", "59.0");


            String USERNAME = "kavithavinodreddy";
            String ACCESS_KEY = "4325a45a-75ac-4944-a475-4a8f22ea1b84";
            String sauceURL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
            System.out.println(sauceURL);
            driver = new RemoteWebDriver(new URL(sauceURL), caps);
        }
    }

    @After
    public void cleanUp() {
        driver.close();
        driver.quit();
        driver = null;
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}