package dz;

import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.ComparisonPage;
import pages.LoginPage;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;
import static pages.LoginPage.errorMessage;

@Listeners({AllureTestNg.class})
public class RozetkaTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPage login;
    private  CategoryPage category;
    private ComparisonPage compare;



    @BeforeTest
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
        login = new LoginPage(driver);
        category = new CategoryPage(driver);
        compare = new ComparisonPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }


    @Test
    public void Login() {
        login.clickOnLogoIcon();
        login.clickOnSubmitButton();
        login.enterEmail();
        login.enterPassword();
        login.clickOnLoadButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form__hint form__hint_type_warning")));
        login.waitErrorMessage();
        Assert.assertTrue(errorMessage.isDisplayed(), "Користувач з логіном testLS@gmail.com не зареєстрований");
    }


    @Test
    public void FiltrCategory() {
        driver.get("https://rozetka.com.ua/ua/computers-notebooks/c80253/");
        category.clickOnMonitorCategory();
        category.clickOnAorusFiltr();
        wait.until(ExpectedConditions.titleContains("Aorus"));
        int numberOfProducts = category.getNumberOfProducts();
        Assert.assertEquals(1, numberOfProducts,"Number of products is not equal to 1");
    }


  @Test
  public void compareTest(){
      compare.navigateTo("https://rozetka.com.ua/ua/computers-notebooks/c80253/");
      compare.clickOnCategory();
      compare.addToCompare();
      compare.Appearnotification();
      compare.addToCompareTwo();
      compare.clickOnComparePage();
      int numberOfComparisonProducts = compare.getNumberOfComparisonProducts();
      Assert.assertEquals(numberOfComparisonProducts, 2, "Number of comparison products is not equal to 2");
  }


    @AfterTest
    public void closeDriver(){
        driver.quit();
    }


}

