package TutorialNinja;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstProductPage {
    private WebDriver driver;
    private By qty = By.xpath("//input[@id='input-quantity']");
    private By addBtn = By.xpath("//button[@id='button-cart']");
    private By cartBtn = By.xpath("//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']");
    private By viewCart = By.xpath("//strong[normalize-space()='View Cart']");

    public FirstProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterQuantity() {
        WebElement qnty=  driver.findElement(qty);
        qnty.clear();
        qnty.sendKeys("3");
        System.out.println("Quantity modified");
    }

    public void clickOnAddToCart(){
        driver.findElement(addBtn).click();
        System.out.println("Add to cart clicked");
    }

    public void clickOnCartButton() {
        driver.findElement(cartBtn).click();
        System.out.println("Cart button clicked");
    }

    public void clickOnViewCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewCart));
        driver.findElement(viewCart).click();
        System.out.println("View cart clicked");
    }
}
