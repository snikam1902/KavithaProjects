package ohrm.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DashBoardPage  extends  BasePage{

    @FindBy(how= How.XPATH, using="//div[@id='menu-content']/ul/li[2]")
    private WebElement pimMenu;

    @FindBy(how=How.XPATH, using="//*[@id='menu-content']/ul/li[2]/div/ul/li[2]") //refactor the xpath value
    public WebElement EmpListLink;

    @FindBy(how=How.XPATH, using="//*[@id='menu-content']/ul/li[2]/div/ul/li[3]") //refactor the xpath value
    public WebElement addEmpLink;

    @FindBy(how = How.ID, using="user-dropdown")
    private WebElement userMenu;

    @FindBy(how=How.LINK_TEXT, using="")
    private WebElement logOut;

    public DashBoardPage(WebDriver driver){
       super(driver);
    }

    public void expandPIMMenu(){
        if (!pimMenu.isDisplayed()){
            //WebDriverWait wait = new WebDriverWait(driver, 20);
            //WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_viewPimModule")));
        }
        pimMenu.click();
    }

    public  void selectAddEmployee(){
        addEmpLink.click();
    }

    public void selectEmployeeListPage(){
        addEmpLink.click();
    }

}
