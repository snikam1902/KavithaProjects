package orangeHRM.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EditUserPage extends  BasePage{
    @FindBy(xpath = "//div[@id='supervisorrole_inputfileddiv']/div/input")
    WebElement superVisorRoleInput;
    @FindBy(xpath = "//div[@id='supervisorrole_inputfileddiv']/div/ul/li/span")
    List<WebElement> superVisorRoles;
    @FindBy(id = "systemUserSaveBtn")
    WebElement save;

    public void addRoleToUser(String role){
        superVisorRoleInput.click();
        sleep();
        for(WebElement element: superVisorRoles){
            if (element.getText().endsWith(role)){
                element.click();
                break;
            }
        }
        save.click();
        sleep();
    }
}
