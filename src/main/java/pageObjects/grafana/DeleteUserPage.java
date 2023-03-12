package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteUserPage {
    @FindBy(xpath ="//button[@class='css-mk7eo3-button'][1]")
    public WebElement btn_delete;

    @FindBy(xpath ="//div[@class='css-14c36pf-layoutChildrenWrapper'][2]")
    public WebElement btn_confirmDelete;
}
