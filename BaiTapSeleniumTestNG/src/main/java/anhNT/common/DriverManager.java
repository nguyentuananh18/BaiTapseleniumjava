package anhNT.common;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static final ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    private DriverManager() {
    }

    //Thay thế cho tất cả các giá trị driver bình thường trong project
    public static WebDriver getDriver() {
        return drivers.get();
    }

    //Dùng tại BaseTest vị trí Before (cần set giá trị driver trước khi chạy test cases)
    public static void setDriver(WebDriver driver) {
        drivers.set(driver);
    }

    //Dùng tại BaseTest vị trí After (để reset giá trị driver về null
    //và xoá luôn vị trí của driver đó trong ThreadLocal sau mỗi test cases)
    public static void quit() {
        if (getDriver() != null) {
            getDriver().quit();
            drivers.remove();
        }
    }
}
