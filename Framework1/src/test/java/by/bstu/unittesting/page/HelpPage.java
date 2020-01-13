package by.bstu.unittesting.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HelpPage extends StartPage {

    private final Logger logger = LogManager.getRootLogger();


    public HelpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(css = "#top-page > div.top-panel.page-init-scroll > div.top-panel__inner > ul > li:nth-child(6)")
    private WebElement helpButton;

    @FindBy(css = "#top-page > div.middle > div > div.right-col.cfix > div.for-editor > ul:nth-child(2) > li:nth-child(19) > a")
    private WebElement helpItem;

    @FindBy(css = "body > small > big")
    private WebElement helpTitle;


    public HelpPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Start page opened");
        return this;
    }

    public HelpPage clickHelp() {
        helpButton.click();
        logger.info("We clicked Help button");
        return this;
    }

    public HelpPage clickHelpItem() {
        helpItem.click();
        logger.info("We clicked Help item");
        return this;
    }

    public String getTitle(){
        String title=helpTitle.getText();
        logger.info("Get Help title");
        return title;
    }

}
