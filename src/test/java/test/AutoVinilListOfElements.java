package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class AutoVinilListOfElements {

    public static WebDriver driver;


    @BeforeTest
    public void setupTest() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://autovinil76.ru");
    }

    public void headerValidator(String linkedText, By locator, String pageName) {
        driver.findElement(By.linkText(linkedText)).click();
        Assert.assertEquals(driver.findElement(locator).getText(), pageName);
    }


/*
    https://stackoverflow.com/questions/17746565/verify-list-elements-by-selenium-webdriver#17746738

    // assert that the number of found <option> elements matches the expectations
    assertEquals(exp.length, allOptions.size());
// assert that the value of every <option> element equals the expected value
for(
    int i = 0;
    i<exp.length;i++)

    {
        assertEquals(exp[i], allOptions.get(i).getAttribute("value"));
    }

    String[] expected = {"GRAM", "OUNCE", "POUND", "MILLIMETER", "TSP", "TBSP", "FLUID_OUNCE"};
    List<WebElement> allOptions = select.findElements(By.tagName("option"));

// make sure you found the right number of elements
if(expected.length !=allOptions.size())

    {
        System.out.println("fail, wrong number of elements found");
    }
// make sure that the value of every <option> element equals the expected value
for(
    int i = 0;
    i<expected.length;i++)

    {
        String optionValue = allOptions.get(i).getAttribute("value");
        if (optionValue.equals(expected[i])) {
            System.out.println("passed on: " + optionValue);
        } else {
            System.out.println("failed on: " + optionValue);
        }
    }
*/

/*    http://pgu-uat-fed.test.gosuslugi.ru/eds
    WebElement uploadElement = driver.findElement(By.xpath("//*[@id='html5_1co1b846uja2dk614l91v8f1dca4']"));

// enter the file path onto the file-selection input field
uploadElement.sendKeys("src/main/resources/720.png");
*/

    public void listOfHeaders() {
        List<WebElement> elementList = driver.findElements(By.cssSelector("div.block1 li"));

        for (WebElement currentListOfHeaders : elementList) {
            String strLinkText = currentListOfHeaders.getText();

            System.out.println(strLinkText);
        }
    }

    @Test
    public void printListOfHeaders() {
        listOfHeaders();
    }

//    public void listOfHeaders(String textHeader) {
//        List<WebElement> =
//    }
//
//    $$("div.block1 li")

    @Test
    public void validateHeaderHome() {
        driver.findElement(By.cssSelector("div.menu a[href='/']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Наши услуги / ']")).getText(), "Наши услуги / Посмотреть все");
    }

    @Test
    public void validateHeaderServices() {
        headerValidator("Услуги", By.cssSelector("h1"), "Услуги"); //another By.cssSelector("div.title span")
        //driver.getTitle()
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

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.close();
        }
    }
}