package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class GosUslugiFileUpload {

    public static WebDriver driver;

    @BeforeTest
    public void setupTest() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://pgu-uat-fed.test.gosuslugi.ru");
    }

    @Test
    public void chooseRegion() throws InterruptedException {
        //driver.findElement(By.xpath("//div[text()='Выбрать вручную']")).isDisplayed();
        //driver.findElement(By.xpath("//em[@class='wrapper w50']//span[@class='icon']")).isDisplayed();
        sleep(3000);
        driver.findElement(By.xpath("//div[text()='Выбрать вручную']")).click();
        //driver.findElement(By.xpath("//*[@class='wrapper w50']")).click();
//        driver.findElement(By.xpath("*//em[@class='wrapper w50']")).isDisplayed();
//        driver.findElement(By.xpath("*//em[@class='wrapper w50']")).click();
//        driver.findElement(By.xpath("//label[text()='Название населенного пункта']")).isDisplayed();
//        driver.findElement(By.xpath("//label[text()='Название населенного пункта']")).click();
        sleep(3000);
        driver.findElement(By.xpath("*//input[@type='search']")).sendKeys("Москва");

        //driver.switchTo().frame("*//div[@class='fields-cover']");

//        driver.findElement(By.xpath("//label[@ng-if]")).isDisplayed();
//        driver.findElement(By.xpath("//label[@ng-if]")).click();
//        driver.findElement(By.xpath("//div[@class='select-el']")).isDisplayed();
//        driver.findElement(By.xpath("//div[@class='select-el']")).click();


//        driver.findElement(By.xpath("*//input[@type='search']")).click();

        driver.findElement(By.xpath("//label[text()='Название населенного пункта']")).sendKeys("Москва");

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
