package test;

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
    public void setupTest() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://autovinil76.ru");
    }

    @Test
    public void validateHeaderHome() {
        driver.findElement(By.cssSelector("div.menu a[href='/']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Наши услуги / ']")).
                getText(), "Наши услуги / Посмотреть все");
    }

    @Test
    public void validateHeaderServices() {
        headerValidator("Услуги", By.cssSelector("h1"), "Услуги");
    }

    @Test
    public void validateHeaderItems() {
        headerValidator("Товары", By.cssSelector("h1"), "Товары");
    }

    @Test
    public void validateHeaderPrices() {
        headerValidator("Цены", By.cssSelector("h1"), "Цены");
    }

    @Test
    public void validateHeaderSales() {
        headerValidator("Акции", By.cssSelector("h1"), "Акции");
    }

    @Test
    public void validateHeaderArticles() {
        headerValidator("Статьи", By.cssSelector("h1"), "Статьи");
    }

    @Test
    public void validateHeaderPortfolio() {
        headerValidator("Портфолио", By.cssSelector("h1"), "Портфолио");
    }

    @Test
    public void validateHeaderAboutUs() {
        headerValidator("О нас", By.cssSelector("h1"), "Автовинил в Ярославле – качественно, надежно и красиво!");
    }

    @Test
    public void validateHeaderContacts() {
        headerValidator("Контакты", By.cssSelector("h1"), "Контакты");
    }

    public void headerValidator(String linkedText, By locator, String pageName) {
        driver.findElement(By.linkText(linkedText)).click();
        Assert.assertEquals(driver.findElement(locator).getText(), pageName);
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.close();
        }
    }
}