package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;
    WebElement inputUsername;
    WebElement inputPassword;
    WebElement btnLogin;
    WebElement msgAlert;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // geteri

    public WebElement getInputUsername() {
        return driver.findElement(By.id("username"));
    }

    public WebElement getInputPassword() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getBtnLogin() {
        return driver.findElement(By.cssSelector("button[type='submit']"));
    }

    public WebElement getMsgAlert() {
        return driver.findElement(By.id("flash"));
    }

    // metode

    public void enterUsername(String username) {
        getInputUsername().sendKeys(username);
    }

    public void enterPassword(String password) {
        getInputPassword().sendKeys(password);
    }

    public void clickLoginBtn() {
        getBtnLogin().click();
    }
}
