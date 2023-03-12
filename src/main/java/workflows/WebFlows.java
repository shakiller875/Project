package workflows;

import extensions.DBActions;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import utilities.CommonOps;

import java.util.List;

public class WebFlows extends CommonOps {

    @Step("Business Flow: Login to Grafana")
    public static void login(String user, String pass) {
        UIActions.updateText(grafanaLogin.userName, user);
        UIActions.updateText(grafanaLogin.Password, pass);
        UIActions.click(grafanaLogin.buttonLogin);
        UIActions.click(grafanaLogin.Skip_button);

    }

    @Step("Business Flow: Login to Grafana with Db Credentials")
    public static void loginDB() {
        String query = "SELECT Liverpool, Madrid FROM Teams WHERE PSG='3'";
        List<String> cred = DBActions.getCredentials(query);
        UIActions.updateText(grafanaLogin.userName,cred.get(0));
        UIActions.updateText(grafanaLogin.Password, cred.get(1));
        UIActions.click(grafanaLogin.buttonLogin);
        UIActions.click(grafanaLogin.Skip_button);

    }

    @Step("Business Flow: Create New User")
    public static void CreateNewUser(String name, String email, String userName, String password) {
        UIActions.click(grafanaServerAdminIn.NewUser_Btn);
        UIActions.updateText(grafanaCreateNewUser.txt_name, name);
        UIActions.updateText(grafanaCreateNewUser.txt_email, email);
        UIActions.updateText(grafanaCreateNewUser.txt_userName, userName);
        UIActions.updateText(grafanaCreateNewUser.txt_password, password);
        UIActions.click(grafanaCreateNewUser.btn_createUser);
    }

    @Step("Business Flow: Delete Last User")
    public static void deleteLastUser() {
        UIActions.click(grafanaServerAdminIn.Rows.get(grafanaServerAdminIn.Rows.size() - 1));
        UIActions.click(grafanaDeleteUser.btn_delete);
        UIActions.click(grafanaDeleteUser.btn_confirmDelete);
    }

    @Step("Business Flow: Search And Verify User")
    public static void searchAndVerifyUser(String User, String shouldExists) {
        UIActions.updateTextHuman(grafanaServerAdminIn.txt_Search, User);
        if (shouldExists.equalsIgnoreCase("exists"))
            Verifications.existenceOfElement(grafanaServerAdminIn.Rows);
        else if(shouldExists.equalsIgnoreCase("not-exist"))
            Verifications.nonExistenceOfElement(grafanaServerAdminIn.Rows);
        else
            throw new RuntimeException("Invalid Expected output Option in Data Driven Testing, Should be exists or not-exist");
            
        }
    }

