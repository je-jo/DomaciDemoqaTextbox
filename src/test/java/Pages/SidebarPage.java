package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class SidebarPage {

    WebDriver driver;
    ArrayList<WebElement> elements;

    public SidebarPage(WebDriver driver) {
        this.driver = driver;
    }

    public ArrayList<WebElement> getElements() {
        return (ArrayList<WebElement>) driver.findElements(By.cssSelector(".btn.btn-light "));
    }

    // metode

    public void clickOnElement(String cardName) {
        for (int i = 0; i < getElements().size(); i++) {
            if (getElements().get(i).getText().equals(cardName)) {
                getElements().get(i).click();
                break;
            }
        }
    }
}
