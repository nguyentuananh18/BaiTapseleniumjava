package Page;

import static anhNT.common.StringProcessing.*;
import static anhNT.common.WebUI.*;

import anhNT.common.WebUI;
import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


import java.io.File;
import java.util.List;


public class CustomersPage {


    public CustomersPage() {

    }
    By headerCustomerPage = By.xpath("//h4/span[normalize-space()='Customers Summary']");

    private By buttonAddNewCustomer = By.xpath("//div[@id=\"wrapper\"]//a[normalize-space()='New Customer']");
    private By inputCompanyName = By.xpath("//input[@id='company']");
    private By inputVATNumber = By.xpath("//input[@id='vat']");
    private By inputPhoneNumber = By.xpath("//input[@id='phonenumber']");
    private By inputWebsite = By.xpath("//input[@id='website']");
    private By buttonSelectGroups = By.xpath("//button[@data-id='groups_in[]']");
    private By inputSearchGroup =By.xpath("//div[@app-field-wrapper=\"groups_in[]\"]//input[@type='search']");
    private By buttonSelectCurrency = By.xpath("//button[@data-id=\"default_currency\"]");
    private By inputCurrency = By.xpath("//div[@app-field-wrapper=\"default_currency\"]//input[@type='search']");
    private By selectLanguage = By.xpath("//select[@id='default_language']");
    private By inputAddress = By.xpath("//textarea[@id='address']");
    private By inputCity = By.xpath("//input[@id='city']");
    private By inputState = By.xpath("//input[@id='state']");
    private By inputZipCode = By.xpath("//input[@id='zip']");
    private By buttonSelectCountry  = By.xpath("//button[@data-id='country']");
    private By inputSearchCountry = By.xpath("//div[@app-field-wrapper='country']//input[@type='search']");
    private By buttonSaveAndCreateContact = By.xpath("//div[@id=\"profile-save-section\"]//button[normalize-space()='Save and create contact']");
    private By buttonSaveCustomer = By.xpath("//div[@id=\"profile-save-section\"]//button[normalize-space()='Save']");

    private By uploadFileImageInput = By.xpath("//input[@id=\"profile_image\"]");

    private By totalCustomersText = By.xpath("//span[normalize-space()='Total Customers']//parent::div/span[1]");
    private By activeCustomersText = By.xpath("//span[normalize-space()='Active Customers']//parent::div/span[1]");
    private By inactiveCustomersText = By.xpath("//span[normalize-space()='Inactive Customers']//parent::div/span[1]");

    By inputFilterCustomer = By.xpath("//div[@id=\"clients_filter\"]//input[@type='search']");
    By firstCustomerOfTable = By.xpath("//table[@id=\"clients\"]/tbody/tr[1]//td[3]/a");
    private By messageErrorCompany = By.xpath("//p[@id='company-error']");

    By numberActiveContacts = By.xpath("//span[normalize-space()=\"Active Contacts\"]/parent::div/span[1]");
    By buttonContacts = By.xpath("//div[@id='wrapper']//a[normalize-space()=\"Contacts\"]");
    By listActiveContacts = By.xpath("//span[@class='hide' and normalize-space()=\"No\"]");
    By listActiveCustomers = By.xpath("//tbody/tr//div[@class=\"onoffswitch\"]/input[@type='checkbox' and @checked]");
    By listInactiveCustomers = By.xpath("//span[@class='hide' and normalize-space()=\"No\"]");

    By selectClient = By.xpath("//select[@name=\"clients_length\"]");

