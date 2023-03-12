package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(name = "user")
    public WebElement userName;

    @FindBy(name = "password")
    public WebElement Password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement buttonLogin;

    @FindBy(xpath = "//button[@class='css-1kf0ycc-button']")
    public WebElement Skip_button;
}
