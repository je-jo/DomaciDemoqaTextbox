package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class HomePage {

    WebDriver driver;
    ArrayList<WebElement> cards;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public ArrayList<WebElement> getCards() {
        return (ArrayList<WebElement>) driver.findElements(By.className("card-body"));
    }

    // metode

    public void clickOnCard(String cardName) {
        for (int i = 0; i < getCards().size(); i++) {
            if (getCards().get(i).getText().equals(cardName)) {
                getCards().get(i).click();
                break;
            }
        }
    }
}
