package edu.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImportantQuestions {
    private final WebDriver webDriver;
    private int index;

    public ImportantQuestions (WebDriver webDriver, int index) {
        this.webDriver = webDriver;
        this.index = index;
    }
    //Скролл до вопроса и клик по нему
    public void clickButton() {
        scrollTo();
        webDriver.findElements(By.cssSelector("div[role=button")).get(index).click();
    }
    //Раскрываем ответ на вопрос и забираем текст
    public String getAnswer() {
        return webDriver.findElements(By.cssSelector("div[role=region]")).get(index).getText();
    }
    //Метод скролла
    public void scrollTo() {
        WebElement element = webDriver.findElements(By.cssSelector("div[role=button]")).get(index);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
    }
}
