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

    //Поле Когда привезти самокат
    public void whenBringScooterField() {
        driver.findElement(By.xpath("//*[@placeholder='* Когда привезти самокат']")).click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__month-container")));


        driver.findElement(By.xpath("//*[@aria-label='Choose среда, 8-е октября 2025 г.']")).click();
    }

    //Поле Срок аренды
    public void rentalTerm() {
        driver.findElement(By.className("Dropdown-control")).click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Dropdown-menu")));

        driver.findElement(By.xpath("//div[@role='option' and text()='четверо суток']")).click();
    }

    //Кнопка Заказать (внизу)
    public void orderButtonLast() {
        driver.findElement(By.xpath("//button[contains(@class, 'Button_Middle__1CSJM') and text()='Заказать']")).click();
    }
}
