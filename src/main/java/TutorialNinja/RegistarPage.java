package TutorialNinja;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
public class RegistarPage {
    private WebDriver driver;
    private String emailText;
    private By scroll;
    private By firstname = By.xpath("//input[@id='input-firstname']");
    private By lastname = By.xpath("//input[@id='input-lastname']");
    private By email = By.xpath("//input[@id='input-email']");
    private By telephone = By.xpath("//input[@id='input-telephone']");
    private By password = By.xpath("//input[@id='input-password']");
    private By passwordConfirm = By.xpath("//input[@id='input-confirm']");
    private By subscribe = By.xpath("//input[@name='newsletter' and @value='1']");
    private By privacyPolicy = By.xpath("//input[@name='agree' and @value='1']");
    private By contin = By.xpath("//input[@value='Continue']");

    public RegistarPage(WebDriver driver, String emailText) {
        this.driver = driver;
        this.emailText = emailText;
    }

    public void scrollTo(By section) {
        scroll = section;
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView()", driver.findElement(scroll));
        System.out.println("page scrolled");
    }

    public void enterFirstName(String fname) {
        driver.findElement(firstname).sendKeys(fname);
        System.out.println("Firstname entered");
    }

    public void enterLastName(String lname) {
        driver.findElement(lastname).sendKeys(lname);
        System.out.println("Lastname entered");
    }

    public void enterEmail() {
        driver.findElement(email).sendKeys(emailText);
        System.out.println("Email entered");
    }

    public void enterTelephone(String phone) {
        driver.findElement(telephone).sendKeys(phone);
        System.out.println("Telephone entered");
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
        System.out.println("Password entered");
    }

    public void enterPassConfirm(String confrmPass) {
        driver.findElement(passwordConfirm).sendKeys(confrmPass);
        System.out.println("Password confirm entered");
    }

    public void clickOnNewsletterSubscribe() {
        boolean isSelected = driver.findElement(subscribe).isSelected();

        if (isSelected == false) {
            driver.findElement(subscribe).click();
            System.out.println("Newsletter subscribe radio button clicked");
        }
    }

    public void clickOnPrivacyPolicy() {
        scrollTo(privacyPolicy);
        boolean isSelected = driver.findElement(privacyPolicy).isSelected();

        // if element is not selected
        if (isSelected == false) {
            driver.findElement(privacyPolicy).click();
            System.out.println("Privacy policy checkbox has been clicked");
        }
    }

    public void clickOnContinue() {
        driver.findElement(contin).click();
        System.out.println("Continue button has been clicked");
    }
}
