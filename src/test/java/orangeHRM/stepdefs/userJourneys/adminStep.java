package orangeHRM.stepdefs.userJourneys;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import orangeHRM.pages.*;
import orangeHRM.utils.AutomationConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class adminStep {
    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    AddEmployeeOverlayPage addEmployeeOverlayPage = new AddEmployeeOverlayPage();
    UserPage userPage;

    @Given("^admin creates a new user with below details$")
    public void adminCreatesANewUserWithLoginDetails(DataTable table) {
        loginPage.LoginAsAdmin();
        dashBoardPage.expandPIMMenu();
        dashBoardPage.selectAddEmployee();
        addEmployeeOverlayPage.fillTheForm(table);
        addEmployeeOverlayPage.save();
        loginPage.waitForElement(By.id("small-title"));
    }

    @When("^admin logsOut$")
    public void logOut() {
        dashBoardPage.logOut();
    }

    @Then("^new user can login$")
    public void UserCanLogin() {
        loginPage.Login(addEmployeeOverlayPage.newUser_uid, addEmployeeOverlayPage.newUser_pwd);
        assertEquals(dashBoardPage.getLoggedInUserName(), "test1 last");

    }

    @Given("^user changes his name$")
    public void userChangesHisName() {
        loginPage.Login(AutomationConstants.userUid, AutomationConstants.userPwd);
        userPage = new UserPage();
//        assertTrue(userPage.mainMenu.isDisplayed());
        userPage.myInfo();
        EmployeeDetailsPage detailsPage = new EmployeeDetailsPage();
        detailsPage.setFirstName("James lock");
        detailsPage.save();
        userPage.logOut();
    }

    @Then("^Admin can see updated name$")
    public void adminCanSeeUpdatedName() {
        loginPage.LoginAsAdmin();
        dashBoardPage.expandPIMMenu();
        dashBoardPage.selectEmployeeList();
        EmployeeListPage employeeListPage = new EmployeeListPage();
        employeeListPage.search("James lock emp2");
        assertTrue(employeeListPage.isEmplyoeeDisplayed("James lock"));
    }

    @Given("^Admin adds a new location$")
    public void adminAddsANewLocation() {
        loginPage.LoginAsAdmin();
        dashBoardPage.expandAdminMenu();
        dashBoardPage.expandOrganizationMenu();
        dashBoardPage.selectLocationsLink();
        LocationsPage locationsPage = new LocationsPage();
        locationsPage.addLocation();
        locationsPage.fillDetails("n", "India", "Asia/Calcutta", "c", "z");
        locationsPage.save();
        //assertTrue(dashBoardPage.adminTab.isDisplayed());
    }

    @Then("^new location is visible in the Add Employee overlay$")
    public void newLocationIsVisibleInTheAddEmployeeOverlay() {

    }

    @Given("^Admin changes the status to Disabled$")
    public void adminChangesTheStatusToDisabled() {
        loginPage.LoginAsAdmin();
        dashBoardPage.expandAdminMenu();
        dashBoardPage.selectUsersLink();
        SystemUsersPage usersPage = new SystemUsersPage();
        usersPage.editUser();
        usersPage.changeStatus("Disabled");
        dashBoardPage.logOut();
    }

    @Then("^User cannot login$")
    public void userCannotLogin() {
        loginPage.Login(AutomationConstants.user1Uid, AutomationConstants.user1Pwd);
        assertEquals(loginPage.getUrl(), AutomationConstants.loginInvalidCredentialsURL);
    }

    @Given("^Admin changes the status to Enabled$")
    public void adminChangesTheStatusToEnabled() {
        loginPage.LoginAsAdmin();
        dashBoardPage.expandAdminMenu();
        dashBoardPage.selectUsersLink();
        SystemUsersPage usersPage = new SystemUsersPage();
        usersPage.editUser();
        usersPage.changeStatus("Enabled");
        dashBoardPage.logOut();
    }

    @Then("^User can login$")
    public void userCanLogin() {
        loginPage.Login(AutomationConstants.user1Uid, AutomationConstants.user1Pwd);
        assertEquals(dashBoardPage.getLoggedInUserName(), "John smith");
    }

    @Given("^Admin access user details$")
    public void adminAccessAUserDetails() {
        loginPage.LoginAsAdmin();
        dashBoardPage.selectEmployeeList();
        EmployeeListPage employeeListPage = new EmployeeListPage();
        //employeeListPage.search("John smith");
        employeeListPage.selectAnEmployee("John smith");
    }

    @When("^Admin adds a supervisor to user$")
    public void adminAddsASupervisorToUser()  {
        EmployeeDetailsPage detailsPage = new EmployeeDetailsPage();
        detailsPage.selectReportTo();
        detailsPage.addSupervisor(AutomationConstants.superVisor);
        assertTrue(detailsPage.getUrl().contains("employee_reportto"));
        dashBoardPage.logOut();
    }

    @Then("^supervisor can access the user$")
    public void supervisorShouldSeeTheAddedUser(){
        loginPage.Login(AutomationConstants.superVisorUid, AutomationConstants.superVisorPwd);
        assertEquals(dashBoardPage.getLoggedInUserName(), "Nathan Raj");
        UserPage userPage = new UserPage();
        assertEquals(userPage.getUserName(), "Nathan Raj");
        System.out.println(userPage.getUserJOb());
        assertTrue(userPage.getUserJOb().contains("IT Manager"));

        userPage.accessEmployeeList();
        EmployeeListPage employeeListPage = new EmployeeListPage();
        assertEquals(employeeListPage.getUrl(), AutomationConstants.employeeList_URL);
        employeeListPage.search("John smith");
        assertTrue(employeeListPage.isEmplyoeeDisplayed("John smith"));
    }

    @When("^Admin removes a supervisor$")
    public void adminRemovesASupervisor()  {
        EmployeeDetailsPage detailsPage = new EmployeeDetailsPage();
        detailsPage.selectReportTo();
        assertTrue(detailsPage.getUrl().contains("employee_reportto"));
        //detailsPage.deleteSupervisor();
        System.out.println(detailsPage.getSupervisorsCount());
        //assert that supervisor deleted
        //admin logs out
        dashBoardPage.logOut();
    }

    @Then("^supervisor cannot see PIM menu when he logs in$")
    public void supervisorCannotSeePIMMenuWhenHeLogsIn()  {
        // log in as user
        // verify that pim is not visible
        loginPage.Login(AutomationConstants.superVisorUid, AutomationConstants.superVisorPwd);
        assertEquals(dashBoardPage.getLoggedInUserName(), "Nathan Raj");
        UserPage userPage = new UserPage();
        assertEquals(userPage.getUserName(), "Nathan Raj");
        assertFalse(userPage.isPIMMenuDisplayed());
    }

    @When("^Admin adds a job to the user$")
    public void adminAddJobToTheUser() {
        EmployeeDetailsPage detailsPage = new EmployeeDetailsPage();
        detailsPage.selectJobMenu(); // use consistent naming convention
        assertTrue(detailsPage.getUrl().endsWith("job"));
        detailsPage.fillJobDetails("QA Engineer", "Full-Time Permanent", "Australia");
        dashBoardPage.logOut();

    }

    @Then("^user should be able to access job details$")
    public void useShouldBeAbleToAccessJobDetails()  {
        loginPage.Login(AutomationConstants.user1Uid, AutomationConstants.user1Pwd);
        assertEquals(dashBoardPage.getLoggedInUserName(), "John smith");
        //todo- verify that user can see updated details
    }
}