package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;


@Listeners(utilities.Listeners.class)
public class GrafanaWebDB extends CommonOps {

    @Test(description = "Test01 - Login to Grafana with DB Credentials")
    @Description("This Test with DB credentials and verifies the main header")
    public void test01_loginDBAndVerifyHeader() {
        WebFlows.loginDB();
        Verifications.verifyTextInElement(grafanaMain.grafana_title, "Welcome to Grafana");
    }
}
