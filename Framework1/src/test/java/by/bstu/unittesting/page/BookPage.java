package by.bstu.unittesting.page;

import by.bstu.unittesting.model.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookPage extends StartPage {
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[1]/div[1]/div/div/ul/li[2]/a")
    private WebElement bookMenuItem;

    private final By addToBasketButton=By.xpath("/html/body/div[1]/div/div[3]/div/div[1]/div/div[2]/div[3]/div/div[1]/div[2]/div/div[1]/form/button");
    private final By goToBasket=By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/ul/li[3]/a");
    private final By book=By.xpath("//*[contains(@class,'item-type-card__link')]");

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/h1")
    private WebElement bookName;

    public String getName(Book book){
        String name=bookName.getText();
        return name;
    }

    public BookPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public BookPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Start page opened");
        return this;
    }

    public BookPage clickMenuItem() {
        bookMenuItem.click();
        logger.info("We clicked Book menu item button");
        return this;
    }

    public BookPage clickBook() {
        WebElement bookItem=driver.findElement(book);
        bookItem.click();
        logger.info("Select first book");
        return this;
    }

    public BookPage clickAddToBasket() throws InterruptedException {

        WebElement addToBasket = driver.findElement(addToBasketButton);
        addToBasket.click();
        logger.info("Add to basket was clicked");
        return this;
    }

    public BookPage clickGoToBasket() throws InterruptedException {
        Thread.sleep(2000);
        WebElement goToBasketButton=driver.findElement(goToBasket);
        goToBasketButton.click();
        logger.info("Go to basket was clicked");
        return this;
    }

}
