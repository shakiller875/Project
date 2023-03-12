package pageObjects.todo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage {

    @FindBy(xpath = "//input[@placeholder='Create a task']")
    public WebElement taskCreate;

    @FindBy(className = "taskWrapper_2u8dN")
    public List<WebElement> List_Tasks;

    @FindBy(className = "destroy_19w1q")
    public List<WebElement> btn_Delete;

}
