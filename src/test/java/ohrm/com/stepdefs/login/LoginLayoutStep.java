package ohrm.com.stepdefs.login;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ohrm.com.Util;
import ohrm.com.pages.LoginPage;
import ohrm.com.stepdefs.BaseStep;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginLayoutStep {

    private BaseStep baseStep;
    private WebDriver driver;
    private LoginPage loginPage;

    public LoginLayoutStep(BaseStep bstep){
        baseStep = bstep;
        driver = baseStep.getDriver();
        loginPage = new LoginPage(driver);
    }

    @Given("^I am on the Login page$")
    public void openLoginPage()  {
        loginPage.open();
        assertEquals(Util.login_URL, baseStep.getDriver().getCurrentUrl());
    }

    @Then("^I should see the page as per the design$")
    public void checkLoginPageDesign() {
        assertTrue(loginPage.userName.isDisplayed());
        assertTrue(loginPage.password.isDisplayed());
        assertTrue(loginPage.loginBtn.isDisplayed());
        assertTrue(loginPage.linkedInLnk.isDisplayed());
        assertTrue(loginPage.faceBookLnk.isDisplayed());
        assertTrue(loginPage.twitterLnk.isDisplayed());
        assertTrue(loginPage.youTubeLnk.isDisplayed());
        //DO i need to compare all the titles and footer text here ?
    }

    @And("^I should see \"([^\"]*)\" as per the design$")
    public void verifyImages(String images)  {
        //do we need this step?
    }

    @When("^I click on the  \"([^\"]*)\"$")
    public void clickOnLinks(String links)  {
        System.out.println(links);

        if (links.contains("linkedin")){
            System.out.println("clicking linkedin");
            loginPage.linkedInLnk.click();

        }else if (links.contains("facebook")){
            loginPage.faceBookLnk.click();

        }else if (links.contains("twitter")){
            loginPage.twitterLnk.click();

        }else if (links.contains("youtube")){
            loginPage.youTubeLnk.click();

        }
    }

    @Then("^\"([^\"]*)\" should be open$")
    public void socialNetworkSitesShouldOpen(String page)  {
       //assert that sites open
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        if (page.contains("linkedin")){
            System.out.println("clicking linkedin");
            loginPage.linkedInLnk.click();
            browserTabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(browserTabs .get(1));
            assertTrue(baseStep.getDriver().getCurrentUrl().contains("www.linkedin.com"));
        }else if (page.contains("facebook")){
            loginPage.faceBookLnk.click();
            browserTabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(browserTabs .get(1));
            System.out.println(baseStep.getDriver().getCurrentUrl().contains("www.facebook.com"));
        }else if (page.contains("twitter")){
            loginPage.twitterLnk.click();
            browserTabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(browserTabs .get(1));
            System.out.println(baseStep.getDriver().getCurrentUrl().contains("www.twitter.com"));
        }else if (page.contains("youtube")){
            loginPage.youTubeLnk.click();
            browserTabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(browserTabs .get(1));
            System.out.println(baseStep.getDriver().getCurrentUrl().contains("www.youtube.com"));
        }
        //switch to new tab
        driver.switchTo().window(browserTabs.get(0));
    }

    @And("^I should see \"([^\"]*)\" as per the desing$")
    public void imagesShouldBeDisplayedAsPerDesign(String images) {
       //assert that images are displayed as expected and they are links
        assertTrue(loginPage.linkedInImg.isDisplayed());
        assertTrue(loginPage.faceBookImg.isDisplayed());
        assertTrue(loginPage.twitterImg.isDisplayed());
        assertTrue(loginPage.youTubeImg.isDisplayed());
    }
}