    public void clickAddNewCustomer(){
        clickElement(buttonAddNewCustomer);
    }
    public void InputData(String companyName){
        enterText(inputCompanyName,companyName);
        enterText(inputVATNumber,"10");
        enterText(inputPhoneNumber,"923383673");
        enterText(inputWebsite,"tuanbuffet123.vnTest");
        clickElement(buttonSelectGroups);
        enterText(inputSearchGroup,"Gold");
        sleep(1);
        enterText(inputSearchGroup,"" + Keys.ENTER);
        clickElement(buttonSelectGroups);

        clickElement(buttonSelectCurrency);
        enterText(inputCurrency,"USD");
        sleep(1);
        enterText(inputCurrency,"" + Keys.ENTER);
        selectOptionValue(selectLanguage,"vietnamese");
        enterText(inputAddress,"11.11.111");
        enterText(inputCity,"Ha Noi");
        enterText(inputState,"Active");
        enterText(inputZipCode,"70000");
        clickElement(buttonSelectCountry);
        enterText(inputSearchCountry,"VietNam" + Keys.ENTER);
        clickElement(buttonSaveAndCreateContact);
        sleep(3);
        enterText(uploadFileImageInput,getPathFiles("D:\\images.png"));
        enterText(uploadFileImageInput,getPathFiles("D:\\images2.png"));
        sleep(100);
    }
    public String getPathFiles(String path){
        File file = new File(path);
        return file.getAbsolutePath();
    }
    public void Testthu1ti(){
        WebUI.openURL("https://fineuploader.com/demos.html");
        sleep(3);
        WebUI.enterText(By.xpath("/html/body/div[2]/div[2]/div[2]/section[2]/div[1]/div/div[3]/input"),getPathFiles("D:\\images.png"));
        sleep(3);
        WebUI.enterText(By.xpath("/html/body/div[2]/div[2]/div[2]/section[2]/div[1]/div/div[3]/input"),getPathFiles("D:\\images.png"));
        sleep(5);
    }

    public void searchAndVerifyCustomer(String companyName){
        enterText(inputFilterCustomer,companyName);
        sleep(2);
        Assert.assertTrue(getTextElement(firstCustomerOfTable).contains(companyName));
    }
    public void verifyMessageErrorCompany(){
        Assert.assertTrue(verifyElementIsDisplay(messageErrorCompany));
    }
    public void verifyTotalCustomers(){

        int totalCustomer = Integer.parseInt(getTextElement(totalCustomersText));

        selectOptionValue(selectClient,"-1");
        sleep(2);
        int numberOfClient = listElement(By.xpath("//tbody/tr")).size();

        int numberOfInActiveClient = listElement(By.xpath("//tbody/tr//div[@class=\"onoffswitch\"]/input[@type='checkbox' and @checked]")).size();
        System.out.println(numberOfInActiveClient);

        Assert.assertEquals(numberOfClient, totalCustomer, "FAIL! Toltal Customers is incorrect");
    }
    public void verifyActiveCustomers(){
        int activeCustomersOfCustomerSummary = Integer.parseInt(getTextElement(activeCustomersText));
        selectOptionValue(selectClient,"-1");
        sleep(2);
        int numberOfActiveCustomer = listElement(listActiveCustomers).size();
        Assert.assertEquals(activeCustomersOfCustomerSummary,numberOfActiveCustomer,"FAIL! Active Customers is not match");
    }
    public void verifyInactiveCustomers(){
        int inactiveCustomersOfSummary = Integer.parseInt(getTextElement(inactiveCustomersText));
        System.out.println(verifyElementIsSelected(By.xpath("//input[@id=\"652\"]")));
        selectOptionValue(selectClient,"-1");
        sleep(2);
        int numberOfInActiveCustomer = listElement(listInactiveCustomers).size();
        Assert.assertEquals(inactiveCustomersOfSummary,numberOfInActiveCustomer,"FAIL! Inactive Customers is not match");

    }

    public void verifyNumberOfActiveContacts(){
        String numberOfActiveContacts = getTextElement(numberActiveContacts);
        System.out.println("numberOfActiveContacts : " + numberOfActiveContacts);
        clickElement(buttonContacts);
        List<WebElement> listContracts = listElement(listActiveContacts);
        System.out.println("co " + listContracts.size() + " active Contacts");
        int quantity = 0;
        for (int i =1; i<= listContracts.size() ; i++){
            if (getTextElement(By.xpath("//tbody/tr[" + i + "]//span")).equals("Yes")){
                quantity ++;
            }
        }

        Assert.assertEquals(Integer.parseInt(numberOfActiveContacts),quantity,"FAIL! Active Contacts Of Customers Summary is not match");
    }

}
