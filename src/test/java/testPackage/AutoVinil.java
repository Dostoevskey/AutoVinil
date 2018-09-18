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
        driver.findElement(By.linkText(webelementLocator)).click();
        Assert.assertEquals(driver.findElement(By.linkText(webelementLocator)).
                getText(), pageName);
    }

    @Test
    public void validateHeaderHome() {
        driver.findElement(By.cssSelector("div.menu a[href='/']"));
        Assert.assertEquals(driver.findElement(By.linkText("Главная")).
                getText(), "Главная");
    }

    @Test
    public void validateHeaderServices() {
        headerValidator("Услуги", "Услуги");
    }

    @Test
    public void validateHeaderItems() {
        headerValidator("Товары", "Товары");
    }

    @Test
    public void validateHeaderPrices() {
        headerValidator("Цены", "Цены");
    }

    @Test
    public void validateHeaderSales() {
        headerValidator("Акции", "Акции");
    }

    @Test
    public void validateHeaderArticles() {
        headerValidator("Статьи", "Статьи");
    }

    @Test
    public void validateHeaderPortfolio() {
        headerValidator("Портфолио", "Портфолио");
    }

    @Test
    public void validateHeaderAboutUs() {
        headerValidator("О нас", "О нас");
    }

    @Test
    public void validateHeaderContacts() {
        headerValidator("Контакты", "Контакты");
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.close();
        }
    }
}
