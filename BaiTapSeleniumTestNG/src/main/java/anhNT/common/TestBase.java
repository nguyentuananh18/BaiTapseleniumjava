package anhNT.common;

import anhNT.helpers.PropertiesHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static anhNT.common.StringProcessing.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


import java.time.Duration;

public class TestBase {
    @BeforeSuite
    public void beforSuite(){
        PropertiesHelper.setPropertiesFile("src/main/resources/config.properties");
    }


     @BeforeMethod
     @Parameters({"browser"})
    public void createBrowser(){
         WebDriver driver = null;
         String browserName = PropertiesHelper.getPropValue("browserTest");
         switch (browserName.trim().toLowerCase()){
             case "chrome" :
                 driver = new ChromeDriver();
                 break;
             case "firefox" :
                 driver = new FirefoxDriver();
             case "edge" :
                 driver = new EdgeDriver();
         }
         /*ChromeOptions options = new ChromeOptions();*/
         /*driver = new ChromeDriver();*/
         driver.manage().window().maximize();
         driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
         DriverManager.setDriver(driver);
    }

    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        sleep(2);
        DriverManager.quit();
    }

}
