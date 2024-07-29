import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SecondTest {
    private WebDriver driver;

    @BeforeTest
          public void setDriver() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
    }

    @Test
    public void homeTest(){
        WebElement writeText = driver.findElement(By.cssSelector(".search-form__input"));
        writeText.sendKeys("computer");

        WebElement submitButton = driver.findElement(By.cssSelector("button.button_color_green.button_size_medium.search-form__submit"));
        submitButton.click();

        WebElement productCard = driver.findElement(By.xpath("//a[@title='Игра PS3 Resistance: Fall of Man (Blu-ray диск) (5603311017559) ']"));
        productCard.click();

    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }


}