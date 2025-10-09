package ru.yandex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DialogPage {

    private final WebDriver driver;

    public DialogPage(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка "Да"
    private final By buttonYes = By.xpath("//button[contains(@class, 'Button_Middle__1CSJM') and text()='Да']");

    //Нажимаем на кнопку "Да"
    public void buttonYesClick() {
        driver.findElement(buttonYes).click();
    }
}