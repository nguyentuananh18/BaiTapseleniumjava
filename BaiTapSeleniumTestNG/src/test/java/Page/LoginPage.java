package Page;

import anhNT.common.WebUI;
import anhNT.configData.ConfigData;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage {

    ConfigData configData;
    public LoginPage(){

    }

    private By usernameInput = By.xpath("//input[@id=\"email\"]");
    private By passwordInput = By.xpath("//input[@id=\"password\"]");
    private By loginButton = By.xpath("//button[normalize-space(text()= 'Login')]");

    private By messageNonExistentEmailOrPassword = By.xpath("//div[@id='alerts']/div[@class='text-center alert alert-danger']");
    private By messageFailUsernameIsEmpty = By.xpath("//div[normalize-space()='The Email Address field is required.']");
    private By messageFailPasswordIsEmpty = By.xpath("//div[normalize-space()='The Password field is required.']");

    private By DashboardText = By.xpath("//span[contains(text(),'Dashboard')]");

    public DashboardPage loginSuccess(String username, String password){
        configData = new ConfigData();
        WebUI.openURL(configData.URL);
        WebUI.enterText(usernameInput,username);
        WebUI.enterText(passwordInput,password);
        WebUI.clickElement(loginButton);
        Assert.assertTrue(WebUI.isElementDisplayed(DashboardText));
        return new DashboardPage();
    }
    public void enterUserNam(String username){
        WebUI.enterText(usernameInput,username);
    }
    public void enterPassWord(String password){
        WebUI.enterText(passwordInput,password);
    }
    public void clickButtonLogin(){
        WebUI.clickElement(loginButton);
    }

    public void InvalidEmailFormatLogin(String username, String password){
        configData = new ConfigData();
        WebUI.openURL(configData.URL);
        enterUserNam(username);
        enterPassWord(password);
        clickButtonLogin();
        System.out.println(WebUI.getAttribute(usernameInput,"validationMessage"));
        Assert.assertTrue(WebUI.getAttribute(usernameInput,"validationMessage").contains("Please include an '@' in the email address."),"FAIL! ");

    }

    public void LoginFailureWithNonExistentUsername(String username, String password){
        configData = new ConfigData();
        WebUI.openURL(configData.URL);
        enterUserNam(username);
        enterPassWord(password);
        clickButtonLogin();
        Assert.assertEquals(WebUI.getTextElement(messageNonExistentEmailOrPassword), "Invalid email or password", "Fail, message Invalid Email Or Password are incorrect");
    }
    public void LoginFailureWithEmptyUsername(String password){
        configData = new ConfigData();
        WebUI.openURL(configData.URL);
        enterPassWord(password);
        clickButtonLogin();
        Assert.assertTrue(WebUI.isElementPresent(messageFailUsernameIsEmpty));
    }
    public void LoginFailureWithEmptyPassword(String username){
        configData = new ConfigData();
        WebUI.openURL(configData.URL);
        enterUserNam(username);
        clickButtonLogin();
        Assert.assertTrue(WebUI.isElementPresent(messageFailPasswordIsEmpty));
    }
    public void LoginFailWithEmailAndPassWordIsEmpty(){
        configData = new ConfigData();
        WebUI.openURL(configData.URL);
        clickButtonLogin();
        Assert.assertTrue(WebUI.isElementPresent(messageFailUsernameIsEmpty));
        Assert.assertTrue(WebUI.isElementPresent(messageFailPasswordIsEmpty));
    }
    public void LoginWithUsernameLengthLimit(String email, String password){
        configData = new ConfigData();
        WebUI.openURL(configData.URL);
        enterUserNam(email);
        enterPassWord(password);
        clickButtonLogin();
        Assert.assertEquals(WebUI.getAttribute(usernameInput, "validationMessage"), "Please enter an email address.","FAIL! message Username Length Limit are incorrect!");
    }


}
