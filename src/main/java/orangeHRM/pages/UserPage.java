package orangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Vinod on 24/07/2017.
 */
public class UserPage extends BasePage {

    @FindBy(xpath = "//div[@id='menu-content']/ul/li[1]/a/span[2]")
    WebElement myInfo;
    @FindBy(xpath = "//div[@id='menu-content']/ul/li/a/span[2]")
    List<WebElement> mainMenu;
    @FindBy(xpath = "//li[@id='menu_pim_viewPimModule']")
    WebElement pimMenu;
    @FindBy(xpath = "//li[@id='menu_leave_viewLeaveModule']")
    WebElement leaveMenu;
    @FindBy(xpath = "//a[@id='menu_leave_applyLeave']")
    WebElement leaveApply;
    @FindBy(xpath = "//a[@id='menu_pim_viewEmployeeList']")
    WebElement employeeList;
    @FindBy(xpath = "//div[@id='menu-profile']/a/span[2]")
    WebElement userMenu;
    @FindBy(xpath = "//a[@id='user-dropdown']/span[1]")
    WebElement userName;
    @FindBy(xpath = "//a[@id='user-dropdown']/span[2]")
    WebElement userJob;
    @FindBy(xpath = "//a[@id='dropDownLeave']/span[2]")
    WebElement leaveNotificationRequests;
    @FindBy(xpath = "//a[@id='menu_leave_viewLeaveList']")
    WebElement leaveListLink; // for supervisor
    @FindBy(xpath = "//a[@id='menu_leave_viewMyLeaveList']")
    WebElement myLeaveListLink; // for employee
    @FindBy(linkText = "Logout")
    private WebElement logOut;

    public void myInfo() {
        driver.switchTo().frame("noncoreIframe");
        myInfo.click();
    }

    public void pimMenu() {
        driver.switchTo().frame("noncoreIframe");
        pimMenu.click();
    }

    public void leaveMenu() {
        leaveMenu.click();
    }

    public void applyLeaveLink() {
        leaveMenu();
        leaveApply.click();
    }

    public String getLeaveNotificationRequests() {
        return leaveNotificationRequests.getText();
    }

    public void selectLeaveList() {
        leaveMenu();
        leaveListLink.click();
    }

    public void selectMyLeaveList(){
        leaveMenu();
        myLeaveListLink.click();
    }

    public void accessEmployeeList() {
        pimMenu.click();
        employeeList.click();
    }

    public boolean isPIMMenuDisplayed() {
        for (WebElement element : mainMenu) {
            if (element.getText().equalsIgnoreCase("PIM")) return true;
        }
        return false;
    }

    public String getUserName() {
        return userName.getText();
    }

    public String getUserJOb() {
        return userJob.getText();
    }

    public void logOut() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        userMenu.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_menu")));
        logOut.click();
    }
}