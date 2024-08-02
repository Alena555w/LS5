package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Main {
    private WebDriver driver;
    public Main(WebDriver driver){
        this.driver = driver;
    }

    private By findLogoIcon = By.xpath("//li[@class=\"header-actions__item header-actions__item--user\"]");
    private By submitButton = By.xpath("//button[contains(text(),' Увійти через пошту ')]");


    public WebElement getFindLogoIcon(){
    return driver.findElement(findLogoIcon);
    }

    public WebElement getButton(){
        return driver.findElement(submitButton);
    }

    public void submitButton(){
       getFindLogoIcon().click();
    }

    public void clickOnButton(){
        getButton().click();
    }

}
