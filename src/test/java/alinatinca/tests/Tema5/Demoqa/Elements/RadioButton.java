package alinatinca.tests.Tema5.Demoqa.Elements;

<<<<<<< HEAD
import alinatinca.BrowserManager;
=======
import alinatinca.driver.BrowserManager;
>>>>>>> main
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {

    public static void main(String[] args) {
        goToTheRadioButton();
        //check if the method called goToTheRadioButton is done successfully
    }

    public static void goToTheRadioButton(){
        //create the method called goToTheRadioButton that goes to the section called Radio Button and it identifies one element from there and it makes operation on it
        ChromeDriver driver = BrowserManager.createChromeDriver();
        //create and configure the Chrome browser page settings
        driver.get("https://demoqa.com/radio-button");
        //go to the Demoqa URL
        WebElement radioButtonSection = driver.findElement(By.cssSelector("#item-2"));
        //find the section called Radio Button
        radioButtonSection.click();
        //click on this section
        WebElement yesRadio = driver.findElement(By.cssSelector("label[for='yesRadio']"));
        //find the box asignated to the field called Yes
        yesRadio.click();
        //tick this section
        System.out.println("The message displayed is: " + yesRadio.getText());
        driver.quit();
        //close the Chrome browser page
    }
}
