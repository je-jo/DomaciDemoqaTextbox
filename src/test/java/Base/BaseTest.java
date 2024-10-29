package Base;

import Pages.HomePage;
import Pages.SidebarPage;
import Pages.TextBoxPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    /*
    Domaci:
    Otici na https://demoqa.com/ sajt, zatim na elements->text box
    i testirati popunjavanje forme sa validnim, nevalidnim mail-om
    i proveriti da li je output ispravan za svako polje
     */

    public WebDriver driver;
    public HomePage homePage;
    public SidebarPage sidebarPage;
    public TextBoxPage textBoxPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        homePage = new HomePage(driver);
        sidebarPage = new SidebarPage(driver);
        textBoxPage = new TextBoxPage(driver);
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }


}
