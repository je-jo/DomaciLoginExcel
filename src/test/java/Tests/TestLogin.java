package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogin extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("http://the-internet.herokuapp.com/login");
        loginPage.getInputUsername().clear();
        loginPage.getInputPassword().clear();
    }

    @Test
    public void userCanLogInWithValidCredentials() {
        String validUsername = excelReader.getStringData("Sheet1", 1, 0);
        String validPassword = excelReader.getStringData("Sheet1", 1, 1);
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        loginPage.clickLoginBtn();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
        Assert.assertTrue(securePage.getBtnLogOut().isDisplayed());
    }

    @Test
    public void userCannotLogInWithInvalidUsername() throws InterruptedException {
        for (int i = 1; i < excelReader.getLastRow("Sheet1") + 1; i++) {
            loginPage.getInputUsername().clear();
            loginPage.getInputPassword().clear();
            String invalidUsername = excelReader.getStringData("Sheet1", i, 2);
            String validPassword = excelReader.getStringData("Sheet1", 1, 1);
            loginPage.enterUsername(invalidUsername);
            loginPage.enterPassword(validPassword);
            loginPage.clickLoginBtn();
        }
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
        Assert.assertTrue(loginPage.getBtnLogin().isDisplayed());
        Assert.assertTrue(loginPage.getMsgAlert().getText().contains("Your username is invalid!"));
    }

    @Test
    public void userCannotLogInWithInvalidPassword() throws InterruptedException {
        for (int i = 1; i < excelReader.getLastRow("Sheet1") + 1; i++) {
            loginPage.getInputUsername().clear();
            loginPage.getInputPassword().clear();
            String validUsername = excelReader.getStringData("Sheet1", 1, 0);
            String invalidPassword = excelReader.getStringData("Sheet1", i, 3);
            loginPage.enterUsername(validUsername);
            loginPage.enterPassword(invalidPassword);
            loginPage.clickLoginBtn();
        }
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
        Assert.assertTrue(loginPage.getBtnLogin().isDisplayed());
        Assert.assertTrue(loginPage.getMsgAlert().getText().contains("Your password is invalid!"));
    }

    @Test
    public void userCannotLogInWithInvalidCredentials() throws InterruptedException {
        for (int i = 1; i < excelReader.getLastRow("Sheet1") + 1; i++) {
            loginPage.getInputUsername().clear();
            loginPage.getInputPassword().clear();
            String invalidUsername = excelReader.getStringData("Sheet1", i, 2);
            String invalidPassword = excelReader.getStringData("Sheet1", i, 3);
            loginPage.enterUsername(invalidUsername);
            loginPage.enterPassword(invalidPassword);
            loginPage.clickLoginBtn();
        }
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
        Assert.assertTrue(loginPage.getBtnLogin().isDisplayed());
        Assert.assertTrue(loginPage.getMsgAlert().getText().contains("Your username is invalid!"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
