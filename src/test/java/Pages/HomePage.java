package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void selectedFilm(){
        driver.findElement(By.xpath("(//a[@href='/detail/11585'])[1]")).click();
        driver.findElement(By.xpath("(//a[normalize-space()='Mua vé'])[1]")).click();
        driver.findElement(By.xpath("//a[@href='/purchase/46703']")).click();
        //Do vi tri 100 da duoc dat nen khi su dung doi xpath o ghe con trong
        driver.findElement(By.xpath("//span[normalize-space()='100']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'ĐẶT VÉ')]")).click();
    }
}
