package ru.yandex.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private final WebDriver driver;

    public static final String PageURL = "https://qa-scooter.praktikum-services.ru/";
    public static final String expectedTextFAQRentAndPayment = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String expectedTextFAQSeveralScooters = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String expectedTextFAQRentTime = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String expectedTextFAQOrderToday = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String expectedTextFAQProlongation = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String expectedTextFAQAboutCharger = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String expectedTextFAQCancellation = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String expectedTextFAQMKAD = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Контейнер "Вопросы о важном"
    private final By questionsListFAQ = By.className("accordion");
    //Кнопка Заказать (вверху)
    private final By firstButtonToBook = By.className("Button_Button__ra12g");
    //Кнопка Заказать (внизу)
    private final By secondButtonToBook = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    //Скрол страницы до выпадающего списка и клик
    public void scrollPageDown() {
        WebElement element = driver.findElement(questionsListFAQ);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickAccordionButton(int index) {
        driver.findElement(By.id("accordion__heading-" + index)).click();
    }

    //Проверка на соотвествие текста в выпадающем поле
    public void checkAccordionTextMenu(int index, String expectedText) {
        String actual = driver.findElement(By.id("accordion__panel-" + index)).getText();
        Assert.assertEquals(expectedText, actual);
    }
    //Нажимаем на кнопку Заказать (вверху)
    public void clickFirstButtonToBook() {
        driver.findElement(firstButtonToBook).click();
    }

    //Нажимаем на кнопку Заказать (внизу)
    public void clickSecondButtonToBook() {
        driver.findElement(secondButtonToBook).click();
    }
}