import edu.praktikum.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class CheckScrollToOrderButton {
    private WebDriver webDriver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Test
    public void checkOrderButtonWithScroll() {
        MainPage mainPage = new MainPage(webDriver);

        mainPage.open()
                .orderButtons().clickOrderButtonWithScroll();
        assertTrue("Блок с формой заказа не появился",
                mainPage.orderScooterForm().checkScooterBlockIsVisible());
    }


    @After
    public void tearDown() {
        webDriver.quit();
    }
}

