package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void login(String username, String password){
        driver.findElement(By.xpath("//a[@href='/sign-in']")).click();
        driver.findElement(By.xpath("//input[@id='taiKhoan']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='matKhau']")).sendKeys(password);
        /* Kiem tra o nho tai khoan da duoc check chua
        Neu chua check thi check vao */

        WebElement remember = driver.findElement(By.name("remember"));
        boolean isRemember = remember.isSelected();
        //if isRemember == false, di toi remember va click
        if (isRemember){
            remember.click();
        }

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
