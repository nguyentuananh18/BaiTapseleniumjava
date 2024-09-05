package Page;

import anhNT.common.StringProcessing;
import anhNT.common.WebUI;
import org.openqa.selenium.By;
import static anhNT.common.StringProcessing.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class DashboardPage {


    public DashboardPage() {
    }


    private By totalInvoicesAwaitingPayment = By.xpath("(//span[normalize-space()='Invoices Awaiting Payment']/parent::div)/following-sibling::span");
    private By totalConvertedLeads = By.xpath("(//span[normalize-space()='Converted Leads']/parent::div)/following-sibling::span");
    private By totalProjectsInProgress = By.xpath("(//span[normalize-space()='Projects In Progress']/parent::div)/following-sibling::span");
    private By totalTasksNotFinished = By.xpath("(//span[normalize-space()='Tasks Not Finished']/parent::div)/following-sibling::span");

    private By buttonDashboardOptions = By.xpath("//div[normalize-space()='Dashboard Options']");

    private By checkBoxQickStatistics = By.xpath("//input[@id=\"widget_option_top_stats\"]");
    private By sectionQickStatistics = By.xpath("//div[@id=\"widget-top_stats\"]");

    private By checkBoxFinanceOverView = By.xpath("//input[@id=\"widget_option_finance_overview\"]");
    private By sectionFinanceOverView = By.xpath("//div[@id=\"widget-finance_overview\"]");

    private By checkBoxUserWidget = By.xpath("//input[@id=\"widget_option_user_data\"]");
    private By sectionUserWidget = By.xpath("//div[@id=\"widget-user_data\"]");

    private By checkBoxLatestProjectActivity = By.xpath("//input[@id=\"widget_option_projects_activity\"]");
    private By sectionLatesProjectActivity = By.xpath("//div[@id=\"widget-projects_activity\"]");

    private By inputSearchTotal = By.xpath("//input[@id='search_input']");
    private By listSearchResult = By.xpath("//div[@id='search_results']/ul/li/a");
    private By buttonCloseSearch = By.xpath("//div[@id=\"top_search_button\"]/button");

    private By textNoResulFound = By.xpath("//ul[@id=\"top_search_dropdown\"]/li[normalize-space(text())='No results found']");
    private By textSearchHistory = By.xpath("//ul[@id=\"search-history\"]/li[1]/a");


    private By buttonMenuCustomers = By.xpath("//ul[@id=\"side-menu\"]//span[normalize-space()='Customers']");


    /*My Task Of User Widget*/
    private By massegeNotFoundResult = By.xpath("//table[@id='tasks']/tbody//td[normalize-space()='No matching records found']");

    private By inputSearchMyTask = By.xpath("//div[@id='tasks_filter']//input[@type='search']");
    private By listMyTask = By.xpath("//table[@id='tasks']/tbody/tr/td[2]/a[1]");
    /*My Task Of User Widget*/


    /*My to do items*/
    private By buttonViewAllMyToDo = By.xpath("//div[@id='widget-todos']//a[normalize-space()='View All']");
    private By buttonAddNewToDo = By.xpath("//div[@id=\"widget-todos\"]//a[normalize-space()='New To Do']");
    private By inputDescriptionToDo = By.xpath("//form[@id='add_new_todo_item']//following-sibling::textarea[@id='description']");
    private By buttonSaveDescription = By.xpath("//div[@id='__todo']//button[@type='submit']");

    private By listElementToDoName = By.xpath("//div[@id='widget-todos']//ul//div[@class='tw-whitespace-pre-wrap']");
    private By listUnfinishedToDoName =By.xpath("//h4[normalize-space()=\"Unfinished to do's\"]//following-sibling::ul/li//div[@class='media-body']/div");
    private By listLatestFinishedToDo = By.xpath("//h4[normalize-space()=\"Latest finished to do's\"]//following-sibling::ul/li//div[@class='media-body']/div");
    /*My to do items*/

    By notificationButton = By.xpath("//a[contains(@class,'notifications-icon')]");
    By viewAllNotification = By.xpath("//a[normalize-space()='View all notifications']");

    public void checkTotalInvoicesAwaitingPayment() {

        Assert.assertTrue(WebUI.isElementDisplayed(totalInvoicesAwaitingPayment), "The section Invoices Awaiting Payment not display.");
        Assert.assertEquals(WebUI.getTextElement(totalInvoicesAwaitingPayment), "1 / 1", "FAIL!! Invoices Awaiting Payment total not match.");
    }

    public void checkTotalConvertedLeads() {
        Assert.assertTrue(WebUI.isElementDisplayed(totalConvertedLeads), "The section Converted Leads not display.");
        Assert.assertEquals(WebUI.getTextElement(totalConvertedLeads), "0 / 5", "FAIL!! Converted Leads total not match.");
    }

    public void checkTotalProjectsInProgress() {
        Assert.assertTrue(WebUI.isElementDisplayed(totalProjectsInProgress), "The section Projects In Progress not display.");
        Assert.assertEquals(WebUI.getTextElement(totalProjectsInProgress), "4 / 4", "FAIL!! Projects In Progress total not match.");
    }

    public void checkTotalTasksNotFinished() {
        Assert.assertTrue(WebUI.isElementDisplayed(totalTasksNotFinished), "The section Tasks Not Finished not display.");
        Assert.assertEquals(WebUI.getTextElement(totalTasksNotFinished), "8 / 8", "FAIL!! Tasks Not Finished total not match.");
    }
    public void clickDashboardOptions(){
        WebUI.clickElement(buttonDashboardOptions);
    }

    public void verifyCheckBoxQickStatistics()  {
        Assert.assertTrue(WebUI.verifyElementIsSelected(checkBoxQickStatistics),"FAIL!, The value of CheckBox Qick Statistics is Not Selected!");
        Assert.assertTrue(WebUI.isElementDisplayed(sectionQickStatistics),"FAIL!, The value of Section Qick Statistics is Not Display!");
    }

    public void verifyCheckBoxFinanceOverView(){
        Assert.assertTrue(WebUI.verifyElementIsSelected(checkBoxFinanceOverView), "FAIL! The Check Box Finance OverView is not Selected");
        Assert.assertTrue(WebUI.isElementDisplayed(sectionFinanceOverView), "FAIL! The Check Box Finance OverView  is not display");
    }
    public void verifyCheckBoxUserWidget(){
        Assert.assertTrue(WebUI.verifyElementIsSelected(checkBoxUserWidget),"FAIL! The check box User Widget is not selected ");
        Assert.assertTrue(WebUI.isElementDisplayed(sectionUserWidget),"Failure, the user utility does not exist");
    }
    public void verifyLateProjectActivity(){
        Assert.assertTrue(WebUI.verifyElementIsSelected(checkBoxLatestProjectActivity),"FAIL! The check box User Widget is not selected ");
        Assert.assertTrue(WebUI.isElementDisplayed(sectionLatesProjectActivity),"Failure, the user utility does not exist");
    }
    public void enterInputSearchTotal(String value){
        WebUI.enterText(inputSearchTotal,value);
    }
    public void clearTextSearchTotol(){
        WebUI.clearText(inputSearchTotal);
    }
    public void clickCloseInputSearch(){
        WebUI.clickElement(buttonCloseSearch);
    }

    public void successSearchTotal(){
        StringProcessing.sleep(5);
        String keywords = WebUI.getAttribute(inputSearchTotal,"value");
        List<WebElement> list = WebUI.listElement(listSearchResult);
        for (WebElement results : list){
            String result = results.getText();
            Assert.assertTrue(result.contains(keywords), "FAIL, search result are is incorrect ");
        }
    }
    public void noResultFound(){
        StringProcessing.sleep(5);
        Assert.assertTrue(WebUI.isElementPresent(textNoResulFound),"FAIL ! ");
    }
    public void checkSearchHistory(String keywords){
        enterInputSearchTotal(keywords);
        StringProcessing.sleep(1);
        clickCloseInputSearch();
        Assert.assertEquals(keywords, WebUI.getTextElement(textSearchHistory),"FAIL! Search History is incorrect.");
    }

    public CustomersPage clickMenuCustomers(){
        WebUI.clickElement(buttonMenuCustomers);
        return new CustomersPage();
    }
    public void validSearchMyTask(String taskName){
        WebUI.enterText(inputSearchMyTask,taskName);
        List<WebElement> listOfMyTask = WebUI.listElement(listMyTask);
        taskName = taskName.toLowerCase();
        System.out.println(taskName);
        for (WebElement myTaskName: listOfMyTask){
            String taskNameOnWeb = myTaskName.getText().toLowerCase();
            System.out.println(taskNameOnWeb);
            Assert.assertTrue(taskNameOnWeb.contains(taskName));
        }
    }

    public void invalidSearchMyTask(String taskName){
        WebUI.enterText(inputSearchMyTask,taskName);
        StringProcessing.sleep(3);
        Assert.assertTrue(WebUI.verifyElementIsDisplay(massegeNotFoundResult),"Fail! message No matching records found is incorrect");
    }

    public void checkAddNewToDo(String toDoName){
        WebUI.clickElement(buttonAddNewToDo);
        WebUI.enterText(inputDescriptionToDo,toDoName);
        WebUI.clickElement(buttonSaveDescription);
        WebUI.clickElement(buttonViewAllMyToDo);
        List<WebElement> listToDoName = WebUI.listElement(listUnfinishedToDoName);
        boolean seeMyToDo = false;
        for (WebElement nameOnWeb : listToDoName){
            if (nameOnWeb.getText().equals(toDoName)){
                seeMyToDo = true;
                break;
            }
        }
        Assert.assertTrue(seeMyToDo,"FAIL! My to do names do not match!");
    }
    public void verifyClickNotification(){
        sleep(3);
        WebUI.clickElement(notificationButton);
        Assert.assertTrue(WebUI.verifyElementIsDisplay(viewAllNotification));
    }
}
