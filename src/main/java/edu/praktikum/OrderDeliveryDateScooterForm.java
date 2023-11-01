package edu.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.Keys.ENTER;


public class OrderDeliveryDateScooterForm {
    private final WebDriver webDriver;
    private By inputDeliveryDateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By rentalPeriodField = By.xpath(".//div[1][@class='Dropdown-placeholder']");
    private By chooseRentalPeriodField = By.xpath(".//div[text()='сутки']");
    private By submitOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and (text()='Заказать')]");
    private By confirmOrderButton = By.xpath(".//button[text()='Да']");

    public OrderDeliveryDateScooterForm(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //Вводим значение даты доставки
    public OrderDeliveryDateScooterForm inputDeliveryDate(String deliveryDate) {
        webDriver.findElement(inputDeliveryDateField).sendKeys(deliveryDate, ENTER);
        return this;
    }
    //Активируем поле выбора срока аренды
    public OrderDeliveryDateScooterForm clickRentalPeriodField() {
        webDriver.findElement(rentalPeriodField).click();
        return this;
    }
    //Выбираем срок аренды
    public OrderDeliveryDateScooterForm chooseRentalPeriod() {
        webDriver.findElement(chooseRentalPeriodField).click();
        return this;
    }
    //Нажимаем кнопку Заказать
    public OrderDeliveryDateScooterForm submitOrder() {
        webDriver.findElement(submitOrderButton).click();
        return this;
    }
    //Подтверждаем заказ
    public OrderDeliveryDateScooterForm confirmOrder() {
        webDriver.findElement(confirmOrderButton).click();
        return this;
    }
}
