package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class TextBoxPage {

    WebDriver driver;
    WebElement inputName;
    WebElement inputEmail;
    WebElement inputAddressCurr;
    WebElement inputAddressPerm;
    WebElement btnSubmit;
    ArrayList<WebElement> outputStrings;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getInputName() {
        return driver.findElement(By.id("userName"));
    }

    public WebElement getInputEmail() {
        return driver.findElement(By.id("userEmail"));
    }

    public WebElement getInputAddressCurr() {
        return driver.findElement(By.id("currentAddress"));
    }

    public WebElement getInputAddressPerm() {
        return driver.findElement(By.id("permanentAddress"));
    }

    public WebElement getBtnSubmit() {
        return driver.findElement(By.id("submit"));
    }

    public ArrayList<WebElement> getOutputStrings() {
        return (ArrayList<WebElement>) driver.findElements(By.className("mb-1"));
    }

    // metode

    public void enterName(String name) {
        getInputName().sendKeys(name);
    }

    public void enterEmail(String email) {
        getInputEmail().sendKeys(email);
    }

    public void enterAddressCurr(String address) {
        getInputAddressCurr().sendKeys(address);
    }

    public void enterAddressPerm(String address) {
        getInputAddressPerm().sendKeys(address);
    }

    public void clickSubmit() {
        getBtnSubmit().click();
    }
}
