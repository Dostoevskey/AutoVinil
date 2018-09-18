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

    public static WebDriver driver;


    @BeforeTest
    public void setupTest() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://autovinil76.ru");
    }

    public void headerValidator(String webelementLocator, String pageName) {
        driver.findElement(By.cssSelector(webelementLocator)).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(webelementLocator)).
                getText(), pageName);
    }

    @Test
    public void validateHeaderHome() {
        headerValidator("div.menu a[href='/']", "Главная");
    }

    @Test
    public void validateHeaderServices() {
        headerValidator("div.block1 a[href='http://autovinil76.ru/uslugi/']", "Услуги");
    }

    @Test
    public void validateHeaderItems() {
        headerValidator("div.block1 a[href='http://autovinil76.ru/tovari/']", "Товары");
    }

    @Test
    public void validateHeaderPrices() {
        headerValidator("div.block1 a[href='http://autovinil76.ru/ceni/']", "Цены");
    }

    @Test
    public void validateHeaderSales() {
        headerValidator("div.block1 a[href='http://autovinil76.ru/akcii/']", "Акции");
    }

    @Test
    public void validateHeaderArticles() {
        headerValidator("div.block1 a[href='http://autovinil76.ru/stati/']", "Статьи");
    }

    @Test
    public void validateHeaderPortfolio() {
        headerValidator("div.block1 a[href='http://autovinil76.ru/portfolio/']", "Портфолио");
    }

    @Test
    public void validateHeaderAboutUs() {
        headerValidator("div.block1 a[href='http://autovinil76.ru/o-nas/']", "О нас");
    }

    @Test
    public void validateHeaderContacts() {
        headerValidator("div.block1 a[href='http://autovinil76.ru/kontakti/']", "Контакты");
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.close();
        }
    }
}
