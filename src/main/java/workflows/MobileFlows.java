package workflows;

import extensions.mobileActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class MobileFlows extends CommonOps {

     @Step("Business Flow: Tap Tabs And Hear")
    public static void APIDimos(String FirstPage,String SecondPage,String again){
        mobileActions.tap(demosMain.txt_App);
        mobileActions.tap(demosMain.txt_Speech);
        mobileActions.tap(demosMain.txt_Again);

    }
}
