package sorinfoca.Tests.Tema8.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class JavaScriptRedirectPage {

    private WebDriver driver;

    public JavaScriptRedirectPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void goToPage() {
        driver.get("https://testpages.herokuapp.com/styled/javascript-redirect-test.html");
    }

    public void clickRedirectButton(int index) {
        driver.findElements(By.id("delaygotobasic")).get(index).click();
    }

    public void switchToNewTab() {
        String originalHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
    }
}
