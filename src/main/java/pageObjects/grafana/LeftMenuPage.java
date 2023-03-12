package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftMenuPage {
    @FindBy(xpath = "//li[@class='css-1b4r4c9'][5]")
    public WebElement Server_adminBtn;

    @FindBy(className = "css-1wf2pa6")
    public WebElement button_report;

    @FindBy(xpath= "//li[@class='css-1b4r4c9'][4]")
    public WebElement button_Alert;
}
