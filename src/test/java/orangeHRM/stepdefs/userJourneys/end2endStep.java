package orangeHRM.stepdefs.userJourneys;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import orangeHRM.pages.*;
import orangeHRM.utils.AutomationConstants;
import orangeHRM.utils.BrowserFactory;
import org.junit.After;
import org.openqa.selenium.By;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class end2endStep {
    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    AddEmployeeOverlayPage addEmployeeOverlayPage = new AddEmployeeOverlayPage();
    SystemUsersPage usersPage;

    @Before
    public void setUp(){
        BrowserFactory.startBrowser();
    }

    @After
    public void cleanUp(){
        BrowserFactory.stopBrowser();
        System.out.println("closing the browser");
    }

    @Given("^Admin logsIn$")
    public void adminLogsIn() {
        loginPage.open();
        assertEquals(AutomationConstants.URL, loginPage.isInLoginPage());
        loginPage.LoginAsAdmin();
        assertTrue(loginPage.getUrl().endsWith("dashboard/index"));
    }

    @Given("^admin creates a new user with below details$")
    public void adminCreatesANewUserWithLoginDetails(DataTable table) {
        dashBoardPage.expandPIMMenu();
        dashBoardPage.selectAddEmployee();
        addEmployeeOverlayPage.fillTheForm(table);
        addEmployeeOverlayPage.save();
        loginPage.waitForElement(By.id("small-title"));
    }

    @And("^admin creates a new user role \"([^\"]*)\"$")
    public void adminCreateANewUserRole(String newRoleName) {
        dashBoardPage.expandAdminMenu();
        dashBoardPage.selectUsersRoleLink();
        assertTrue(dashBoardPage.getUrl().endsWith("admin/user_roles"));
        UserRolesPage rolesPage = new UserRolesPage();
        rolesPage.addUserRole();

        assertTrue(dashBoardPage.getUrl().endsWith("admin/add_user_role"));
        AddUserRolePage userRolePage = new AddUserRolePage();
        userRolePage.createUserRole(newRoleName);
        assertTrue(rolesPage.isRoleAdded(newRoleName));
        //assert that new role is displayed
    }

    @When("^admin assigns the new user role \"([^\"]*)\" to newly created user$")
    public void adminAssignsTheNewUserRoleToNewlyCreatedUser(String newRole) {
        dashBoardPage.expandAdminMenu();
        dashBoardPage.selectUsersLink();
        usersPage = new SystemUsersPage();
        usersPage.editUser(addEmployeeOverlayPage.newUser_uid);
        EditUserPage editUserPage = new EditUserPage();
        editUserPage.addRoleToUser(newRole);
    }

    @Then("^\"([^\"]*)\" role should be added to the user$")
    public void roleShouldBeAddedToTheUser(String newRole) {
        System.out.println("newly created user name is " + addEmployeeOverlayPage.newUser_uid);
        String roles = usersPage.getUserRole(addEmployeeOverlayPage.newUser_uid);
        assertTrue(roles.contains(newRole));
    }

    @When("^admin deletes role \"([^\"]*)\"$")
    public void adminDeletesRole(String role) {
        dashBoardPage.selectUsersRoleLink();
        assertTrue(dashBoardPage.getUrl().endsWith("admin/user_roles"));
        UserRolesPage rolesPage = new UserRolesPage();
        rolesPage.deleteRole(role);
    }

    @Then("^\"([^\"]*)\" role should be removed from user$")
    public void roleShouldBeRemovedFromUser(String role) {
        //dashBoardPage.expandAdminMenu();
        dashBoardPage.selectUsersLink();
        usersPage = new SystemUsersPage();
        String roles = usersPage.getUserRole(addEmployeeOverlayPage.newUser_uid);
        System.out.println("after deletion roles " + roles);
        assertFalse(roles.contains(role));
    }


}