package by.bstu.unittesting.page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage extends StartPage {
    private final Logger logger = LogManager.getRootLogger();

    public BasketPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/form/div/div/div[3]/table/tbody/tr[2]/td[1]/div/div[2]/div[2]/a")
    private WebElement bookNameInBasket;

    @FindBy(name = "promo-code")
    public WebElement couponInput;

    @FindBy(id = "promoCodeSubmit")
    public WebElement submitCouponButton;

    @FindBy(className = "i-popover_warning")
    public WebElement errorCouponMessage;

    public String returnBookNameInBasket() throws InterruptedException {
        Thread.sleep(2000);
        String bookName=bookNameInBasket.getText();
        logger.info("Get book name in basket");
        return bookName;
    }


}
