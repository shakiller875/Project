package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ServerAdminInPage {
    @FindBy(xpath = "//tbody/tr/td[1]")
    public List<WebElement> Rows;

    @FindBy(xpath = "//a[@class='css-1sara2j-button']")
    public WebElement NewUser_Btn;

    @FindBy(className = "css-1wdli31-input-input")
    public WebElement txt_Search;

}
