package orangeHRM.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    private static WebDriver driver;
    static Logger logger = Logger.getLogger(BrowserFactory.class);

    public static void startBrowser() {

        if (driver != null) return;

        if (AutomationConstants.REMOTE_BROWSER.equalsIgnoreCase("true")) {
            logger.info("grid started in SauceLabs...");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            String browser = "chrome";
            if (System.getProperty("Browser") != null) {
                browser = System.getProperty("Browser");
            }
            if (browser.equalsIgnoreCase("firefox")) {
                capabilities = DesiredCapabilities.firefox();

            } else if (browser.equalsIgnoreCase("chrome")) {
                capabilities = DesiredCapabilities.chrome();
            }
            capabilities.setPlatform(Platform.WINDOWS);
            capabilities.setVersion("48");
            URL url = null;
            try {
                url = new URL(AutomationConstants.SELENIUM_GRID_URL);
                driver = new RemoteWebDriver(url, capabilities);
                logger.info("driver created");
                driver.get(AutomationConstants.URL);
                logger.info("title is " + driver.getTitle());
            } catch (Exception e) {
                logger.info("error creating the remote driver");
                e.printStackTrace();
                logger.error(e.getMessage());
                return;
            }

        } else {
            logger.info("Starting tests in local browsers...");
            String path = System.getProperty("user.dir") + "/src/main/resources/Browsers/";
            logger.info(path);
            if (AutomationConstants.BROWSER_TYPE.equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver", path + "geckodriver.exe");
                driver = new FirefoxDriver();
            } else if (AutomationConstants.BROWSER_TYPE.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", path + "chromedriver.exe");
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                driver = new ChromeDriver(capabilities);
            } else if (AutomationConstants.BROWSER_TYPE.equalsIgnoreCase("IE")) {
                System.setProperty("webdriver.ie.driver", path + "IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            } else if (AutomationConstants.BROWSER_TYPE.equalsIgnoreCase("Safari")) {
                System.setProperty("webdriver.ie.driver", path + "SafariDriver.exe");
                driver = new SafariDriver();
            }
        }
        driver.manage().deleteAllCookies();
        driver.get(AutomationConstants.URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static void stopBrowser() {
        if (driver != null) {
            driver.close();
            driver.quit();
            driver = null;
            logger.info("closing the local browsers");
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            BrowserFactory.startBrowser();
        }
        return driver;
    }
}