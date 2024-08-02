package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@class=\"header-actions__item header-actions__item--user\"]")
    public static WebElement LogoIcon;

    public void clickOnLogoIcon(){
        wait.until(ExpectedConditions.elementToBeClickable(LogoIcon)).click();
    }

    @FindBy(xpath = "//button[contains(text(),' Увійти через пошту ')]")
    public static WebElement SubmitButton;

    public void clickOnSubmitButton(){
        wait.until(ExpectedConditions.elementToBeClickable(SubmitButton)).click();
    }

    @FindBy(xpath = "//input[@id=\"email\"]")
    public static WebElement Email;
    public void enterEmail(){
        Email.sendKeys("testLS@gmail.com");
    }

    @FindBy(xpath = "//input[@id=\"password\"]")
    public static WebElement Password;
    public void enterPassword(){
        Password.sendKeys("ghcjh");
    }

    @FindBy(xpath = "//button[contains(text(),'Продовжити')]")
    public static WebElement loadButton;
    public void clickOnLoadButton(){
        wait.until(ExpectedConditions.elementToBeClickable(loadButton)).click();
    }

    @FindBy(css = "form__hint form__hint_type_warning")
    public static WebElement errorMessage;
    public void waitErrorMessage(){
       wait.until(ExpectedConditions.visibilityOf(errorMessage));
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }
}








