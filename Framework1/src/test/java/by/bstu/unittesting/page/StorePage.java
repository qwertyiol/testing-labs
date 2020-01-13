package by.bstu.unittesting.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StorePage extends StartPage {
    private final Logger logger = LogManager.getRootLogger();

    public StorePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public StorePage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Start page opened");
        return this;
    }
    @FindBy(className = "main-nav__list__ul_last")
    public WebElement storeButtonInMenu;

    @FindBy(xpath = "//*[@data-location=\"dzerjinskogo_19\"]")
    public WebElement storeItemGrushevka;

    @FindBy(xpath = "//*[@data-location=\"russiyanova\"]")
    public WebElement storeItemUruche;

    @FindBy(className = "b-map-balloon__main")
    public WebElement address;

}
