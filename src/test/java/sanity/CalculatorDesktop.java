package sanity;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopFlows;


@Listeners(utilities.Listeners.class)
public class CalculatorDesktop extends CommonOps {


    @Test(description = "Test 01:Verify Addition Commend")
    @Description("This Test Verify the Commend Addition")
    public void test01_VerifyAdditionCommand() {
        DesktopFlows.calculateAddition();
        Verifications.verifyTextInElement(calcMain.field_result, "Display is 63");

    }
}
