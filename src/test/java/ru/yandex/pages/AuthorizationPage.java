package ru.yandex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.data.PersonalDetails;

import java.time.Duration;

public class AuthorizationPage {

    private final WebDriver driver;

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }

    //Поле Имя
    private final By nameField = By.xpath("//*[@placeholder='* Имя']");
    //Поле Фамилия
    private final By surnameField = By.xpath("//*[@placeholder='* Фамилия']");
    //Поле Адрес, куда привезти
    private final By addressField = By.xpath("//*[@placeholder='* Адрес: куда привезти заказ']");
    //Поле Станция метро
    private final By metroStationField = By.xpath("//*[@placeholder='* Станция метро']");
    //Поле Станция метро -> выпадает список
    private final By metroStationDropdown = By.className("select-search__select");
    //Название станции из выпадающего списка
    private final By metroStationName = By.className("Order_Text__2broi");
    //Поле Телефон
    private final By phoneField = By.xpath("//*[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка Далее
    private final By buttonFurther = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");


    // Заполнение полей Имя, Фамилия, Адрес, куда привезти
    public void fillFieldsAuthorizationForm(PersonalDetails personalDetails) {
        driver.findElement(nameField).sendKeys(personalDetails.name);
        driver.findElement(surnameField).sendKeys(personalDetails.surname);
        driver.findElement(addressField).sendKeys(personalDetails.address);
    }

    //Поле Станция метро
    public void fillingMetroStationField(PersonalDetails personalDetails) {
        driver.findElement(metroStationField).click();
        driver.findElement(metroStationField).sendKeys(personalDetails.stationName);

        new WebDriverWait(driver, Duration.ofSeconds(7))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(metroStationDropdown));

        driver.findElement(metroStationName).click();
    }

    //Поле Телефон
    public void fillingPhoneNumberField() {
        driver.findElement(phoneField).click();
        driver.findElement(phoneField).sendKeys("+79269999999");
    }

    //Кнопка Далее
    public void buttonFurtherClick() {
        driver.findElement(buttonFurther).click();
    }
}