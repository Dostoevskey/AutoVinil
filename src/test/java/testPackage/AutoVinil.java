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

    @Test
    public final void validateHeaderHome() {
        Assert.assertEquals(driver.findElement(By.cssSelector("div.menu a[href='/']")).
                getText(),"Главная");
            }

    @Test
    public final void validateHeaderServices() {
        driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/uslugi/']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/uslugi/']")).
                getText(),"Услуги");
    }

    @Test
    public final void validateHeaderItems() {
        driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/tovari/']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/tovari/']")).
                getText(),"Товары");
    }

    @Test
    public final void validateHeaderPrices() {
        driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/ceni/']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/ceni/']")).
                getText(),"Цены");
    }

    @Test
    public final void validateHeaderSales() {
        driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/akcii/']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/akcii/']")).
                getText(),"Акции");
    }

    @Test
    public final void validateHeaderArticles() {
        driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/stati/']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/stati/']")).
                getText(),"Статьи");
    }

    @Test
    public final void validateHeaderPortfolio() {
        driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/portfolio/']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/portfolio/']")).
                getText(),"Портфолио");
    }

    @Test
    public final void validateHeaderAboutUs() {
        driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/o-nas/']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/o-nas/']")).
                getText(),"О нас");
    }

    @Test
    public final void validateHeaderContacts() {
        driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/kontakti/']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/kontakti/']")).
                getText(),"Контакты");
    }

    @AfterTest
    public final void teardown() {
        if (driver != null) {
            driver.close();
        }
    }
}
