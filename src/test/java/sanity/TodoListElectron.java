package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;


@Listeners(utilities.Listeners.class)
public class TodoListElectron extends CommonOps {

    @Test(description = "Test01 - Add And Verify New Task")
    @Description("This Test adds a new task and verifies it in the List of task")
    public void test01_AddAndVerifyNewTask() {
        ElectronFlows.addNewTask("Go to The Gym");
        Verifications.verifyNumber(ElectronFlows.getNumberOfTasks(),1);

    }

    @Test(description = "Test02 - Add And Verify New Task")
    @Description("This Test adds a new task and verifies it in the List of task")
    public void test02_AddAndVerifyNewTasks() {
        ElectronFlows.addNewTask("Go to Work");
        ElectronFlows.addNewTask("Read Books");
        ElectronFlows.addNewTask("Eat Healthy");
        Verifications.verifyNumber(ElectronFlows.getNumberOfTasks(),3);

    }
}
