package pageObjects.calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    @FindBy(name ="Nine")
    public WebElement btn_nine;

    @FindBy(name ="Seven")
    public WebElement btn_seven;

    @FindBy(name ="Multiply by")
    public WebElement btn_Multiplier;

    @FindBy(name ="Equals")
    public WebElement btn_equals;

    @FindBy(xpath ="//*[@AutomationId='CalculatorResults']")
    public WebElement field_result;

    @FindBy(name ="Clear")
    public WebElement btn_clear;

}
