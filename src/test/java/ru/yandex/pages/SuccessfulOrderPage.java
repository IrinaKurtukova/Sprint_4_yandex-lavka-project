package ru.yandex.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessfulOrderPage {

    private final WebDriver driver;

    public SuccessfulOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Проверяем содержимое окна об успешном оформлении заказа
    public void checkingTextInForm() {
        String actual = driver.findElement(By.className("Order_ModalHeader__3FDaJ")).getText();
        String expected = "Заказ оформлен\nНомер заказа: .  Запишите его:\nпригодится, чтобы отслеживать статус";

        Assert.assertEquals(expected, actual);
    }

    //Кнопка Посмотреть статус
    public void clickButtonStatus() {
        driver.findElement(By.xpath("//button[text()='Посмотреть статус']")).click();
    }

}
