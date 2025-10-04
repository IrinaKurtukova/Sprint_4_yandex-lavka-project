package ru.yandex.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Скрол страницы до выпадающего списка и клик
    public void scrollPageDown() {
        WebElement element = driver.findElement(By.className("accordion"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickFirstAccordionButton() {
        driver.findElement(By.className("accordion__heading")).click();
    }


    //Проверка на соотвествие текста в выпадающем поле
    public void checkAccordionTextMenu() {
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String actual = driver.findElement(By.id("accordion__panel-0")).getText();
        Assert.assertEquals(expected, actual);
    }

    //Нажимаем на кнопку Заказать (вверху)
    public void clickFirstButtonToBook() {
        driver.findElement(By.className("Button_Button__ra12g")).click();
    }

    //Нажимаем на кнопку Заказать (внизу)
    public void clickSecondButtonToBook() {
        driver.findElement(By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM")).click();
    }
}
