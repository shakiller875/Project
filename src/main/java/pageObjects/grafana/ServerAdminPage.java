package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServerAdminPage {
    @FindBy(xpath = "//a[@href='/admin/users']")
    public WebElement Users_link;

    @FindBy(xpath = "//a[@href='/admin/orgs']")
    public WebElement Organizations_link;

}
