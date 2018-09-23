package testPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GosUslugiFileUpload {

    public static WebDriver driver;

    @BeforeTest
    public void setupTest() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://pgu-uat-fed.test.gosuslugi.ru/eds");
    }

    @Test
    public void chooseRegion() {
        driver.findElement(By.xpath("//div[text()='Выбрать вручную']")).isDisplayed();
        driver.findElement(By.xpath("//div[text()='Выбрать вручную']")).click();
        driver.findElement(By.xpath("//label[text()='Название населенного пункта']")).isEnabled();
        driver.findElement(By.xpath("//label[text()='Название населенного пункта']")).click();
        driver.findElement(By.xpath("//label[text()='Название населенного пункта']").senDKeys

//        driver.switchTo().frame(driver.findElement());
//        driver.switchTo(By.ByLinkText("Название населенного пункта"));

    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.close();
        }
    }


}
