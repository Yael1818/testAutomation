package Exercises;

import Exercises.Pages.BooksPage;
import Exercises.Pages.LoginPage;
import Exercises.Pages.ProfilPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class Base {
    protected static WebDriver driver;
    LoginPage loginPage;

    BooksPage booksPage;
    ProfilPage profilPage;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        booksPage = PageFactory.initElements(driver, BooksPage.class);
        profilPage = PageFactory.initElements(driver, ProfilPage.class);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
//    @AfterMethod
//    public void after() throws InterruptedException {
//        Thread.sleep(4000);
//
//    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }
}
