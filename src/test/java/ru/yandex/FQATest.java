package ru.yandex;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.pages.MainPage;

public class FQATest {

    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void accordionClickTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollPageDown();
        mainPage.clickFirstAccordionButton1();
        mainPage.checkAccordionTextMenu1();
        mainPage.clickFirstAccordionButton2();
        mainPage.checkAccordionTextMenu2();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
