package sorinfoca.Tests.Tema8.TestPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import sorinfoca.Tests.Tema8.pages.*;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TestPages extends BaseTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @Test(groups = {"desktop", "mobile"})
    public void testBasicAjax() {
        BasicAjaxPage basicAjaxPage = new BasicAjaxPage(driver);
        basicAjaxPage.get();
        basicAjaxPage.selectOption("Option 2");
        basicAjaxPage.clickCodeItInButton();
        assertTrue(basicAjaxPage.isOptionSelected("Option 2"));
    }

    @Test(groups = {"desktop", "mobile"})
    public void testJavaScriptRedirect() {
        JavaScriptRedirectPage javascriptRedirectPage = new JavaScriptRedirectPage(driver);
        javascriptRedirectPage.get();
        javascriptRedirectPage.clickRedirectButton(0);
        javascriptRedirectPage.switchToNewTab();
        driver.close();
    }

    @Test(groups = {"desktop", "mobile"})
    public void testRefresh() {
        RefreshPage refreshPage = new RefreshPage(driver);
        refreshPage.get();
        assertTrue(refreshPage.isIdTimestamp());
    }

    @Test(groups = {"desktop", "mobile"})
    public void testDynamicButtonsSimple() {
        DynamicButtonsSimplePage dynamicButtonsSimplePage = new DynamicButtonsSimplePage(driver);
        dynamicButtonsSimplePage.get();
        dynamicButtonsSimplePage.clickAllButtons();
        assertEquals(dynamicButtonsSimplePage.getDisplayedMessage(), "All buttons have been clicked!");
    }

    @Test(groups = {"desktop", "mobile"})
    public void testDynamicButtonsDisabled() {
        DynamicButtonsDisabledPage dynamicButtonsDisabledPage = new DynamicButtonsDisabledPage(driver);
        dynamicButtonsDisabledPage.get();
        dynamicButtonsDisabledPage.clickAllButtons();
        assertEquals(dynamicButtonsDisabledPage.getDisplayedMessage(), "All buttons have been clicked!");
    }
}

