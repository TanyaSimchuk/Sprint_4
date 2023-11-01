package edu.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    public static final String URL = "https://qa-scooter.praktikum-services.ru";
    private final WebDriver webDriver;


    private SuccessfulOrderPopup successfulOrderPopup;
    private OrderScooterForm orderScooterForm;
    private OrderDeliveryDateScooterForm orderDeliveryDateScooterForm;
    private OrderButtons orderButtons;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        successfulOrderPopup = new SuccessfulOrderPopup(webDriver);
        orderScooterForm = new OrderScooterForm(webDriver);
        orderDeliveryDateScooterForm = new OrderDeliveryDateScooterForm(webDriver);
        orderButtons = new OrderButtons(webDriver);
    }
    public MainPage open() {
        webDriver.get(URL);
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

    public OrderButtons orderButtons() {
        return orderButtons;
    }

}