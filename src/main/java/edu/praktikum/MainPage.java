package edu.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    public static final String URL = "https://qa-scooter.praktikum-services.ru";
    private final WebDriver webDriver;
    private By orderButton = By.xpath(".//button[@class='Button_Button__ra12g' and (text()='Заказать')]");


    private SuccessfulOrderPopup successfulOrderPopup;
    private OrderScooterForm orderScooterForm;
    private OrderDeliveryDateScooterForm orderDeliveryDateScooterForm;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        successfulOrderPopup = new SuccessfulOrderPopup(webDriver);
        orderScooterForm = new OrderScooterForm(webDriver);
        orderDeliveryDateScooterForm = new OrderDeliveryDateScooterForm(webDriver);
    }
    public MainPage open() {
        webDriver.get(URL);
        return this;
    }
    //Нажатие кнопки Заказать на главной странице
    public MainPage clickOrderButton() {
        webDriver.findElement(orderButton).click();
        return this;
    }


    public SuccessfulOrderPopup successfulOrderPopup() {
        return successfulOrderPopup;
    }

    public OrderScooterForm orderScooterForm() {
        return orderScooterForm;
    }

    public OrderDeliveryDateScooterForm orderDeliveryDateScooterForm() {
        return orderDeliveryDateScooterForm;
    }

}