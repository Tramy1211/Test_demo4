package Scripts;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.PurchasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class cinemaBooking extends BaseTest {
    @Test
    public void verifylogin() {
//    static WebDriver driver;
//    public static void main(String[] args){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        driver.get("https://demo1.cybersoft.edu.vn/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("2151013055my@ou.edu.vn", "123456");

//        Actions actions = new Actions(driver);
//        //Cuon toi home tool than ngang
//        WebElement hometool = driver.findElement(By.xpath("//div[@id='homeTool']"));
//        //Hanh dong cuon
//        actions.scrollToElement(hometool);
//
//        //hover vao bo phim
//        WebElement filmPlayButton = driver.findElement(By.xpath("//div[contains(@style, 'moana')]"));
//        actions.moveToElement(filmPlayButton).perform();
//
//        //Di click button mua ve
//        WebElement bookticket = driver.findElement(By.xpath("//a[(@href='/detail/11585') and (text()='MUA VÉ')]"));
//        bookticket.click();
//
//        //Chon thoi gian
//        WebElement booktime = driver.findElement(By.xpath("//a[@href='/purchase/46703']"));
//        booktime.click();
//
//        //Goi Purchase Page
//        PurchasePage purchasePage = new PurchasePage(driver);
//        purchasePage.purchaseSlot("113");


        //if(driver.getCurrentUrl(""))
//        HomePage homePage = new HomePage(driver);
//        homePage.selectedFilm();
    }
    @Test
    public void verifybooking() {
//    static WebDriver driver;
//    public static void main(String[] args){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        driver.get("https://demo1.cybersoft.edu.vn/");
        LoginPage loginPage = new LoginPage(driver);
        logger.info("bat dau chay");
        loginPage.login("2151013055my@ou.edu.vn", "123456");

        logger.info("login thanh cong");
        Actions actions = new Actions(driver);
        //Cuon toi home tool than ngang
        WebElement hometool = driver.findElement(By.xpath("//div[@id='homeTool']"));
        //Hanh dong cuon
        actions.scrollToElement(hometool);

        //hover vao bo phim
        WebElement filmPlayButton = driver.findElement(By.xpath("//div[contains(@style, 'moana')]"));
        actions.moveToElement(filmPlayButton).perform();

        //Di click button mua ve
        WebElement bookticket = driver.findElement(By.xpath("//a[(@href='/detail/11585') and (text()='MUA VÉ')]"));
        bookticket.click();

        logger.info("da click mua ve");
        //Chon thoi gian
        WebElement booktime = driver.findElement(By.xpath("//a[@href='/purchase/46703']"));
        booktime.click();

        //Goi Purchase Page
        PurchasePage purchasePage = new PurchasePage(driver);
        purchasePage.purchaseSlot("113");

        logger.info("mua ve thanh cong");

        //if(driver.getCurrentUrl(""))
//        HomePage homePage = new HomePage(driver);
//        homePage.selectedFilm();
    }
}
//}
