package bogdanSandu.tests.Tema7;

import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    static ChromeDriver driver = null;

    @BeforeMethod
    public void openCURAHealthPage() {
        //open home page
        driver = BrowserManager.createDriverAndGetPage();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        System.out.println("Am deschis CURA Healthcare Service page");
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
        System.out.println("Close browser");
    }
}
