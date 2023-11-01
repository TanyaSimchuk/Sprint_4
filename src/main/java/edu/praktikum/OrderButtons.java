package edu.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderButtons {
    private final WebDriver webDriver;

    private By orderButton = By.xpath(".//button[@class='Button_Button__ra12g' and (text()='Заказать')]");

    private By orderButtonWithScroll = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public OrderButtons (WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //Нажатие кнопки Заказать на главной странице вверху
    public OrderButtons clickOrderButton() {
        webDriver.findElement(orderButton).click();
        return this;
    }
    //Нажатие кнопки Заказать на главной странице в середине
    public OrderButtons clickOrderButtonWithScroll() {
        WebElement element = webDriver.findElement(orderButtonWithScroll);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
        webDriver.findElement(orderButtonWithScroll).click();
        return this;
    }
}
