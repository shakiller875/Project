package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.grafana.CreateNewUserPage;
import pageObjects.grafana.DeleteUserPage;
import pageObjects.grafana.ServerAdminInPage;
import pageObjects.grafana.ServerAdminPage;

public class ManagePages extends Base {
    public static void initGrafana() {
        grafanaLogin = PageFactory.initElements(driver, pageObjects.grafana.LoginPage.class);
        grafanaMain = PageFactory.initElements(driver, pageObjects.grafana.MainPage.class);
        grafanaLeftMenu = PageFactory.initElements(driver, pageObjects.grafana.LeftMenuPage.class);
        grafanaServerAdmin = PageFactory.initElements(driver, ServerAdminPage.class);
        grafanaServerAdminIn = PageFactory.initElements(driver, ServerAdminInPage.class);
        grafanaCreateNewUser = PageFactory.initElements(driver, CreateNewUserPage.class);
        grafanaDeleteUser = PageFactory.initElements(driver, DeleteUserPage.class);

    }

    public static void initApiDemos() {
        demosMain = new pageObjects.APIdemos.MainPage(mobileDriver);
    }

    public static void initTodo() {
       todoMain =  PageFactory.initElements(driver, pageObjects.todo.MainPage.class);
    }

    public static void initCalculator() {
        calcMain = PageFactory.initElements(driver, pageObjects.calculator.MainPage.class);
    }
}
