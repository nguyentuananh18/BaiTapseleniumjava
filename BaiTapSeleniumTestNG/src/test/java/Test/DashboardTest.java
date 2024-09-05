package Test;


import Page.DashboardPage;
import Page.LoginPage;
import anhNT.common.TestBase;
import anhNT.configData.ConfigData;
import org.testng.annotations.Test;
import static  anhNT.common.StringProcessing.*;

public class DashboardTest extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ConfigData configData;
    @Test(priority = 0)
    public void testDashboard(){
        loginPage = new LoginPage();
        configData = new ConfigData();
        loginPage.loginSuccess(configData.username,configData.password);

        dashboardPage = new DashboardPage();
        dashboardPage.checkTotalConvertedLeads();
        dashboardPage.checkTotalInvoicesAwaitingPayment();
        dashboardPage.checkTotalProjectsInProgress();
        dashboardPage.checkTotalTasksNotFinished();
    }
    @Test(priority = 1)
    public void verifySectionQickStatisticExist() throws InterruptedException {
        loginPage = new LoginPage();
        configData = new ConfigData();
        loginPage.loginSuccess(configData.username,configData.password);

        dashboardPage = new DashboardPage();
        dashboardPage.clickDashboardOptions();
        dashboardPage.verifyCheckBoxQickStatistics();
    }
    @Test(priority = 2)
    public void verifySectionFinanceOverViewExist(){
        loginPage = new LoginPage();
        configData = new ConfigData();

        loginPage.loginSuccess(configData.username,configData.password);

        dashboardPage = new DashboardPage();
        dashboardPage.clickDashboardOptions();
        dashboardPage.verifyCheckBoxFinanceOverView();
    }

    @Test(priority = 3)
    public void verifySectionUserWidgetExist(){
        loginPage = new LoginPage();
        configData = new ConfigData();

        loginPage.loginSuccess(configData.username,configData.password);

        dashboardPage = new DashboardPage();
        dashboardPage.clickDashboardOptions();
        dashboardPage.verifyCheckBoxUserWidget();
    }
    @Test(priority = 4)
    public void verifySectionLateProjectActivity(){
        loginPage = new LoginPage();
        configData = new ConfigData();

        loginPage.loginSuccess(configData.username,configData.password);

        dashboardPage = new DashboardPage();
        sleep(5);
        dashboardPage.verifyLateProjectActivity();
    }
    @Test(priority = 5)
    public void verifySuccessfulSearch(){
        loginPage = new LoginPage();
        configData = new ConfigData();

        loginPage.loginSuccess(configData.username,configData.password);
        dashboardPage = new DashboardPage();
        dashboardPage.enterInputSearchTotal("Test");
        dashboardPage.successSearchTotal();
    }
    @Test(priority = 6)
    public void verifyNoResultFound(){
        loginPage = new LoginPage();
        configData = new ConfigData();

        loginPage.loginSuccess(configData.username,configData.password);
        dashboardPage = new DashboardPage();
        dashboardPage.enterInputSearchTotal("abcdxyzkafkasf");
        dashboardPage.noResultFound();
    }
    @Test(priority = 7)
    public void verifyHistorySearch(){
        loginPage = new LoginPage();
        configData = new ConfigData();

        loginPage.loginSuccess(configData.username,configData.password);
        dashboardPage = new DashboardPage();

        dashboardPage.checkSearchHistory("abcdxy");
    }

    @Test(priority = 8)
    public void checkValidSearchMyTask(){
        loginPage = new LoginPage();
        configData = new ConfigData();

        loginPage.loginSuccess(configData.username,configData.password);
        dashboardPage = new DashboardPage();
        dashboardPage.validSearchMyTask("Demo");
    }
    @Test(priority = 9)
    public void checkInvalidSearchMyTask(){
        loginPage = new LoginPage();
        configData = new ConfigData();

        loginPage.loginSuccess(configData.username,configData.password);
        dashboardPage = new DashboardPage();
        dashboardPage.invalidSearchMyTask("hafnasf");
    }
    @Test(priority = 10)
    public void testAddMyToDo(){
        loginPage = new LoginPage();
        configData = new ConfigData();
        loginPage.loginSuccess(configData.username,configData.password);
        dashboardPage = new DashboardPage();
        dashboardPage.checkAddNewToDo("My To o Test");
    }

    @Test
    public void testClickNotification(){
        loginPage = new LoginPage();
        configData = new ConfigData();
        dashboardPage = loginPage.loginSuccess(configData.username,configData.password);
        dashboardPage.verifyClickNotification();

    }

}
