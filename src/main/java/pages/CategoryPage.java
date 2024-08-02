package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class CategoryPage {
    private WebDriver driver;
    private WebDriverWait wait;


    public CategoryPage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='https://rozetka.com.ua/ua/computers-notebooks/c80253/']")
    public static WebElement nameofCategory;
    public void clickOnCategory(){
        wait.until(ExpectedConditions.elementToBeClickable(nameofCategory)).click();
    }

    @FindBy(xpath = "//a[contains(text(),'Монітори')]")
    public static WebElement monitorChooseCategory;
    public void clickOnMonitorCategory(){
        wait.until(ExpectedConditions.elementToBeClickable(monitorChooseCategory)).click();
    }


    @FindBy(xpath = "//rz-indexed-link[@data-id='Aorus']")
    public static WebElement aorusFiltr;
    public void clickOnAorusFiltr(){
        wait.until(ExpectedConditions.elementToBeClickable(aorusFiltr)).click();
    }


    @FindBy(xpath = "//*[@class='catalog-grid__cell catalog-grid__cell_type_slim ng-star-inserted']")
    private List<WebElement> products;
    public int getNumberOfProducts() {
        wait.until(ExpectedConditions.visibilityOfAllElements(products));
        return products.size();
    }


}
