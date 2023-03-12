package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CreateNewUserPage {
    @FindBy(xpath = "//input[@id='name-input']")
    public WebElement txt_name;

    @FindBy(xpath = "//input[@id='email-input']")
    public WebElement txt_email;

    @FindBy(xpath = "//input[@id='username-input']")
    public WebElement txt_userName;

    @FindBy(xpath = "//input[@id='password-input']")
    public WebElement txt_password;

    @FindBy(className = "css-1sara2j-button")
    public WebElement btn_createUser;

    @FindBy(className = "page-header__link")
    public WebElement link_User;
}
