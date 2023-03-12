package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class DesktopFlows extends CommonOps {

    @Step("Calculate Addition: 9 x 7")
    public static void calculateAddition(){
        UIActions.click(calcMain.btn_clear);
        UIActions.click(calcMain.btn_nine);
        UIActions.click(calcMain.btn_Multiplier);
        UIActions.click(calcMain.btn_seven);
        UIActions.click(calcMain.btn_equals);
    }
}
