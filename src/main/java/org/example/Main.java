package org.example;
import TutorialNinja.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Random;

public class Main {
    static WebDriver driver = null;
    public static WebDriver selectBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) { //Driver for Chrome browser
            WebDriverManager.chromedriver().arch64().setup();
            driver= new ChromeDriver();
            System.out.println("I'm in the Chrome browser!");
        } else if (browserName.equalsIgnoreCase("firefox")) { //Driver for Firefox browser
            WebDriverManager.firefoxdriver().arch64().setup();
            driver= new FirefoxDriver();
            System.out.println("I'm in the Firefox browser!");
        } else if (browserName.equalsIgnoreCase("edge")) { //Driver for Edge browser
            WebDriverManager.edgedriver().arch64().setup();
            driver = new EdgeDriver();
            System.out.println("I'm in the Edge browser!");
        } else {
            System.out.println("Invalid Browser");
        }
        return driver;
    }

    //HomePage with click on My account > Register
    static HomePage objHomePage;
    public static void gotoHomepageOnclickMyaccountRegister(){
        objHomePage = new HomePage(driver);
        objHomePage.clickOnMyAccount();
        objHomePage.clickOnRegister();
    }

    //Register Page with registration Form including random email and click on Continue button
    static RegistarPage objRegisterPage;
    //Random email generator
    public static String getRandomEmail() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
    //Registration form fill up and click on Continue
    public static void enterRegistrationFormSubmit(String email){
        objRegisterPage = new RegistarPage(driver, email);
        objRegisterPage.enterFirstName("Shahdat");
        objRegisterPage.enterLastName("Hosain");
        objRegisterPage.enterEmail();
        objRegisterPage.enterTelephone("01777481417");
        objRegisterPage.enterPassword("123456");
        objRegisterPage.enterPassConfirm("123456");
        objRegisterPage.clickOnNewsletterSubscribe();
        objRegisterPage.clickOnPrivacyPolicy();
        objRegisterPage.clickOnContinue();
    }

    //verify registration success message
    static RegisterSuccessPage objRegisterSuccessPage;
    public static void verifySuccessMessageContinue() {
        objRegisterSuccessPage = new RegisterSuccessPage(driver);
        objRegisterSuccessPage.verifySuccessMessage();
        objRegisterSuccessPage.clickOnContinue();
    }

    //Go to My account page by clicking on "your store"
    static MyAccountPage objMyAccountPage;
    public static void clickYourStore() {
        objMyAccountPage = new MyAccountPage(driver);
        objMyAccountPage.clickOnYourStore();
    }

    //After login My homepage with hover on Desktops, Click on Show All Desktops, sorting and select first item
    static YourStorePage objYourStorePage;
    public static void hoverOverDesktopsClickOnShowAllDesktops(){
        objYourStorePage = new YourStorePage(driver);
        objYourStorePage.hoverOnDesktops();
        objYourStorePage.clickShowAllDesktops();
        objYourStorePage.sort("Price (Low > High)");
        objYourStorePage.sort("Price (High > Low)");
        objYourStorePage.selectFirstItem();
//        objYourStorePage.verifyFirstItemHasLowestPrice();
    }

    //First product view page with enter quantity and add to cart
    static FirstProductPage objFirstProductPage;
    public static void modifyQuantityAddCartVerify(){
        objFirstProductPage = new FirstProductPage(driver);
        objFirstProductPage.enterQuantity();
        objFirstProductPage.clickOnAddToCart();
        objFirstProductPage.clickOnCartButton();
        objFirstProductPage.clickOnViewCart();
    }

    //Verify the total quantity in checkout
    static CartPage objCartPage;
    public static void verifyQuantityTotalValueAndLogout() {
        objCartPage = new CartPage(driver);
        objCartPage.verifyQuantity("5");
        objCartPage.verifyTotal("$3,606.00");
    }

    //Verify logout success message
    static LogoutPage objLogoutPage;
    public static void verifyLogoutMessage(){
        objLogoutPage = new LogoutPage(driver);
        objLogoutPage.clickOnMyAccount();
        objLogoutPage.clickOnLogout();
        objLogoutPage.verifyLogoutMsg();
    }

    //main method
    public static void main(String[] args) {
        String[] browsers = {"chrome"};
        for (String browser : browsers) {
            WebDriver driver = selectBrowser(browser);
            if(driver == null){
                System.out.println("Task Ended");
            }else {
                for (int i = 0; i < 1; i++) {
                    driver.get("http://tutorialsninja.com/demo");
                    gotoHomepageOnclickMyaccountRegister();
                    enterRegistrationFormSubmit(getRandomEmail()+"@gmail.com");
                    verifySuccessMessageContinue();
                    clickYourStore();
                    hoverOverDesktopsClickOnShowAllDesktops();
                    modifyQuantityAddCartVerify();
                    verifyQuantityTotalValueAndLogout();
                    verifyLogoutMessage();
                    try {
                        Thread.sleep(1500);
                        System.out.println("Waited for 1.5 seconds.");
                    } catch (InterruptedException e) {System.out.println("Interrupted while sleeping.");}
                }
                driver.quit();
            }
        }
    }
}