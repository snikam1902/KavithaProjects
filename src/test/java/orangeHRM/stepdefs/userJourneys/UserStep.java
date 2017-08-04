package orangeHRM.stepdefs.userJourneys;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import orangeHRM.pages.DashBoardPage;
import orangeHRM.pages.LoginPage;
import orangeHRM.pages.UserPage;
import orangeHRM.pages.user.ApplyLeavePage;
import orangeHRM.pages.user.LeaveListPage;
import orangeHRM.utils.AutomationConstants;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class UserStep {

    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    UserPage userPage;

    @Given("^User applies for a leave$")
    public void userAppliesForALeave() {
        loginPage.Login(AutomationConstants.user1Uid, AutomationConstants.user1Pwd);
        assertEquals(dashBoardPage.getLoggedInUserName(), "John smith");
        userPage = new UserPage();
        //userPage.applyLeaveLink();
        //assertTrue(userPage.getUrl().endsWith("leave/apply"));
        //ApplyLeavePage leavePage = new ApplyLeavePage();
        //leavePage.fillForm();
        dashBoardPage.logOut();
    }

    @When("^Supervisor accepts the leave$")
    public void supervisorAcceptsTheLeave() {
        loginPage.Login(AutomationConstants.superVisorUid, AutomationConstants.superVisorPwd);
        assertEquals(dashBoardPage.getLoggedInUserName(), "Nathan Raj");
        UserPage userPage = new UserPage();
        assertEquals(userPage.getUserName(), "Nathan Raj");
       // assertEquals(userPage.getLeaveNotificationRequests(), "1");
        userPage.selectLeaveList();
        assertTrue(userPage.getUrl().endsWith("leave/view_leave_list"));
        //LeaveListPage leavePage = new LeaveListPage(); //todo- refactor the name
        //leavePage.approveLeave();
        //accept the leave request
        dashBoardPage.logOut();
    }

    @Then("^User can see updated information$")
    public void userCanSeeUpdatedInformation() {
        //verify that user can see the acceptance.
        loginPage.Login(AutomationConstants.user1Uid, AutomationConstants.user1Pwd);
        assertEquals(dashBoardPage.getLoggedInUserName(), "John smith");
        userPage = new UserPage();
        userPage.selectMyLeaveList();
        assertTrue(userPage.getUrl().endsWith("leave/view_my_leave_list"));  // this user leave list
        LeaveListPage leavePage = new LeaveListPage();
        assertEquals(leavePage.getStatus(), "Scheduled(4.00)");
    }
}