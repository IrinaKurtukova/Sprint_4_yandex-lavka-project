package ru.yandex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RentScooterPage {

    private final WebDriver driver;

    public RentScooterPage(WebDriver driver) {
        this.driver = driver;
    }

    //Поле "Когда привезти самокат"
    private final By chooseDateToBringScooterField = By.xpath("//*[@placeholder='* Когда привезти самокат']");
    //Календаль в поле "Когда привезти самокат"
    private final By calendar = By.className("react-datepicker__month-container");
    //Выбор даты в календаре поля "Когда привезти самокат"
    private final By calendarDate = By.xpath("//*[@aria-label='Choose среда, 8-е октября 2025 г.']");
    //Поле "Срок аренды"
    private final By rentalField = By.className("Dropdown-control");
    //Значение в поле "Срок аренды"
    private final By rentalDuration = By.xpath("//div[@role='option' and text()='четверо суток']");
    //Кнопка Заказать (внизу)
    private final By buttonToOrderLast = By.xpath("//button[contains(@class, 'Button_Middle__1CSJM') and text()='Заказать']");


    //Поле Когда привезти самокат
    public void whenBringScooterField() {
        driver.findElement(chooseDateToBringScooterField).click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(calendar));

        driver.findElement(calendarDate).click();
    }

    //Поле Срок аренды
    public void rentalTerm() {
        driver.findElement(rentalField).click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(rentalField));

        driver.findElement(rentalDuration).click();
    }

    //Кнопка Заказать (внизу)
    public void orderButtonLast() {
        driver.findElement(buttonToOrderLast).click();
    }
}