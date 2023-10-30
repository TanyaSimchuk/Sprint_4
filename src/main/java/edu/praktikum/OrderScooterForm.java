package edu.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.Keys.ARROW_DOWN;
import static org.openqa.selenium.Keys.ENTER;

public class OrderScooterForm {
    private final WebDriver webDriver;
    private By inputNameField = By.xpath(".//input[@placeholder='* Имя']");
    private By inputSurnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private By inputAdressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By inputMetroStationField = By.xpath(".//input[@placeholder='* Станция метро']");
    private By inputPhoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By buttonNext = By.xpath(".//button[text()='Далее']");


    public OrderScooterForm (WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    //Вводим имя
    public OrderScooterForm inputName(String userName) {
        webDriver.findElement(inputNameField).sendKeys(userName);
        return this;
    }
    //Вводим фамилию
    public OrderScooterForm inputSurname(String userSurname) {
        webDriver.findElement(inputSurnameField).sendKeys(userSurname);
        return this;
    }
    //Вводим адрес
    public OrderScooterForm inputAdress(String userAdress) {
        webDriver.findElement(inputAdressField).sendKeys(userAdress);
        return this;
    }
    //Вводим название станции метро
    public OrderScooterForm inputMetroStation(String metroStation) {
        webDriver.findElement(inputMetroStationField).sendKeys(ARROW_DOWN, metroStation, ENTER);
        return this;
    }
    //Вводим номер телефона
    public OrderScooterForm inputPhoneNumber(String userPhoneNumber) {
        webDriver.findElement(inputPhoneNumberField).sendKeys(userPhoneNumber);
        return this;
    }
    //Нажимаем кнопку Далее
    public OrderScooterForm clickButtonNext() {
        webDriver.findElement(buttonNext).click();
        return this;
    }

}
