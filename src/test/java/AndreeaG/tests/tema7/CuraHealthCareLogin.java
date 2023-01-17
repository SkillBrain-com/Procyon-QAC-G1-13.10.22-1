package AndreeaG.tests.tema7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CuraHealthCareLogin  extends BaseTest{
     @DataProvider
     public Object [] [] loginDataProvider
    @Test
    public void loginWithValidCredentials(){
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement menu = driver.findElement(By.cssSelector(".btn-dark.btn-lg.toggle"));
        menu.click();
        WebElement loginLink = driver.findElement(By.linkText("Login"));
        loginLink.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login",
                "Couldn't navigate to login page!");

        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys( "John Doe");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("this is not a password");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        WebElement unsuccessfulLoginMessage = driver.findElement(By.className("text-danger"));
        Assert.assertEquals(unsuccessfulLoginMessage.getText(),
                "Login failed! Please ensure the username and password are valid.",
                " Should not navigate!");
    }
}
