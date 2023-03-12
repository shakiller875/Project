package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class MainPage {
    @FindBy(className = "css-oi140o")
    public WebElement grafana_title;

    @FindBy(className = "//div[@class='css-12ve8b']")
    public List<WebElement> listProgressSteps;
}
