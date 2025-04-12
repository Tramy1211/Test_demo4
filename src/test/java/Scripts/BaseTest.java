package Scripts;

import drivers.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    //Tao nhieu trinh duyet de test (Cross Browser Testing)
//    WebDriver driver2;

    static Logger logger = LogManager.getLogger("testBookingFromHomePage");
    @BeforeMethod

    @Parameters({"browser"})
    public void setupTest(String browser){
        logger.info("Setting up WebDriver!!");
        DriverFactory driverFactory = new DriverFactory();
        driverFactory.setDriver(browser);
        driver = driverFactory.getDriver();
  //      String browser = "Firefox";
//        if (browser == "Chrome"){
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//        } else if(browser == "Firefox") {
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//        } else{
//            WebDriverManager.edgedriver().setup();
//            driver = new EdgeDriver();
//        }

//        switch (browser){
//            case "Chrome":
//                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
//                break;
//            case "Firefox":
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();
//                break;
//            case "Edge":
//                WebDriverManager.edgedriver().setup();
//                driver = new EdgeDriver();
//                break;
//            default:
//                System.out.println("This browser is not support");
//        }
//
////        WebDriverManager.chromedriver().setup();
////        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
        driver.get("https://demo1.cybersoft.edu.vn/");
        logger.info("da truy cap web thanh cong");
    }

    public WebDriver getDriver(){
        return driver;
    }
    void teardown(){
        driver.quit();
    }
    @AfterClass
    public void tearDown(){ //tearDown là dọn dẹp
        //driver.close(); //Đóng tab hiện tại
        driver.quit(); //Đóng tất cả các tab được mở
    }
}
