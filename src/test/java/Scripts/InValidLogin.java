package Scripts;

import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class InValidLogin {
    static WebDriver driver;

    public void inValidLogin() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo1.cybersoft.edu.vn/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("2151013055my@ou.edu.vn", "tramy");
        //loginPage.verifyErrorMessageIsDisplay();

    }
}