package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ComparisonPage {
    private WebDriver driver;
    private WebDriverWait wait;


    public ComparisonPage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public void navigateTo(String url) {
        driver.get("https://rozetka.com.ua/ua/computers-notebooks/c80253/");
    }


    @FindBy(xpath = "//a[contains(text(),'Монітори')]")
    public static WebElement monitorCategory;
    public void clickOnCategory(){
        wait.until(ExpectedConditions.elementToBeClickable(monitorCategory)).click();
    }


    @FindBy(xpath = "//button[contains(@class, 'compare-button')]")
    private WebElement compareButton;
    public void addToCompare() {
        wait.until(ExpectedConditions.elementToBeClickable(compareButton)).click();
    }

    @FindBy(css = "notification__wrapper notification__wrapper--success")
    private WebElement notification;
    public void Appearnotification(){
        wait.until(ExpectedConditions.visibilityOf(notification));
    }

    @FindBy(xpath = "//button[contains(@class, 'compare-button')]")
    private WebElement compareButtonTwo;
    public void addToCompareTwo() {
        wait.until(ExpectedConditions.elementToBeClickable(compareButtonTwo)).click();
    }

    @FindBy(xpath = "//li[@class='header-actions__item header-actions__item--comparison ng-star-inserted']")
    private WebElement buttonCompare;
    public void  clickOnComparePage(){
        wait.until(ExpectedConditions.elementToBeClickable(buttonCompare)).click();
    }

    @FindBy(css = ".comparison-product__item")
    private List<WebElement> comparisonProducts;
    public int getNumberOfComparisonProducts() {
        wait.until(ExpectedConditions.visibilityOfAllElements(comparisonProducts));
        return comparisonProducts.size();
    }

}


