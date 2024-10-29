package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class TextBoxTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://demoqa.com/");
    }

    @Test
    public void userCanEnterValidEmail() {
        // podaci
        ArrayList<String> listaPodataka = new ArrayList<>();
        listaPodataka.add("Pera");
        listaPodataka.add("pera@peric.com");
        listaPodataka.add("123 Fake Street");
        listaPodataka.add("125 Fake Street");
        // koraci
        homePage.clickOnCard("Elements");
        sidebarPage.clickOnElement("Text Box");
        textBoxPage.enterName(listaPodataka.get(0));
        textBoxPage.enterEmail(listaPodataka.get(1));
        textBoxPage.enterAddressCurr(listaPodataka.get(2));
        textBoxPage.enterAddressPerm(listaPodataka.get(3));
        scrollToElement(textBoxPage.getBtnSubmit());
        textBoxPage.clickSubmit();
        // asertacija
        for (int i = 0; i < textBoxPage.getOutputStrings().size(); i++) {
            String fullOutputText = textBoxPage.getOutputStrings().get(i).getText();
            String relevantOutput = fullOutputText.substring(fullOutputText.lastIndexOf(":") + 1);
            Assert.assertEquals(relevantOutput, listaPodataka.get(i));
        }
    }

    @Test
    public void userCannotEnterInvalidEmail() {
        // podaci
        ArrayList<String> listaPodataka = new ArrayList<>();
        listaPodataka.add("Pera");
        listaPodataka.add("pera@peric");
        listaPodataka.add("123 Fake Street");
        listaPodataka.add("125 Fake Street");
        // koraci
        homePage.clickOnCard("Elements");
        sidebarPage.clickOnElement("Text Box");
        textBoxPage.enterName(listaPodataka.get(0));
        textBoxPage.enterEmail(listaPodataka.get(1));
        textBoxPage.enterAddressCurr(listaPodataka.get(2));
        textBoxPage.enterAddressPerm(listaPodataka.get(3));
        scrollToElement(textBoxPage.getBtnSubmit());
        textBoxPage.clickSubmit();
        // asertacija
        String classes = textBoxPage.getInputEmail().getAttribute("class");
        Assert.assertTrue(classes.contains("field-error"));
    }

    @AfterMethod
    public void clearInput() {
        textBoxPage.getInputName().clear();
        textBoxPage.getInputEmail().clear();
        textBoxPage.getInputAddressCurr().clear();
        textBoxPage.getInputAddressPerm().clear();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}