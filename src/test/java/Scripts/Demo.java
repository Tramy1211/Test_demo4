package Scripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Demo {
    static WebDriver driver;

    @BeforeClass
    public void TestAClass(){
        System.out.println("Test before class running");
    }

    @BeforeSuite
    public void TestASuite(){
        System.out.println("Test before suite running");
    }

    @BeforeTest
    public void TestATest(){
        System.out.println("Test before test running");
    }
    @BeforeMethod
    public void TestA(){
        System.out.println("Test before method running");
    }
    @Test
    public void testcase1(){
        int a = 2 + 3;
        Assert.assertEquals(a,6); //Ham kiem tra ho tro trong Java
        System.out.println("Test case 01 running");
    }

    @Test
    public void testcase2(){
        System.out.println("Test case 02 running");
    }

//    @Parameters({"Username", "Password"}) // Tham số hóa để truyền dữ liệu
//    public void logintest(String user, String pass){
//
//    }

    @AfterMethod
    public void TestB(){
        System.out.println("Test after method running");
    }

    @AfterTest
    public void TestBTest(){
        System.out.println("Test after test running");
    }
    @AfterClass
    public void TestBClass(){
        System.out.println("Test after class running");
    }
    @AfterSuite
    public void TestBSuite(){
        System.out.println("Test after suite running");
    }

}
