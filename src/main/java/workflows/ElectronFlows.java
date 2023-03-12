package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

public class ElectronFlows extends CommonOps {

    @Step("Add New Task to The List")
    public static void addNewTask(String taskName) {
        UIActions.updateText(todoMain.taskCreate, taskName);
        UIActions.insertKey(todoMain.taskCreate, Keys.RETURN);

    }

    @Step("Count and Return Number of Tasks in List")
    public static int getNumberOfTasks() {
        return todoMain.List_Tasks.size();

    }

    @Step("Empty List From Tasks")
    public static void EmptyList() {
        for (int i = 0; i < getNumberOfTasks(); i++) {
            UIActions.mouseHover(todoMain.btn_Delete.get(i));
        }
    }
}
