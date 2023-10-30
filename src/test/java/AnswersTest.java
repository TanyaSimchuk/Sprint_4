
import edu.praktikum.ImportantQuestions;
import edu.praktikum.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnswersTest {

    private WebDriver webDriver;

    @Parameterized.Parameter
    public String answer;
    @Parameterized.Parameter(1)
    public int index;

    @Parameterized.Parameters
    public static Object [][] getData() {
        return new Object[][] {
                { "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0},
                { "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", 1},
                { "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", 2},
                { "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3},
                { "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", 4},
                { "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", 5},
                { "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6},
                { "Да, обязательно. Всем самокатов! И Москве, и Московской области.", 7},
        };
    }

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void checkAnswersText() {
        MainPage mainPage = new MainPage(webDriver);

        mainPage.open();
        ImportantQuestions questionsBlock = new ImportantQuestions(webDriver, index);
        questionsBlock.clickButton();
        assertEquals("Текст выведенного ответа не соответствует заданному в массиве", answer, questionsBlock.getAnswer());
        System.out.println(answer);
        System.out.println(questionsBlock.getAnswer());
    }


    @After
    public void tearDown() {
        webDriver.quit();
    }

}

