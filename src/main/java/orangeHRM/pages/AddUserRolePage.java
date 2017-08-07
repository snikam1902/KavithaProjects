package orangeHRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddUserRolePage extends BasePage {

    @FindBy(xpath = "//div[@id='data-group-user-selection-select']/div/input")
    WebElement roleTypeInput;
    @FindBy(xpath = "//div[@id='data-group-user-selection-select']/div/ul/li")
    List<WebElement> roleTypes;
    @FindBy(name = "userRoleName")
    WebElement roleName;
    @FindBy(css = ".btn.primary-btn")
    WebElement saveBtn;

    //not doing all other selection for now
    public void createUserRole(String name) {
        roleTypeInput.click();
        roleTypes.get(2).click();
        roleName.sendKeys(name);
        saveBtn.click();
        sleep();
    }
}
