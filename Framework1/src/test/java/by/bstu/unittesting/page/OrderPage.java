package by.bstu.unittesting.page;

import by.bstu.unittesting.model.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends StartPage {

    private final Logger logger = LogManager.getRootLogger();

    private final By signInButton = By.className("top-panel__userbar__auth__lbl");

    @FindBy(xpath = "\"//*[@id=\\\"edit-button-1\\\"]\"")
    private WebElement errorFieldLocator;


    @FindBy(xpath = "//*[@id=\"edit-order-number\"]")
    private WebElement originInput;

    private final By searchButtonLocator = By.className("search_button");



    public OrderPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Order page opened");
        return this;
    }

    public OrderPage selectOrderStatusButton() {
        WebElement statusButton = driver.findElement(By.xpath("//*[@id=\"panel\""));
        statusButton.click();
        logger.info("We clicked order button");
        return this;
    }

    public OrderPage fillInRouteInformation(Order order) {
        originInput.clear();
        originInput.sendKeys(order.getNumber());
        logger.info("Order number filled");
        return this;
    }

    public OrderPage okButton(){
        WebElement button = driver.findElement(By.xpath("//*[@id=\"edit-button-1\"]"));
        button.click();
        logger.info("Ok button was clicked");
        return this;
    }

    public String getErrorText() {
        return errorFieldLocator.getText();
    }
}
