package listeners;
import Scripts.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class SimpleListeners implements ITestListener {
    public void onTestStart(org.testng.ITestResult result) { /* compiled code */ }
    public void onTestSuccess(org.testng.ITestResult result) { /* compiled code
     */ }
    public void onTestFailure(org.testng.ITestResult result) {
//        /* compiled code */
//        System.out.println("This test is failed");
        //in ra ten test case de biet la dang chup hinh cho test nao
        System.out.println("Screenshot captured for test case: " + result.getName());

        Object currentClass = result.getInstance();

        //Tai BaseTest de goi getdriver va lay webdriver dang dung cho test
        WebDriver driver = ((BaseTest) currentClass).getDriver();

        //ep webdriver thanh TakeScreenShot
        //goi getScreenshotAs de chup man hinh va luu tạm vao srcFile
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {

            Date date = new Date();

            //tao duong dan den thu muc screenshots, ten file la ten test case.png

            //date.getTime() -> doi gio https://www.epochconvert.com/
            String filePath = "." + File.separator + "screenshots" + File.separator + result.getName() + "_" + date.getTime() + ".png";
            File destFile = new File(filePath);
            destFile.getParentFile().mkdirs();
            //mkdirs => de dam bao thu muc chu ton tai

            //Sao chep anh tu file tam sang noi luu chinh thuc
            FileHandler.copy(srcFile, destFile);

            System.out.println("Screenshot saved: " + filePath);

        }
        catch (IOException e)
        { e.printStackTrace();
        }
    }
    public void onTestSkipped(org.testng.ITestResult result) { /* compiled code */
    }
    public void onTestFailedButWithinSuccessPercentage(org.testng.ITestResult
                                                               result) { /* compiled code */ }
    public void onTestFailedWithTimeout(org.testng.ITestResult result) { /*
compiled code */ }
    public void onStart(org.testng.ITestContext context) { /* compiled code */ }
    public void onFinish(org.testng.ITestContext context) { /* compiled code */ }
}