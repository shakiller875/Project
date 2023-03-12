package sanity;


import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.python.antlr.ast.Str;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class GrafanaWeb extends CommonOps {

    @Test(description = "Test01 - Verify Header")
    @Description("This Test login and verifies the main header")
    public void test01_VerifyHeader() {
        WebFlows.login(getData("Username"), getData("Password"));
        Verifications.verifyTextInElement(grafanaMain.grafana_title, "Welcome to Grafana");
    }

    @Test(description = "Test02 - Verify Admin Users")
    @Description("This Test verifies the main admin")
    public void test02_VerifyAdmin() {
        UIActions.mouseHover(grafanaLeftMenu.Server_adminBtn, grafanaServerAdmin.Users_link);
        Verifications.numberOfUsers(grafanaServerAdminIn.Rows, 1);
    }

    @Test(description = "Test03 - Verify New User")
    @Description("This Test verifies a new user has been created")
    public void test03_VerifyNewUser() {
        UIActions.mouseHover(grafanaLeftMenu.Server_adminBtn, grafanaServerAdmin.Users_link);
        WebFlows.CreateNewUser("shalev", "shalevmag@gmail.com", "shakiller", "1111");
        UIActions.mouseHover(grafanaLeftMenu.Server_adminBtn, grafanaServerAdmin.Users_link);
        Verifications.numberOfUsers(grafanaServerAdminIn.Rows, 2);
    }

    @Test(description = "Test04 - Verify User Deletion")
    @Description("This Test login verifies deletion of a user")
    public void test04_VerifyDeleteUser() {
        UIActions.mouseHover(grafanaLeftMenu.Server_adminBtn, grafanaServerAdmin.Users_link);
        WebFlows.deleteLastUser();
        UIActions.mouseHover(grafanaLeftMenu.Server_adminBtn, grafanaServerAdmin.Users_link);
        Verifications.numberOfUsers(grafanaServerAdminIn.Rows, 1);
    }

    @Test(description = "Test05 - Verify Progress Steps")
    @Description("This Test Verifies the progress steps are displayed")
    public void test05_VerifyProgressSteps() {
        Verifications.visibilityOfElements(grafanaMain.listProgressSteps);
    }

    @Test(description = "Test06 - Verify Avatar Icon")
    @Description("This Test Verifies the Avatar Image Using Sikuli tool")
    public void test06_VerifyAvatarAdmin() {
        Verifications.visualElement("GrafanaAdminPic");
    }

    @Test(description = "Test07 - Search Users", dataProvider = "data-provider-users",dataProviderClass = utilities.ManageDDT.class)
    @Description("This Test Searched Users Using DDT")
    public void test07_SearchUsers(String user,String shouldExist) {
        UIActions.mouseHover(grafanaLeftMenu.Server_adminBtn, grafanaServerAdmin.Users_link);
        WebFlows.searchAndVerifyUser(user, shouldExist);

    }

}




