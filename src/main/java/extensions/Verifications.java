package extensions;

import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import utilities.CommonOps;

import java.util.List;

import static org.aspectj.bridge.MessageUtil.fail;

public class Verifications extends CommonOps {

    @Step("Verify Text In Element")
    public static void verifyTextInElement(WebElement elem, String expected) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        Assert.assertEquals(elem.getText(), expected);
    }

    @Step("Verify Number Of Users")
    public static void numberOfUsers(List<WebElement> elems, int expected) {
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size() - 1)));
        Assert.assertEquals(elems.size(), expected);
    }

    @Step("verify Visibility Of Elements")
    public static void visibilityOfElements(List<WebElement> elems) {
        for (WebElement elem : elems) {
            softAssert.assertTrue(elem.isDisplayed());
        }
        softAssert.assertAll("some elements were not displayed");
    }

    @Step("Verify Element Visually")
    public static void visualElement(String expectedImageName) {
        try {
            screen.find(getData("imageRepo") + expectedImageName + ".png");
        } catch (FindFailed findFailed) {
            System.out.println("Error Comparing Image File: " + findFailed);
            fail("Error Comparing Image File: " + findFailed);
        }
    }

    @Step("Verify Element Displayed")
    public static void existenceOfElement(List<WebElement> elements) {
        Assert.assertTrue(elements.size() > 0);
    }

    @Step("Verify Element Not Displayed")
    public static void nonExistenceOfElement(List<WebElement> elements) {
        Assert.assertFalse(elements.size() > 0);
    }

    @Step("Verify Text with Text")
    public static void verifyText(String actual, String expected){
        Assert.assertEquals(actual, expected);
    }

    @Step("Verify Number with Number")
    public static void verifyNumber(int actual, int expected){
        Assert.assertEquals(actual, expected);
    }

    public static void visualElement(AndroidElement txt_again, String again) {
    }
}
