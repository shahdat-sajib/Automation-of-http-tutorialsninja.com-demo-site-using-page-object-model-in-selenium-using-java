package TutorialNinja;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.List;

public class YourStorePage {
    private WebDriver driver;
    private By Desktops = By.xpath("//a[normalize-space()='Desktops']");
    private By AllDesktops = By.xpath("//a[normalize-space()='Show All Desktops']");
    private By Sorting = By.xpath("//select[@id='input-sort']");
    private By SortItem = By.xpath("(//div[@class='image'])");

    public YourStorePage(WebDriver driver) {
        this.driver = driver;
    }

    public void hoverOnDesktops(){
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(Desktops);
        action.moveToElement(element);
        action.perform();
        System.out.println("Hovering on Desktops");
    }

    public void clickShowAllDesktops(){
        driver.findElement(AllDesktops).click();
        System.out.println("Show All Desktops clicked");
    }

    public void sort(String str){
        Select select = new Select(driver.findElement(Sorting));
        select.selectByVisibleText(str);
        System.out.println("Items sorted according to" + str);
    }

    public void selectFirstItem(){
        List<WebElement> options = driver.findElements(SortItem);
        options.get(0).click();
        System.out.println("First Item clicked");
    }

//    public boolean verifyFirstItemHasLowestPrice(){
//        List<WebElement> products = driver.findElements(By.cssSelector(".product-layout"));
//        int lowestPrice;
//        try {
//            lowestPrice = Integer.parseInt(products.get(0).findElement(By.cssSelector("p.price > span.price-new")).getText().trim().replaceAll("$", ""));
//        } catch (Exception e) {
//            lowestPrice = Integer.parseInt(products.get(0).findElement(By.cssSelector("p.price")).getText().trim().replaceAll("$", ""));
//        }
//        for (int i = 1; i < products.size() ; i++) {
//            int comparisonPrice;
//            try {
//                comparisonPrice = Integer.parseInt(products.get(i).findElement(By.cssSelector("p.price > span.price-new")).getText().trim().replaceAll("$", ""));
//            } catch (Exception e) {
//                comparisonPrice = Integer.parseInt(products.get(i).findElement(By.cssSelector("p.price")).getText().trim().replaceAll("$", ""));
//            }
//            if(comparisonPrice < lowestPrice ){
//                return false;
//            }
//        }
//        return true;
//    }
}
