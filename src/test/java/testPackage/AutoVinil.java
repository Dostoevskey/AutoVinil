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

    protected WebDriver driver;

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
    public final void validateHeaderButtons() {
        Assert.assertTrue(driver.findElement(By.cssSelector("div.menu a[href='/'][class='active']")).
                getText().contains("Главная"), ("Главная is matching"));
        driver.findElement(By.cssSelector("div.block1 a[href='http://autovinil76.ru/uslugi/']")).click();
    }
}
