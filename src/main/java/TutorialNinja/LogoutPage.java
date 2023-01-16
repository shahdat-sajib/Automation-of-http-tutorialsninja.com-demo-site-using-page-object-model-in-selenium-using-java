package TutorialNinja;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
    private WebDriver driver;
    private By logoutMsg = By.xpath("//h1[contains(text(),'Account Logout')]");
    private By myAccount = By.xpath("//a[@title='My Account']");
    private By logout = By.xpath("//a[contains(text(),'Logout')]");

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLogoutMsg() {
        String expectedMsg = "Account Logout";
        String actualMsg = driver.findElement(logoutMsg).getText();
        boolean boo = expectedMsg.equalsIgnoreCase(actualMsg);
        if (boo) {
            System.out.println("Logout success message is visible");
        }
        else {
            System.out.println("Logout message is not visible");
        }
    }

    public void clickOnMyAccount() {
        driver.findElement(myAccount).click();
        System.out.println("My account has been clicked");
    }

    public void clickOnLogout() {
        driver.findElement(logout).click();
        System.out.println("Logout has been clicked");
    }
}
