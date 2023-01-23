package sorinfoca.Tests.Tema8.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicAjaxPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BasicAjaxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToPage() {
        driver.get("https://testpages.herokuapp.com/styled/basic-ajax-test.html");
    }

    public void selectOption(String option) {
        Select select = new Select(driver.findElement(By.name("id")));
        select.selectByVisibleText(option);
    }

    public void clickCodeItInButton() {
        driver.findElement(By.name("language_id")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("body > div > div.centered > form > input.styled-click-button"), "#combo2 > option:nth-child(3)"));
    }

    public String getSelectedOption() {
        Select select = new Select(driver.findElement(By.name("language_id")));
        return select.getFirstSelectedOption().getText();
    }

    public boolean isOptionSelected(String option) {
        return getSelectedOption().equals(option);
    }
}

