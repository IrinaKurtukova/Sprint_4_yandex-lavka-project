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

    // Поля Имя, Фамилия, Адрес, куда привезти
    public void fillFieldsAuthorizationForm(PersonalDetails personalDetails) {
        driver.findElement(By.xpath("//*[@placeholder='* Имя']")).sendKeys(personalDetails.name);
        driver.findElement(By.xpath("//*[@placeholder='* Фамилия']")).sendKeys(personalDetails.surname);
        driver.findElement(By.xpath("//*[@placeholder='* Адрес: куда привезти заказ']")).sendKeys(personalDetails.address);

    }

    //Поле Станция метро
    public void fillingMetroStationField(PersonalDetails personalDetails) {
        driver.findElement(By.xpath("//*[@placeholder='* Станция метро']")).click();
        driver.findElement(By.xpath("//*[@placeholder='* Станция метро']")).sendKeys(personalDetails.stationName);

        new WebDriverWait(driver, Duration.ofSeconds(7))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("select-search__select")));

        driver.findElement(By.className("Order_Text__2broi")).click();
    }

    //Поле Телефон
    public void fillingPhoneNumberField() {
        driver.findElement(By.xpath("//*[@placeholder='* Телефон: на него позвонит курьер']")).click();
        driver.findElement(By.xpath("//*[@placeholder='* Телефон: на него позвонит курьер']")).sendKeys("+79269999999");
    }

    //Кнопка Далее
    public void buttonFurther() {
        driver.findElement(By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM")).click();
    }
}
