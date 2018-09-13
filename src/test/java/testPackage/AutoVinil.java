package testPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutoVinil {

    private WebDriver driver;

    @BeforeTest
    public final void setupTest() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://autovinil76.ru");
    }

    @AfterTest
    public final void teardown() {
        if (driver != null) {
            driver.close();
        }
    }

    @Test
    public final void validateHeaderHome() {
        Assert.assertTrue(driver.findElement(By.cssSelector("div.menu a[href='/']")).
                getText().contains("Главная"), ("Главная is matching"));
    }

    @Test
    public final void validateHeaderServices() {
        driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/uslugi/']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/uslugi/']")).
                getText().contains("Услуги"), ("Услуги is matching"));
    }

    @Test
    public final void validateHeaderItems() {
        driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/tovari/']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/tovari/']")).
                getText().contains("Товары"), ("Товары is matching"));
    }

    @Test
    public final void validateHeaderPrices() {
        driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/ceni/']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/ceni/']")).
                getText().contains("Цены"), ("Цены is matching"));
    }

    @Test
    public final void validateHeaderSales() {
        driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/akcii/']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/akcii/']")).
                getText().contains("Акции"), ("Акции is matching"));
    }

    @Test
    public final void validateHeaderArticles() {
        driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/stati/']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/stati/']")).
                getText().contains("Статьи"), ("Статьи is matching"));
    }

    @Test
    public final void validateHeaderPortfolio() {
        driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/portfolio/']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/portfolio/']")).
                getText().contains("Портфолио"), ("Портфолио is matching"));
    }

    @Test
    public final void validateHeaderAboutUs() {
        driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/o-nas/']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/o-nas/']")).
                getText().contains("О нас"), ("О нас is matching"));
    }

    @Test
    public final void validateHeaderContacts() {
        driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/kontakti/']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/kontakti/']")).
                getText().contains("Контакты"), ("Контакты is matching"));
    }
}
