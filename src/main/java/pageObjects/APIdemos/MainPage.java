package pageObjects.APIdemos;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;


public class MainPage {

    private AppiumDriver mobileDriver;

    public MainPage(AppiumDriver mobileDriver){
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(3)),this);
    }
    @AndroidFindBy(xpath = "//*[@text='App']" )
    public AndroidElement txt_App;

    @AndroidFindBy(xpath = "//*[@text='Text-To-Speech']" )
    public AndroidElement txt_Speech;
    //*[@text='Again']
    @AndroidFindBy(xpath = "//*[@text='Again']")
    public AndroidElement txt_Again;

}
