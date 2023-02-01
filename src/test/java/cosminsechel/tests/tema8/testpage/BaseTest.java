package cosminsechel.tests.tema8.testpage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    protected ChromeDriver driver = null;

    private static String baseUrl = "https://testpages.herokuapp.com/";

    public static String getBaseUrl() {
        return baseUrl;
    }

    @BeforeMethod(groups = "desktop")
    public void setUpDesktop() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod(groups = "mobile")
    public void setUpMobile() {
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Nexus 5");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("mobileEmulation", mobileEmulation);
        driver = new ChromeDriver(options);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
