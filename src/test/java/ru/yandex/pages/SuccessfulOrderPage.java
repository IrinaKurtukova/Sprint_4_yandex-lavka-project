package ru.yandex.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessfulOrderPage {

    private final WebDriver driver;

    public SuccessfulOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Текстовый элемент в форме об успешном оформлении заказа
    private final By textInForm = By.className("Order_ModalHeader__3FDaJ");
    //Кнопка Посмотреть статус
    private final By buttonStatus = By.xpath("//button[text()='Посмотреть статус']");

    //Проверяем содержимое окна об успешном оформлении заказа
    public void checkingTextInForm() {
        String actual = driver.findElement(textInForm).getText();
        String expected = "Заказ оформлен\nНомер заказа: .  Запишите его:\nпригодится, чтобы отслеживать статус";

        Assert.assertEquals(expected, actual);
    }

    //Кнопка Посмотреть статус
    public void clickButtonStatus() {
        driver.findElement(buttonStatus).click();
    }

}
