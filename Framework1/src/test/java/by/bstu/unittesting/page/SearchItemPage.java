package by.bstu.unittesting.page;

import by.bstu.unittesting.model.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchItemPage extends StartPage {

    private final Logger logger = LogManager.getRootLogger();

    public SearchItemPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//*[@id=\"goods-table\"]/li[1]/div")
    private WebElement unoItem;

    @FindBy(xpath = "//*[@class=\"b-product-title__heading\"]")
    private WebElement itemName;

    private final By getInput=By.id("top-s");
    private final By search=By.className("top-panel__search__btn");


    public SearchItemPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Start page opened");
        return this;
    }

    public SearchItemPage setNameInInput(Item item) {

        WebElement input=driver.findElement(getInput);
        input.click();
        input.sendKeys(item.getName());
        logger.info("Input name");
        return this;
    }

    public SearchItemPage clickSearchButton(){
        WebElement searchButton=driver.findElement(search);
        searchButton.click();
        logger.info("Click search button");
        return this;
    }

    public SearchItemPage clickUnoItem() {
        unoItem.click();
        logger.info("Click uno item");
        return this;
    }

    public String getItemName(){
        String name=itemName.getText();
        logger.info("Get item name");
        return name;
    }






}
