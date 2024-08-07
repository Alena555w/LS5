package dz;

import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

@Listeners({AllureTestNg.class})
public class SecondTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
          public void setDriver() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void homeTest(){
        WebElement writeText = driver.findElement(By.cssSelector(".search-form__input"));
        writeText.sendKeys("computer");

        WebElement submitButton = driver.findElement(By.cssSelector("button.button_color_green.button_size_medium.search-form__submit"));
        submitButton.click();

        WebElement productCard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@title,\"Fall of Man\")]")));
        productCard.click();
//        driver.findElement(By.xpath("//a[contains(@title,\"Fall of Man\")]"));
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }


}