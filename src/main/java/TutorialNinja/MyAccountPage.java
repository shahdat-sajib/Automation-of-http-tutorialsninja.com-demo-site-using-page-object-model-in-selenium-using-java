package TutorialNinja;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    private WebDriver driver;
    private By yourStore = By.xpath("//a[contains(text(),'Your Store')]");
    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnYourStore() {
        driver.findElement(yourStore).click();
        System.out.println("Your Store clicked");
    }
}
