package catalinazoldi.tests.Tema9.Tema7;


import catalinazoldi.teorie.driver.BrowserManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected ChromeDriver driver;

    @BeforeMethod
    public void openCURAHealthPage() {
        RemoteWebDriver driver;
        driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        System.out.println("Am deschis pagina CURA Healthcare. ");

    }

   @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
        System.out.println(" Browserul a fost inchis!");
    }
}
