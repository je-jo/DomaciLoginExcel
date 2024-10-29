package Base;

import Pages.LoginPage;
import Pages.SecurePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    /*
    Domaci:
Pokusati login na sledecem sajtu: http://the-internet.herokuapp.com/login
Testirati:
1. valid username, valid password
2. invalid username, valid password
3. valid username, invalid password
4. invalid username, invalid password
Koristiti ucitavanje username-a i password-a iz excel-a
     */

    public WebDriver driver;
    public ExcelReader excelReader;
    public LoginPage loginPage;
    public SecurePage securePage;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        excelReader = new ExcelReader("Data.xlsx");
        loginPage = new LoginPage(driver);
        securePage = new SecurePage(driver);
    }

}
