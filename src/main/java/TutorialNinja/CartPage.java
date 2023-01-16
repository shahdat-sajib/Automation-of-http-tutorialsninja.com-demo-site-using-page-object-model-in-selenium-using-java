package TutorialNinja;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private By qty = By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[4]/div/input");
    private By total = By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[6]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyQuantity(String qntity) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(qty));
        String actualQty = driver.findElement(qty).getAttribute("value");
        boolean boo = qntity.equalsIgnoreCase(actualQty);
        if (boo) {
            System.out.println("Quantity is correct");
        }
        else {
            System.out.println("Quantity is wrong");
        }
    }

    public void verifyTotal(String expecQntity) {
        String actualTotal = driver.findElement(total).getText();
        boolean boo = expecQntity.equalsIgnoreCase(actualTotal);
        if (boo) {
            System.out.println("Total value is correct");
        }
        else {
            System.out.println("Total value is wrong");
        }
    }

}
