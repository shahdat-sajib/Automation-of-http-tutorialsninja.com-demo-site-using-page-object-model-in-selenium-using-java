package TutorialNinja;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterSuccessPage {
    private WebDriver driver;
    private By successMessage = By.xpath("//*[@id='content']/h1");
    private By cont = By.xpath("//a[contains(text(),'Continue')]");

    public RegisterSuccessPage(WebDriver driver){
    this.driver = driver;
    }

    public void verifySuccessMessage() {
        String expectedText = "Your Account has Been Created!";
        String actualText = driver.findElement(successMessage).getText();
        boolean boo = expectedText.equalsIgnoreCase(actualText);
        if (boo) {
            System.out.println("Success message is visible");
        }
        else {
            System.out.println("Error message is visible");
        }
    }

    public void clickOnContinue() {
        driver.findElement(cont).click();
        System.out.println("Continue has been clicked");
    }
}
