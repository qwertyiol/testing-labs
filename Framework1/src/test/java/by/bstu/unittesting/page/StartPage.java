package by.bstu.unittesting.page;

import org.openqa.selenium.WebDriver;

public abstract class StartPage {

   // protected static final int SECONDS_TO_LOAD = 30;

    protected WebDriver driver;
    public static final String PAGE_URL = "https://oz.by/";

    protected StartPage(WebDriver driver) {
        this.driver = driver;
    }
}
