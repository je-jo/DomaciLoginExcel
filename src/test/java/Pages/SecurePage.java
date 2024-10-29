package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecurePage {

    WebDriver driver;
    WebElement btnLogOut;

    public SecurePage(WebDriver driver) {
        this.driver = driver;
    }

    // geteri

    public WebElement getBtnLogOut() {
        return driver.findElement(By.xpath("/html/body/div[2]/div/div/a"));
    }
}
