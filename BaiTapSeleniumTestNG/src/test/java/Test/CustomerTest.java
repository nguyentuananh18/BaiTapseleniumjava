package Test;

import Page.CustomersPage;
import Page.DashboardPage;
import Page.LoginPage;
import anhNT.common.TestBase;
import anhNT.configData.ConfigData;
import org.testng.annotations.Test;

public class CustomerTest extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomersPage customersPage;
    ConfigData configData;

    @Test
    public void testAddCustomer(){
        loginPage = new LoginPage();
        configData = new ConfigData();
        loginPage.loginSuccess(configData.username, configData.password);

        dashboardPage = new DashboardPage();
        customersPage = dashboardPage.clickMenuCustomers();
        customersPage.clickAddNewCustomer();
        customersPage.InputData("Hoc Mai Mai");

        dashboardPage.clickMenuCustomers();
        customersPage.searchAndVerifyCustomer("Hoc Mai Mai");

    }
    @Test
    public void testAddCustomerWithCompanyNameEmpty(){
        loginPage = new LoginPage();
        configData = new ConfigData();
        loginPage.loginSuccess(configData.username, configData.password);

        dashboardPage = new DashboardPage();
        customersPage = dashboardPage.clickMenuCustomers();
        customersPage.clickAddNewCustomer();
        customersPage.InputData("");
        customersPage.verifyMessageErrorCompany();

    }

    @Test
    public void checkTotalCustomers(){
        loginPage = new LoginPage();
        configData = new ConfigData();
        dashboardPage = loginPage.loginSuccess(configData.username, configData.password);

        customersPage = dashboardPage.clickMenuCustomers();
        customersPage.verifyTotalCustomers();
    }

    @Test
    public void checkActiveCustomers(){
        loginPage = new LoginPage();
        configData = new ConfigData();
        dashboardPage = loginPage.loginSuccess(configData.username, configData.password);

        customersPage = dashboardPage.clickMenuCustomers();
        customersPage.verifyActiveCustomers();
    }

    @Test
    public void checkInactiveCustomers(){
        loginPage = new LoginPage();
        configData = new ConfigData();
        dashboardPage = loginPage.loginSuccess(configData.username, configData.password);

        customersPage = dashboardPage.clickMenuCustomers();
        customersPage.verifyInactiveCustomers();
    }

    @Test
    public void checkActiveContacts(){
        loginPage = new LoginPage();
        configData = new ConfigData();
        dashboardPage = loginPage.loginSuccess(configData.username, configData.password);
        customersPage = dashboardPage.clickMenuCustomers();
        customersPage.verifyNumberOfActiveContacts();
    }
    @Test
    public void checkActivessssContacts(){
        /*loginPage = new LoginPage();
        configData = new ConfigData();
        dashboardPage = loginPage.loginSuccess(configData.username, configData.password);
        customersPage = dashboardPage.clickMenuCustomers();
        customersPage.verifyNumberOfActiveContacts();*/
        customersPage = new CustomersPage();
        customersPage.Testthu1ti();

    }
}
