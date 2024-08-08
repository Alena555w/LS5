package dz;

import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestLogin {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }


    @Test
    public void TestLogin() {

        WebElement findLogoIcon = driver.findElement(By.xpath("//li[@class=\"header-actions__item header-actions__item--user\"]"));
        findLogoIcon.click();

       WebElement waitProcess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Увійти через пошту')]")));
        waitProcess.click();

        WebElement InputEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"email\"]")));
        InputEmail.sendKeys("testLS@gmail.com");

        WebElement InputPassword = driver.findElement(By.xpath("//input[@id=\"password\"]"));
        InputPassword.sendKeys("ghcjh");

        WebElement submitButtonlick = driver.findElement(By.xpath("//button[contains(text(),'Продовжити')]"));
        submitButtonlick.click();

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form__hint form__hint_type_warning")));
        Assert.assertTrue(errorMessage.isDisplayed(), "Користувач з логіном testLS@gmail.com не зареєстрований");
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }


}
