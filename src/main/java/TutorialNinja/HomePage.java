package TutorialNinja;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    //    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    private By myAccount = By.xpath("//a[@title='My Account']");
    private By register = By.xpath("//a[contains(text(),'Register')]");

    public HomePage (WebDriver driver){
        this.driver = driver;
    }

    public void clickOnMyAccount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(myAccount));

        driver.findElement(myAccount).click();
        System.out.println("My account has been clicked");
    }

    public void clickOnRegister() {
        driver.findElement(register).click();

        System.out.println("Register has been clicked");
    }
}
