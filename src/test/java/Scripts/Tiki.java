package Scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class Tiki {
    static WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tiki.vn/");
    }

    @BeforeMethod
    public void nagigatehomepage(){
        driver.get("https://tiki.vn/");
    }

    @Test
    public void testTitle(){
        String title = driver.getTitle();
        //Assert.assertEquals(title, "Tiki");
        Assert.assertTrue(title.contains("Tiki"));
    }

    @Test
    public void search(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//img[@alt='close-icon']")).click();
        driver.findElement(By.xpath("//div[@class='sc-dec0a11d-1 cfhkdd']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@data-view-id='main_search_form_input']")));
        search.sendKeys("adidas");

        //Nhấn Enter để tìm kiếm
        search.sendKeys(Keys.RETURN);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> items = driver.findElements(By.xpath("//div[contains(@class, 'sc-2d0320b9-0 gHqeOl')]//h3"));
        //List<WebElement> items = driver.findElements(By.cssSelector("div[data-view-id^='product_list_item'] a h3"));
        int count = Math.min(8, items.size());
        for (int i = 0; i < count; i++){
            String title = items.get(i).getText().toLowerCase();
            System.out.println("Item " + (i + 1) + " :" + title);
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(title.contains("adidas"), "Item " + (i + 1) + " khong chua chu adidas");
            //Assert.assertTrue(title.contains("adidas"), "Item " + (i + 1) + " khong chua chu adidas");
        }

    }

    @Test
    public void search2(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//img[@alt='close-icon']")).click();
        driver.findElement(By.xpath("//div[@class='sc-dec0a11d-1 cfhkdd']")).click();
        WebElement search = driver.findElement(By.xpath("//input[@data-view-id='main_search_form_input']"));
        search.sendKeys("samsung");
        //Nhấn Enter để tìm kiếm
        search.sendKeys(Keys.RETURN);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> items = driver.findElements(By.xpath("//div[contains(@class, 'sc-2d0320b9-0 gHqeOl')]//h3"));
        //List<WebElement> items = driver.findElements(By.cssSelector("div[data-view-id^='product_list_item'] a h3"));
        int count = Math.min(8, items.size());
        for (int i = 0; i < count; i++){
            String title = items.get(i).getText().toLowerCase();
            System.out.println("Item " + (i + 1) + " :" + title);
            Assert.assertTrue(title.contains("samsung"), "Item " + (i + 1) + " khong chua chu samsung");
        }

    }

//    @AfterClass
//    public void tearDown(){ //tearDown là dọn dẹp
//        //driver.close(); //Đóng tab hiện tại
//        driver.quit(); //Đóng tất cả các tab được mở
//    }
}
