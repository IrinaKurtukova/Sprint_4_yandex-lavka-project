package ru.yandex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DialogPage {

    private final WebDriver driver;

    public DialogPage(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка "Да"
    public void buttonYesClick() {
        driver.findElement(By.xpath("//button[contains(@class, 'Button_Middle__1CSJM') and text()='Да']")).click();
    }

}
