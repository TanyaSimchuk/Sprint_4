
import edu.praktikum.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderScooterCheckList {
    private WebDriver webDriver;

    @Parameterized.Parameter
    public String userName;
    @Parameterized.Parameter(1)
    public String userSurname;
    @Parameterized.Parameter(2)
    public String userAdress;
    @Parameterized.Parameter(3)
    public String metroStation;
    @Parameterized.Parameter(4)
    public String userPhoneNumber;
    @Parameterized.Parameter(5)
    public String deliveryDate;

    @Parameterized.Parameters(name = "Тест {index}: данные пользователя в заказе должны иметь параметры {0}, {1}, {2}, {3}, {4}, {5}")
    public static Object[][] orderCredentials() {
        return new Object[][] {
                { "Тест", "Тестов", "Тестовый адрес, 1", "Бульвар Рокоссовского", "+70000000000", "23.11.2023" },
                { "Иван", "Иванов", "Ивановская, 1", "Чистые пруды", "+71111111111", "31.12.2024" },
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
    public void checkPositiveOrderCheckList() {
        MainPage mainPage = new MainPage(webDriver);

        mainPage.open()
                .orderButtons().clickOrderButton();
        mainPage.orderScooterForm().inputName(userName)
                .inputSurname(userSurname)
                .inputAdress(userAdress)
                .inputMetroStation(metroStation)
                .inputPhoneNumber(userPhoneNumber)
                .clickButtonNext();
        mainPage.orderDeliveryDateScooterForm().inputDeliveryDate(deliveryDate)
                .clickRentalPeriodField()
                .chooseRentalPeriod()
                .submitOrder()
                .confirmOrder();

        assertTrue("Не показано сообщение об успешном оформлении заказа",
                mainPage.successfulOrderPopup().checkSuccesfulOrderPopup());

    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}