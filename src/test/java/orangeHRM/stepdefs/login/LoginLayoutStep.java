package orangeHRM.stepdefs.login;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import orangeHRM.pages.LoginPage;
import orangeHRM.utils.AutomationConstants;
import orangeHRM.utils.BrowserFactory;
import org.junit.After;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class LoginLayoutStep {

    private LoginPage loginPage = new LoginPage();

    @Before
    public void setUp(){
        BrowserFactory.startBrowser();
    }

    @After
    public void cleanUp(){
        BrowserFactory.stopBrowser();
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

    @When("^I select on the \"([^\"]*)\"$")
    public void clickOnLinks(String links) {

        if (links.contains("linkedin")) {
            loginPage.linkedInLnk.click();
        } else if (links.contains("facebook")) {
            loginPage.faceBookLnk.click();
        } else if (links.contains("twitter")) {
            loginPage.twitterLnk.click();
        } else if (links.contains("youtube")) {
            loginPage.youTubeLnk.click();
        }
    }

    @Then("^\"([^\"]*)\" should be open$")
    public void socialNetworkSitesShouldOpen(String page) {
        //assert that sites open
        loginPage.switchToNewTab();
        assertTrue(loginPage.getUrl().contains(page));
        loginPage.switchToDefaultTab();
    }

    @Then("^I should see \"([^\"]*)\" as per the design$")
    public void iShouldSeeAsPerTheDesign(String arg0) {
        //assert that images are displayed as expected and they are links
        assertTrue(loginPage.linkedInImg.isDisplayed());
        assertTrue(loginPage.faceBookImg.isDisplayed());
        assertTrue(loginPage.twitterImg.isDisplayed());
        assertTrue(loginPage.youTubeImg.isDisplayed());
    }
}