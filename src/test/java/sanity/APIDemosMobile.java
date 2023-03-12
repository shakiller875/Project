package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class APIDemosMobile extends CommonOps {


    @Test(description = "Test01 - Verify APiDemos")
    @Description("This Test taps on tabs and make a sound again")
    public void test01_VerifyTabs() {
        MobileFlows.APIDimos("tap", "tap", "hear voice again");
        Verifications.visualElement(demosMain.txt_Again,"again");

    }
}
