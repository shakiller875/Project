package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;


@Listeners(utilities.Listeners.class)
public class GrafanaApi extends CommonOps {

    @Test(description = "Test 01: Get Team From Grafana")
    @Description("This Test Verify Team Property")
    public void test01_VerifyTeam(){
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[0].name"), "shakiller");
    }

    @Test(description = "Test 02: Add Team And Verify")
    @Description("This Test Adds a Team to Grafana and Verify it")
    public void test02_addTeamAndVerify(){
        ApiFlows.PostTeam("shalevTeam", "shalev@gmail.com");
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[1].name"), "shalevTeam");
    }

    @Test(description = "Test 03: Update Team And Verify")
    @Description("This Test Updates a Team in Grafana and Verify it")
    public void test03_UpdateTeamAndVerify(){
        String id = ApiFlows.getTeamProperty("teams[1].id");
        ApiFlows.updateTeam("shalevTeam", "shalev@team.com", id);
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[1].email"), "shalev@team.com");
    }

    @Test(description = "Test 04: Delete Team And Verify")
    @Description("This Test Deletes a Team in Grafana and Verify it")
    public void test04_deleteTeamAndVerify(){
        String id = ApiFlows.getTeamProperty("teams[1].id");
        ApiFlows.deleteTeam(id);
        Verifications.verifyText(ApiFlows.getTeamProperty("totalCount"), "1");
    }
}
