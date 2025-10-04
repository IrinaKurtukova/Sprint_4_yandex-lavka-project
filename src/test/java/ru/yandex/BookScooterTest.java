package ru.yandex;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.yandex.data.PersonalDetails;
import ru.yandex.pages.*;


@RunWith(Parameterized.class)
public class BookScooterTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

//        FirefoxOptions options = new FirefoxOptions();
//        driver = new FirefoxDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    private final PersonalDetails personalDetails;

    public BookScooterTest(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    @Parameterized.Parameters
    public static Object[][] getPersonalDetails() {
        return new Object[][]{
                {new PersonalDetails("Иван", "Иванов", "Москва, ул. Тверская, 1", "Тверская")},
                {new PersonalDetails("Анна", "Петрова", "Санкт-Петербург, Невский проспект, 10", "Невский проспект")}
        };
    }

    @Test
    public void testOrderButtonUp() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFirstButtonToBook();
        mainPage.clickSecondButtonToBook();

        doOrder();
    }

    @Test
    public void testOrderButtonDown() {
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollPageDown();
        mainPage.clickFirstAccordionButton();
        mainPage.checkAccordionTextMenu();
        mainPage.clickSecondButtonToBook();

        doOrder();
    }

    private void doOrder() {
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.fillFieldsAuthorizationForm(personalDetails);
        authorizationPage.fillingMetroStationField(personalDetails);
        authorizationPage.fillingPhoneNumberField();
        authorizationPage.buttonFurther();

        RentScooterPage rentScooterPage = new RentScooterPage(driver);
        rentScooterPage.whenBringScooterField();
        rentScooterPage.rentalTerm();
        rentScooterPage.orderButtonLast();

        DialogPage dialogPage = new DialogPage(driver);
        dialogPage.buttonYesClick();

        SuccessfulOrderPage successfulOrderPage = new SuccessfulOrderPage(driver);
        successfulOrderPage.checkingTextInForm();
        successfulOrderPage.clickButtonStatus();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
