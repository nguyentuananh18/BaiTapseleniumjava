package Test;


import Page.LoginPage;
import anhNT.common.TestBase;
import anhNT.configData.ConfigData;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {

    LoginPage loginPage;
    ConfigData configData;
    @Test(priority = 0)
    public void TestLoginSuccess(){
        loginPage = new LoginPage();
        configData = new ConfigData();
        loginPage.loginSuccess(configData.username,configData.password);
    }
    @Test(priority = 1)
    public void TestInvalidEmailFormatLogin(){
        loginPage = new LoginPage();
        configData = new ConfigData();
        loginPage.InvalidEmailFormatLogin("nah123.com","123456");
    }
    @Test(priority = 2)
    public void testLoginFailureWithNonExistentUsername(){
        loginPage = new LoginPage();
        configData = new ConfigData();
        loginPage.LoginFailureWithNonExistentUsername("admin@example.com.sss","123456");

    }

    @Test(priority = 3)
    public void testLoginWithEmailIsEmpty(){
        loginPage = new LoginPage();
        configData = new ConfigData();
        loginPage.LoginFailureWithEmptyUsername("123456");
    }
    @Test(priority = 4)
    public void testLoginWithPasswordIsEmpty(){
        loginPage = new LoginPage();
        configData = new ConfigData();

        loginPage.LoginFailureWithEmptyPassword("admin@example.com");
    }
    @Test(priority = 5)
    public void testLoginWithEmailAndPasswordIsEmpty(){
        loginPage = new LoginPage();
        configData = new ConfigData();
        loginPage.LoginFailWithEmailAndPassWordIsEmpty();
    }
    @Test(priority = 6)
    public void testLoginWithUsernameLengthLimit(){
        loginPage = new LoginPage();
        configData = new ConfigData();
        loginPage.LoginWithUsernameLengthLimit("nguyentuananh123@gmail.commmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm","123456");
    }

}
