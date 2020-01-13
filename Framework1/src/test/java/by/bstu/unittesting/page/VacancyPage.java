package by.bstu.unittesting.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VacancyPage extends StartPage {

    private final Logger logger = LogManager.getRootLogger();

    public VacancyPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[1]/ul[2]/li[3]/a" /*"(//li[@class='footer-full__nav-item'])[7]"*/)
    private WebElement vacancyButton;

    @FindBy(xpath = "//*[@id=\"top-page\"]/div[3]/div/div[1]/div/div[2]/div[1]/div/div/div/div/div/ul/li[2]/a")
    private WebElement vacancyBorisov;

    @FindBy(xpath = "//*[@id=\"top-page\"]/div[3]/div/div[1]/div/div[2]/div[1]/div/div/div/div/div/ul/li[1]/a")
    private WebElement vacancyOstrovec;

    @FindBy(xpath = "//*[@id=\"top-page\"]/div[3]/div/div[1]/div/div[1]/h1")
    public WebElement vacancyTitile;

    @FindBy(xpath = "//*[@id=\"favsoclink\"]/span/span")
    private WebElement shareButton;

    @FindBy(xpath = "//*[@id=\"pp-sharesocial\"]/ul/li[2]/a")
    private WebElement vkButton;

    @FindBy(xpath = "//*[@id=\"oauth_wrap_content\"]/div[2]/div")
    public WebElement vk;

    @FindBy(className = "yellow-small-desc")
    private WebElement writeToUsButton;

    @FindBy(className = "button-big")
    public WebElement sendVacancy;

    public VacancyPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Start page opened");
        return this;
    }

    public VacancyPage goToVacancyPage() throws InterruptedException {

        vacancyButton.click();
        Thread.sleep(1000);
        logger.info("Click vacancy button and go to");
        return this;
    }

    public VacancyPage viewBorisovVacancy(){
        vacancyBorisov.click();
        logger.info("Go to Borisov vacancy");
        return this;
    }

    public VacancyPage viewOstrovecVacancy(){
        vacancyOstrovec.click();
        logger.info("Go to Ostrovec vacancy");
        return this;
    }

    public VacancyPage checkVK() throws InterruptedException {
        shareButton.click();
        logger.info("Click share button");
        vkButton.click();
        logger.info("Click VK button");
        Thread.sleep(2000);
        return this;
    }

    public VacancyPage clickWriteUs(){
        writeToUsButton.findElement(By.tagName("a")).click();
        logger.info("Write us click");
        return this;
    }
}
