package edu.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessfulOrderPopup {
    private final WebDriver webDriver;
    private By successfulOrder = By.xpath(".//div[1] [contains(text(), 'Заказ оформлен')]");

    public SuccessfulOrderPopup (WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    //Показ попапа успешно оформленного заказа
    public boolean checkSuccesfulOrderPopup() {
        return webDriver.findElements(successfulOrder).size() > 0;
    }

}
