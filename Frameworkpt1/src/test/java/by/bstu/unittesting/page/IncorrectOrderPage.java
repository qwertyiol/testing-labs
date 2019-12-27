package by.bstu.unittesting.page;

import by.bstu.unittesting.model.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import by.bstu.unittesting.model.Route;

public class IncorrectOrderPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    private static final String PAGE_URL = "https://oz.by/";

    private final By signInButton = By.className("top-panel__userbar__auth__lbl");


    @FindBy(xpath = "/html/body/div[4]/div/div/div/div[1]/div[3]/div/div[2]/form/div[2]/div[2]/div/div/div")
    private WebElement warningMessage;

    @FindBy(partialLinkText = "зарегистриуйтесь")
    private WebElement warningMessagee;

    @FindBy(xpath = "//*[@id=\"formInputLoginPhone\"]")
    private  WebElement inputPhoneNumber;

    /*@FindBy(xpath = "\"//*[@id=\\\"edit-button-1\\\"]\"")
    private WebElement errorFieldLocator;
*/
/*
    @FindBy(xpath = "//*[@id=\"edit-order-number\"]")
    private WebElement originInput;*/

/*
    private final By searchButtonLocator = By.className("search_button"); */

    private final By getSmsButton=By.cssSelector("#phoneForm > button");


    public IncorrectOrderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public IncorrectOrderPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Start page opened");
        return this;
    }

    public IncorrectOrderPage /*selectOrderStatusButton*/ clickSignInButton() {
        WebElement statusButton = driver.findElement(signInButton);
        statusButton.click();
        logger.info("We clicked SignIn button");
        return this;
    }

    public IncorrectOrderPage /*fillInRouteInformation*/ inputPhone(Order order) {
        inputPhoneNumber.clear();
        inputPhoneNumber.sendKeys("+375"+order.getNumber());
        logger.info("Input phone number "+order.getNumber());
        return this;
    }

    public IncorrectOrderPage /*okButton*/ clickGetSmsButton() throws InterruptedException {

        WebElement button = driver.findElement(getSmsButton);
        button.click();
        logger.info("Get SMS button was clicked");
        return this;
    }

    public String getErrorText() throws InterruptedException {
        Thread.sleep(5000);
        return warningMessage.getText();
    }

    public String getErrorTextt() {
        WebElement test = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div/div/div[1]/div[3]/div/div[2]/form/div[2]/div[2]/div/div/div")));

        return warningMessage.getText();
    }
}
