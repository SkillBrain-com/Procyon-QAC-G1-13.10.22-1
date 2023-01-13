package BogdanSandu.tests.Tema6;

import BogdanSandu.driver.BrowserManager;
import BogdanSandu.utils.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.print.PrintOptions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static BogdanSandu.tests.Tema6.HerokuAlerts.tryToFindElement;

public class HerokuForms {

    static ChromeDriver driver = null;

    public static void main(String[] args) {
        navigateToHerokuFormsPage();
        try {
            fillFormDetails();
            scrollToSubmitButton();
            closeBrowser();
            tryToFindElement();
        }catch (NoSuchElementException e){
            FileUtils.takeScreenshot(driver, "Forms");
        }finally {
            closeBrowser();
        }
    }

    public static void navigateToHerokuFormsPage () {
        driver = BrowserManager.createDriverAndGetPage();
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        driver.manage().window().maximize();
        System.out.println("Am deschis Heroku Forms page!");
    }

    public static void fillFormDetails(){
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Test");
        System.out.println("Am completat la "+"\"Username\"");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("passwordTest");
        System.out.println("Am completat la "+"\"Password\"");
        WebElement textArea = driver.findElement(By.name("comments"));
        textArea.clear();
        textArea.sendKeys("Test comment");
        System.out.println("Am completat la "+"\"TextArea Comment\"");
        List<WebElement> checkboxes = driver.findElements(By.name("checkboxes[]"));
        checkboxes.get(1).click();
        System.out.println("Am selecetat la "+"\"Checkbox Items\"");
        List<WebElement> radioButton = driver.findElements(By.name("radioval"));
        radioButton.get(2).click();
        System.out.println("Am selecetat la "+"\"Radio Items\"");
        Select select = new Select(driver.findElement(By.name("multiselect[]")));
        select.selectByValue("ms1");
        select.selectByValue("ms2");
        System.out.println("Am selecetat la "+"\"Multiple Select Values\"");
        Select dropdown = new Select(driver.findElement(By.name("dropdown")));
        dropdown.selectByIndex(2);
        System.out.println("Am selecetat la "+"\"Dropdown\"");
    }

    public static void scrollToSubmitButton () {
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(submitButton).build().perform();
        submitButton.click();
        System.out.println("Am facut scroll catre submit button");
    }

    public static void closeBrowser () {
        driver.quit();
        System.out.println("Am inchis browserul!");
    }
}
