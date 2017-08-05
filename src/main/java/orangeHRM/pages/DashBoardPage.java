package orangeHRM.pages;

import orangeHRM.utils.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DashBoardPage extends BasePage {
    @FindBy(xpath = "//li[@id='menu_admin_viewAdminModule']")
    WebElement adminTab;
    @FindBy(xpath = "//li[@id='menu_admin_UserManagement']")
    WebElement usersManagementLink;
    @FindBy(xpath = "//a[@id='menu_admin_viewSystemUsers']")
    WebElement usersLink;
    @FindBy(xpath = "//a[@id='menu_admin_viewUserRoles']")
    WebElement userRoleLink;
    @FindBy(xpath = "//li[@id='menu_admin_Organization']")
    public WebElement organizationTab;
    @FindBy(xpath = "//a[@id='menu_admin_viewLocations']")
    public WebElement locationsLink;
    @FindBy(xpath = "//li[@id='menu_pim_viewPimModule']")
    WebElement pimTab;
    @FindBy(xpath = "//a[@id='menu_pim_viewEmployeeList']")
    public WebElement empListLink;
    @FindBy(xpath = "//a[@id='menu_pim_addEmployee']")
    public WebElement addEmpLink;
    @FindBy(xpath = "//div[@id='menu-profile']/a/span[2]")
    private WebElement userMenu;
    @FindBy(xpath = "//a[@id='user-dropdown']/span[1]")
    WebElement userName;
    @FindBy(linkText = "Logout")
    WebElement logOut;

    public void expandPIMMenu() {
        driver.switchTo().frame("noncoreIframe");
        pimTab.click();
    }

    public void expandAdminMenu() {
        adminTab.click();
    }

    public void selectUsersLink() {
        usersManagementLink.click();
        usersLink.click();
    }

    public void selectUsersRoleLink() {
        usersManagementLink.click();
        waitForElement(By.id("menu_admin_viewUserRoles"));
        userRoleLink.click();
        sleep(); //todo- add wait for some element instead of sleep
    }

    public void expandOrganizationMenu() {
        organizationTab.click();
    }

    public void selectLocationsLink() {
        locationsLink.click();
    }

    public void selectAddEmployee() {
        addEmpLink.click();
    }

    public void selectEmployeeList() {
        expandPIMMenu();
        new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menu_pim_viewEmployeeList']")));
        empListLink.click();
    }

    public void logOut() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("user-dropdown")));
        // TODO- tried all other wait but only thread sleep is working-fix it
        sleep();
        userMenu.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_menu")));
        logOut.click();
    }

    public String getLoggedInUserName() {
        driver.switchTo().frame("noncoreIframe");
        return userName.getText();
    }
}