package ru.yandex;

import com.sun.tools.javac.Main;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.pages.MainPage;

import static ru.yandex.pages.MainPage.PageURL;


@RunWith(Parameterized.class)
public class FQATest {

    private WebDriver driver;
    private final int questionIndex;
    private final String expectedAnswer;

    public FQATest(int questionIndex, String expectedAnswer) {
        this.questionIndex = questionIndex;
        this.expectedAnswer = expectedAnswer;
    }

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get(PageURL);
    }

    @Parameterized.Parameters(name = "Проверка текста в разделе FAQ #{0}")
    public static Object[][] getFAQData() {
        return new Object[][] {
                {0, MainPage.expectedTextFAQRentAndPayment},
                {1, MainPage.expectedTextFAQSeveralScooters},
                {2, MainPage.expectedTextFAQRentTime},
                {3, MainPage.expectedTextFAQOrderToday},
                {4, MainPage.expectedTextFAQProlongation},
                {5, MainPage.expectedTextFAQAboutCharger},
                {6, MainPage.expectedTextFAQCancellation},
                {7, MainPage.expectedTextFAQMKAD}
        };
    }

    @Test
    public void accordionClickTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollPageDown();
        mainPage.clickAccordionButton(questionIndex);
        mainPage.checkAccordionTextMenu(questionIndex, expectedAnswer);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}